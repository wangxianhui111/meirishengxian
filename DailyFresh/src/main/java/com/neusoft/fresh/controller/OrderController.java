package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Goods;
import com.neusoft.fresh.model.Order;
import com.neusoft.fresh.model.User;
import com.neusoft.fresh.service.CartService;
import com.neusoft.fresh.service.GoodsService;
import com.neusoft.fresh.service.OrderService;
import com.neusoft.fresh.service.UserService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GoodsService goodsService;
    
    @Autowired
    private CartService cartService;

    /**
     * 新增
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Order order){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    	order.setOrder_time(sdf.format(new Date()));
    	order.setStatus("0");
    	System.out.println("order: "+order.toString());
    	
    	Goods goods = goodsService.selectByPrimaryKey(order.getGoodsid());
    	
    	int inventory = goods.getInventory();
    	System.out.println("inventory:"+inventory);
    	System.out.println("getGoodsid:"+order.getGoodsid());
    	inventory=inventory-order.getNum();
    	if (inventory<0) {
    		System.out.println("该商品库存不足，无法订购！");
    		return ResultGenerator.genFailResult("该商品库存不足，无法订购！");
		}
    	BigDecimal orderPrice = order.getTotalPrice();
    	User buyer = userService.selectByPrimaryKey(order.getBuyerid());
    	BigDecimal userPrice = buyer.getMoney();
    	System.out.println("orderPrice:"+orderPrice);
    	System.out.println("userPrice:"+userPrice);
    	int res=0;
    	if (orderPrice.compareTo(userPrice)>0) {
    		System.out.println("用户帐户金额不足支付该订单，请充值！");
    		return ResultGenerator.genFailResult("用户帐户金额不足支付该订单，请充值！");
		}else {
			goods.setInventory(inventory);
			BigDecimal userPriceCal =userPrice.subtract(orderPrice);
			System.out.println("userPriceCal:"+userPriceCal);
			System.out.println("inventory:"+inventory);
			buyer.setMoney(userPriceCal);
			System.out.println(buyer.toString());
			userService.updateByPrimaryKey(buyer);
			System.out.println(goods.toString());
			goodsService.updateByPrimaryKey(goods);
			System.out.println(order.toString());
			res=orderService.insert(order);
			if(res==1){
				System.out.println("deleteByGoodsId:"+order.getGoodsid()+" "+order.getBuyerid());
				cartService.deleteByGoodsId(order.getGoodsid(),order.getBuyerid());
	            return ResultGenerator.genSuccessResult();
	        }else{
	        	return ResultGenerator.genFailResult(null);
	        }
		}
    }

    /**
     * 删除
     */
    @GetMapping("/delete/{ids}")
    public Result<String> delete(@PathVariable("ids") String ids){
    	if(null==ids||ids.equals("")){
    		return ResultGenerator.genFailResult(null);
    	}
        String str[]=ids.split(",");
        for(String s:str){
            orderService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 订单发货
     */
    @GetMapping("/send/{id}")
    public Result<String> send(@PathVariable("id") String ids){
    	if(null==ids||ids.equals("")){
    		return ResultGenerator.genFailResult(null);
    	}
    	String str[]=ids.split(",");
    	for(String s:str){
    		orderService.send(Integer.valueOf(s));
    	}
    	return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 订单确认收货
     */
    @GetMapping("/sure/{id}")
    public Result<String> sure(@PathVariable("id") String ids){
    	if(null==ids||ids.equals("")){
    		return ResultGenerator.genFailResult(null);
    	}
    	String str[]=ids.split(",");
    	for(String s:str){
    		orderService.sure(Integer.valueOf(s));
    	}
    	return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Order order){
    	int res=orderService.updateByPrimaryKey(order);
    	if(res==1){
    		return ResultGenerator.genSuccessResult();
    	}else{
    		return ResultGenerator.genFailResult(null);
    	}
    }
    
    /**
     * 主键查询
     */
    @GetMapping("/info/{id}")
    public Result<?> selectById(@PathVariable("id") int id){
    	Order order = orderService.selectByPrimaryKey(id);
    	if(null==order){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(order);
    	}
    }
    
    /**
     * 获取订单总数
     */
    @GetMapping("/countAll")
    public Map<String,Object> countA(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=orderService.count(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    /**
     * 条件和排序的分页查询
     */
    @PostMapping("/search")
    public void search(
    		@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Order order,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        
        //设置排序参数
        map.put("sort","id");
        
        //发送数据
        List<Order> list=orderService.select(map);
        int total=orderService.count(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response,result);
    }
    
    /**
     * 分页查询
     */
    @PostMapping("/getAll")
    public JSONArray getAll(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Order order,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),
    				Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("sort","id");
    	
    	//发送数据
    	List<Order> list=orderService.select(map);
    	System.out.println(list.toString());
    	int total=orderService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray; 
    }
    
    /**
     * 分页查询
     */
    @PostMapping("/getBySupplier")
    public JSONArray getBySupplier(
    		@RequestParam(value = "supplierid", required = false) String supplierid,
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Order order,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),
    				Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("sort","id");
    	map.put("supplierid",supplierid);
    	
    	//发送数据
    	List<Order> list=orderService.selectBySupplier(map);
    	System.out.println(list.toString());
    	int total=orderService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray; 
    }
    
    /**
     * 分页查询
     */
    @PostMapping("/getByUser")
    public JSONArray getByUser(@RequestParam("id") String id,
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Order order,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),
    				Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("userid",id);
    	
    	//发送数据
    	List<Order> list=orderService.getByUser(map);
    	System.out.println(list.toString());
    	int total=orderService.countByUser(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray; 
    }
    
    /**
     * 获取订单总数
     */
    @GetMapping("/countByUser")
    public Map<String,Object> countByUser(@RequestParam("id") String id){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("userid",id);
    	int total=orderService.countByUser(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
}