package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.UserDao;
import com.neusoft.fresh.model.User;
import com.neusoft.fresh.service.UserService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(User record) {
		return userDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return userDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(User record) {
		return userDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public User selectByPrimaryKey(int id){
		return userDao.selectByPrimaryKey(id);
	}

	
	/**
	 * 分页、条件、排序查询
	 */
	@Override
	public List<User> select(Map<String,Object> map){
		return userDao.select(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int count(Map<String,Object> map) {
		return userDao.count(map);
	}


	@Override
	public User selectByName(String name) {
		return userDao.selectByName(name);
	}


	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	
}
