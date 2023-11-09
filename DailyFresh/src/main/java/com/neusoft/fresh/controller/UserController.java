package com.neusoft.fresh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;

import com.neusoft.fresh.model.Supplier;
import com.neusoft.fresh.model.User;
import com.neusoft.fresh.service.UserService;
import com.neusoft.fresh.utils.*;  


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user,HttpServletRequest request){
    	User userw=userService.login(user);
    	if(userw!=null){
    		return ResultGenerator.genSuccessResult(userw);
    	}else{
    		return ResultGenerator.genFailResult(null);
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
    public Result<String> insert(@RequestBody User user){
        int res=userService.insert(user);
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
            userService.deleteByPrimaryKey(Integer.valueOf(s));
        }
        return ResultGenerator.genSuccessResult();
    }
    
    /**
     * 更新
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody User user){
    	int res=userService.updateByPrimaryKey(user);
    	System.out.println(user.toString());
    	System.out.println(res);
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
    	User user = userService.selectByPrimaryKey(id);
    	if(null==user){
    		return ResultGenerator.genFailResult(null);
    	}else{
    		return ResultGenerator.genSuccessResult(user);
    	}
    }
    
    /**
     * 用户名检查查询
     */
    @GetMapping("/check/{username}")
    public Map<String, Object> selectByName(@PathVariable("username") String name){
    	User user = userService.selectByName(name);
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(null==user){
    		map.put("res", 0);
    		return map;
    	}else{
    		map.put("res", 1);
    		return map;
    	}
    }
    
    
    /**
     * 条件和排序的分页查询
     */
    @PostMapping("/search")
    public void search(
    		@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            User user,HttpServletResponse response){
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
        List<User> list=userService.select(map);
        int total=userService.count(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response,result);
    }
    
    /**
     * 获取用户总数
     */
    @GetMapping("/countAll")
    public Map<String,Object> countAll(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int total=userService.count(map);
    	Map<String,Object> result=new HashMap<>();
    	result.put("total", total);
    	return result;
    }
    
    
    /**
     * 分页查询
     * @return 
     */
    @PostMapping("/getAll")
    public JSONArray getAll(
    		@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "rows", required = false) String rows,
    		User user,HttpServletResponse response){
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
    	List<User> list=userService.select(map);
    	int total=userService.count(map);
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(list);
    	result.put("rows", jsonArray);
    	result.put("total", total);
    	return jsonArray;
    }
}