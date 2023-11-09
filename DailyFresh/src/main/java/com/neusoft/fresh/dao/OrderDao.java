package com.neusoft.fresh.dao;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.dao.BaseDao;
import com.neusoft.fresh.model.Order;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface OrderDao extends BaseDao<Order>{
	/**
	 * 更新发货状态
	 */
	int send(int id);
	
	/**
	 * 更新收货状态
	 */
	int sure(int id);
	
	/**
	 * 根据用户分页查询购物车信息
	 */
	List<Order> getByUser(Map<String, Object> map);
	
	/**
	 * 根据用户分页查询购物车信息
	 */
	List<Order> selectBySupplier(Map<String, Object> map);
	/**
	 * 根据用户查询购物车数量
	 */
	public int countByUser(Map<String,Object> map);
	
}
