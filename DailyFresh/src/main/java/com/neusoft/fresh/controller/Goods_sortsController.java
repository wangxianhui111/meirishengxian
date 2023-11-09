package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Goods_sorts;
import com.neusoft.fresh.service.Goods_sortsService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/goods_sorts")
public class Goods_sortsController {
    @Autowired
    private Goods_sortsService goods_sortsService;

    /**
     * 新增
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Goods_sorts goods_sorts){
        int res=goods_sortsService.insert(goods_sorts);
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
            goods_sortsService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Goods_sorts goods_sorts){
    	System.out.println(goods_sorts.toString());
    	int res=goods_sortsService.updateByPrimaryKey(goods_sorts);
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
    	Goods_sorts goods_sorts = goods_sortsService.selectByPrimaryKey(id);
    	if(null==goods_sorts){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(goods_sorts);
    	}
    }
    
    /**
     * 条件和排序的分页查询
     */
    @PostMapping("/search")
    public void search(
    		@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Goods_sorts goods_sorts,HttpServletResponse response){
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
        List<Goods_sorts> list=goods_sortsService.select(map);
        int total=goods_sortsService.count(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response,result);
    }
    
    /**
     	* 分页
     */
    @PostMapping("/getAll")
    public JSONArray getAll(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Goods_sorts goods_sorts,HttpServletResponse response){
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
    	List<Goods_sorts> list=goods_sortsService.select(map);
    	int total=goods_sortsService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    
    /**
     * 获取生鲜总数
     */
    @GetMapping("/countAll")
    public Map<String,Object> countA(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=goods_sortsService.count(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    
    /**
     * 分页
     */
    @GetMapping("/getAllTypes")
    public Result<?> getAllTypes(Goods_sorts goods_sorts,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	//设置排序参数
    	map.put("sort","id");
    	
    	//发送数据
    	List<Goods_sorts> list=goods_sortsService.select(map);
    	if(null==list){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(list);
    	}
    }
    
    
}
