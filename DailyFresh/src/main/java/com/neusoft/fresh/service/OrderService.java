package com.neusoft.fresh.service;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.model.Order;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface OrderService {
	/**
	 * 插入
	 */
	int insert(Order record);
    
	
	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(int id);
	
	/**
	 * 更新发货状态
	 */
	int send(int id);
	
	/**
	 * 更新收货状态
	 */
	int sure(int id);
	 
	
	/**
	 * 根据主键更新
	 */
	int updateByPrimaryKey(Order record);

	
	/**
	 * 根据主键查询
	 */
	Order selectByPrimaryKey(int id);

	
	/**
	 * 分页、条件、排序查询
	 */
	List<Order> select(Map<String,Object> map);
	
	/**
	 * 分页、条件、排序查询
	 */
	List<Order> selectBySupplier(Map<String,Object> map);
	
	
	/**
	 * 根据条件计算总数据量
	 */
	int count(Map<String,Object> map);
	
	
	/**
	 * 根据用户分页查询购物车信息
	 */
	List<Order> getByUser(Map<String, Object> map);
	
	/**
	 * 根据用户查询购物车数量
	 */
	public int countByUser(Map<String,Object> map);
	
}
