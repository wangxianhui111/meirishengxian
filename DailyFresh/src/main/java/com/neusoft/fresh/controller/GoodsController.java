package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Goods;
import com.neusoft.fresh.service.GoodsService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 新增
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Goods goods){
        int res=goodsService.insert(goods);
        if(res==1){
            return ResultGenerator.genSuccessResult();
        }else{
        	return ResultGenerator.genFailResult(null);
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
            goodsService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Goods goods){
    	int res=goodsService.updateByPrimaryKey(goods);
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
    	Goods goods = goodsService.selectByPrimaryKey(id);
    	if(null==goods){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(goods);
    	}
    }
    
    
    /**
      * 根据类别查询
     */
    @PostMapping("/selectByType")
    public JSONArray selectByType(
    		@RequestParam("typeid")int typeid,
    		@RequestParam("page")String page,
    		@RequestParam("rows")String rows){
    	int totalSize=goodsService.countByType(typeid);
    	
    	int totalPage=totalSize%Integer.parseInt(rows)==0?totalSize/Integer.parseInt(rows):totalSize/Integer.parseInt(rows)+1;
    	
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        map.put("typeid", typeid);
        
        List<Goods> list=goodsService.selectByType(map);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("totalSize", totalSize);
        resultMap.put("totalPage", totalPage);
        resultMap.put("currPage", Integer.parseInt(page));
    	JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
    
    
    /**
      * 条件和排序的分页查询
     */
    @PostMapping("/search")
    public void search(
    		@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Goods goods,HttpServletResponse response){
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
        List<Goods> list=goodsService.select(map);
        int total=goodsService.count(map);
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
    public Map<String,Object> countA(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=goodsService.count(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    /**
     * 分页查询
     */
    @PostMapping("/getBySupplier")
    public JSONArray getBySupplier(
    		@RequestParam(value = "supplierid", required = false) String supplierid,
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Goods goods,HttpServletResponse response){
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
    	List<Goods> list=goodsService.selectBySupplier(map);
    	int total=goodsService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    /**
     * 分页查询
     */
    @PostMapping("/getAll")
    public JSONArray getAll(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Goods goods,HttpServletResponse response){
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
    	List<Goods> list=goodsService.select(map);
    	int total=goodsService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
}