package com.neusoft.fresh.service;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.model.Goods;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface GoodsService {
	/**
	 * 插入
	 */
	int insert(Goods record);
	
	/**
	 * 根据商品类别分页查询商品信息
	 */
	List<Goods> selectBySupplier(Map<String, Object> map);
	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(int id);
	 
	
	/**
	 * 根据主键更新
	 */
	int updateByPrimaryKey(Goods record);

	
	/**
	 * 根据主键查询
	 */
	Goods selectByPrimaryKey(int id);

	
	/**
	 * 分页、条件、排序查询
	 */
	List<Goods> select(Map<String,Object> map);
	
	/**
	 * 根据商品类别计算商品数量
	 */
	int countByType(int typeId);
	
	/**
	 * 根据条件计算总数据量
	 */
	int count(Map<String,Object> map);
	
	/**
	 * 根据商品类别分页查询商品信息
	 */
	List<Goods> selectByType(Map<String, Object> map);
}
