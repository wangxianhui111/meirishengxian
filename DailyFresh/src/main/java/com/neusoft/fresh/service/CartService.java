package com.neusoft.fresh.service;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.model.Cart;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface CartService {
	/**
	 * 插入
	 */
	int insert(Cart record);
	
	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(int id);
	
	/**
	 * 根据主键更新
	 */
	int updateByPrimaryKey(Cart record);

	/**
	 * 根据主键查询
	 */
	Cart selectByPrimaryKey(int id);

	/**
	 * 分页、条件、排序查询
	 */
	List<Cart> select(Map<String,Object> map);
	
	/**
	 * 根据条件计算总数据量
	 */
	int count(Map<String,Object> map);
	
	/**
	 * 根据用户分页查询购物车信息
	 */
	List<Cart> getByUser(Map<String, Object> map);
	
	/**
	 * 根据用户查询购物车数量
	 */
	public int countByUser(Map<String,Object> map);
	/**
	 * 根据商品id删除
	 */
	public int deleteByGoodsId(int goodsid,int userid);
}
