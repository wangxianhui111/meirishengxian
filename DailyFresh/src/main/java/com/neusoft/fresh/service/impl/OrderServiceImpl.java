package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.OrderDao;
import com.neusoft.fresh.model.Order;
import com.neusoft.fresh.service.OrderService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(Order record) {
		return orderDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return orderDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(Order record) {
		return orderDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public Order selectByPrimaryKey(int id){
		return orderDao.selectByPrimaryKey(id);
	}

	
	/**
	 * 分页、条件、排序查询
	 */
	@Override
	public List<Order> select(Map<String,Object> map){
		return orderDao.select(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int count(Map<String,Object> map) {
		return orderDao.count(map);
	}


	@Override
	public int send(int id) {
		return orderDao.send(id);
	}


	@Override
	public int sure(int id) {
		return orderDao.sure(id);
	}


	@Override
	public List<Order> getByUser(Map<String, Object> map) {
		return orderDao.getByUser(map);
	}


	@Override
	public int countByUser(Map<String, Object> map) {
		return orderDao.countByUser(map);
	}


	@Override
	public List<Order> selectBySupplier(Map<String, Object> map) {
		return orderDao.selectBySupplier(map);
	}
	
}
