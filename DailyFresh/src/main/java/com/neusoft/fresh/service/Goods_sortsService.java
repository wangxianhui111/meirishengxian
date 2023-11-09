package com.neusoft.fresh.service;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.model.Goods_sorts;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface Goods_sortsService {
	/**
	 * 插入
	 */
	int insert(Goods_sorts record);
    
	
	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(int id);
	 
	
	/**
	 * 根据主键更新
	 */
	int updateByPrimaryKey(Goods_sorts record);

	
	/**
	 * 根据主键查询
	 */
	Goods_sorts selectByPrimaryKey(int id);

	
	/**
	 * 分页、条件、排序查询
	 */
	List<Goods_sorts> select(Map<String,Object> map);
	
	
	/**
	 * 根据条件计算总数据量
	 */
	int count(Map<String,Object> map);
	
}
