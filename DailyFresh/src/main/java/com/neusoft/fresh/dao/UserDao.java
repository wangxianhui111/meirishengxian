package com.neusoft.fresh.dao;

import com.neusoft.fresh.dao.BaseDao;
import com.neusoft.fresh.model.User;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface UserDao extends BaseDao<User>{
	/**
	 * 根据用户名查询
	 */
	User selectByName(String name);
	/**
	 * 根据用户名查询
	 */
	User login(User user);
}
