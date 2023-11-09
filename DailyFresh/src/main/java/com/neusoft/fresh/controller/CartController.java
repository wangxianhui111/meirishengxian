package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Cart;
import com.neusoft.fresh.service.CartService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 新增
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Cart cart){
        int res=cartService.insert(cart);
        if(res==1){
            return ResultGenerator.genSuccessResult();
        }else{
        	return ResultGenerator.genFailResult(null);
        }
    }

    /**
     * 删除
     */
    @GetMapping("/delete/{id}")
    public Result<String> delete(@PathVariable("id") String ids){
    	if(null==ids||ids.equals("")){
    		return ResultGenerator.genFailResult(null);
    	}
        String str[]=ids.split(",");
        for(String s:str){
            cartService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Cart cart){
    	int res=cartService.updateByPrimaryKey(cart);
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
    	Cart cart = cartService.selectByPrimaryKey(id);
    	if(null==cart){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(cart);
    	}
    }
    
    /**
     * 条件和排序的分页查询
     */
    @PostMapping("/search")
    public void search(
    		@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Cart cart,HttpServletResponse response){
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
        List<Cart> list=cartService.select(map);
        int total=cartService.count(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response,result);
    }
    
    /**
     	* 获取生鲜总数
     */
    @GetMapping("/countAll")
    public Map<String,Object> countAll(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=cartService.count(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    
    /**
     * 分页查询
     */
    @PostMapping("/getAll")
    public JSONArray getAll(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Cart cart,HttpServletResponse response){
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
    	List<Cart> list=cartService.select(map);
    	System.out.println(list.toString());
        int total=cartService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    
    /**
     * 分页查询用户购物车
     */
    @PostMapping("/getByUser")
    public JSONArray getByUser(@RequestParam("id") String id,
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Cart cart,HttpServletResponse response){
    	
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("userid",id);
    	
    	//发送数据
    	List<Cart> list=cartService.getByUser(map);
        int total=cartService.countByUser(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    
    /**
     	* 获取用户购物车总数
     */
    @GetMapping("/countByUser")
    public Map<String,Object> countByUser(@RequestParam("id") String id){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("userid",id);
    	int total=cartService.countByUser(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
}