package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Supplier;
import com.neusoft.fresh.service.SupplierService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody Supplier admin,HttpServletRequest request){
    	Supplier ad=supplierService.login(admin);
    	if(ad!=null){
    		HttpSession session = request.getSession();
   		 	session.setAttribute("admin", ad);
    		return ResultGenerator.genSuccessResult(ad);
    	}else{
    		Result<Supplier> result = new Result<Supplier>();
   	     	result.setResultCode(Constants.RESULT_CODE_SERVER_ERROR);
   	     	return result;
    	}
    }
    
    /**
     * 登出
     */
    @PostMapping("/logout")
    public Result<?> logout(Supplier admin,HttpServletResponse response,HttpServletRequest request){
    	//清除session
    	HttpSession session = request.getSession();
    	session.removeAttribute("admin");
    	return null;
    }
    
    /**
     * 新增
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Supplier supplier){
    	System.out.println("supplier.toString():"+supplier.toString());
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	supplier.setCreate_time(sdf.format(new Date()));
        int res=supplierService.insert(supplier);
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
            supplierService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        System.out.println("ResultGenerator.genSuccessResult()");
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Supplier supplier){
    	int res=supplierService.updateByPrimaryKey(supplier);
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
    	Supplier supplier = supplierService.selectByPrimaryKey(id);
    	if(null==supplier){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(supplier);
    	}
    }
    
    /**
     * 用户名检查查询
     */
    @GetMapping("/check/{username}")
    public Map<String, Object> selectByName(@PathVariable("username") String name){
    	Supplier supplier = supplierService.selectByName(name);
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(null==supplier){
    		map.put("res", 0);
    		return map;
    	}else{
    		map.put("res", 1);
    		return map;
    	}
    }
    
    /**
     * 根据供应商/管理员类型获取总数
     */
    @GetMapping("/countA")
    public Map<String,Object> countA(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=supplierService.countA(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    /**
     * 根据供应商/管理员类型获取总数
     */
    @GetMapping("/countS")
    public Map<String,Object> countS(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=supplierService.countS(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    /**
     * 条件和排序的分页查询
     * @return 
     */
    @PostMapping("/getAllAdmins")
    public JSONArray getAllAdmins(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Supplier supplier,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	System.out.println("page:"+page+",rows:"+rows);
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),
    				Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("sort","id");
    	
    	//发送数据
    	List<Supplier> list=supplierService.selectA(map);
    	int total=supplierService.countA(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    
    /**
     * 条件和排序的分页查询
     * @return 
     */
    @PostMapping("/getAllSuppliers")
    public JSONArray getAllSuppliers(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		Supplier supplier,HttpServletResponse response){
    	//设置分页参数
    	Map<String, Object> map = new HashMap<String, Object>();
    	System.out.println("page:"+page+",rows:"+rows);
    	if (page != null && rows != null) {
    		PageBean pageBean = new PageBean(Integer.parseInt(page),
    				Integer.parseInt(rows));
    		map.put("start", pageBean.getStart());
    		map.put("size", pageBean.getPageSize());
    	}
    	
    	//设置排序参数
    	map.put("sort","id");
    	
    	//发送数据
    	List<Supplier> list=supplierService.selectS(map);
    	int total=supplierService.countS(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
    
}