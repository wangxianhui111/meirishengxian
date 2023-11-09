package com.neusoft.fresh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.fresh.dao.BaseDao;
import com.neusoft.fresh.model.Cart;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface CartDao extends BaseDao<Cart>{
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
	public int deleteByGoodsId(@Param("goodsid")int goodsid,@Param("userid")int userid);
	
}
