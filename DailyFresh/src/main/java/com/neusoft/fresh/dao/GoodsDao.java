package com.neusoft.fresh.dao;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.dao.BaseDao;
import com.neusoft.fresh.model.Goods;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface GoodsDao extends BaseDao<Goods>{
	/**
	 * 根据商品类别分页查询商品信息
	 */
	List<Goods> selectByType(Map<String, Object> map);
	/**
	 * 根据商品类别分页查询商品信息
	 */
	List<Goods> selectBySupplier(Map<String, Object> map);
	
	
	/**
	 * 根据商品类别计算商品数量
	 */
	int countByType(int typeId);
}
