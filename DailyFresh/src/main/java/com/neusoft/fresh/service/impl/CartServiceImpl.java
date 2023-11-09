package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.CartDao;
import com.neusoft.fresh.model.Cart;
import com.neusoft.fresh.service.CartService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(Cart record) {
		return cartDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return cartDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(Cart record) {
		return cartDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public Cart selectByPrimaryKey(int id){
		return cartDao.selectByPrimaryKey(id);
	}

	
	/**
	 * 分页、条件、排序查询
	 */
	@Override
	public List<Cart> select(Map<String,Object> map){
		return cartDao.select(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int count(Map<String,Object> map) {
		return cartDao.count(map);
	}

	@Override
	public List<Cart> getByUser(Map<String, Object> map) {
		return cartDao.getByUser(map);
	}
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int countByUser(Map<String,Object> map) {
		return cartDao.countByUser(map);
	}


	@Override
	public int deleteByGoodsId(int goodsid,int userid) {
		return cartDao.deleteByGoodsId(goodsid,userid);
	}
	
}
