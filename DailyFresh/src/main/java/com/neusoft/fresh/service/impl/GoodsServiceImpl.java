package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.GoodsDao;
import com.neusoft.fresh.model.Goods;
import com.neusoft.fresh.service.GoodsService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(Goods record) {
		return goodsDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return goodsDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(Goods record) {
		return goodsDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public Goods selectByPrimaryKey(int id){
		return goodsDao.selectByPrimaryKey(id);
	}

	
	/**
	 * 分页、条件、排序查询
	 */
	@Override
	public List<Goods> select(Map<String,Object> map){
		return goodsDao.select(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int count(Map<String,Object> map) {
		return goodsDao.count(map);
	}


	@Override
	public List<Goods> selectByType(Map<String, Object> map) {
		return goodsDao.selectByType(map);
	}


	@Override
	public int countByType(int typeId) {
		return goodsDao.countByType(typeId);
	}


	@Override
	public List<Goods> selectBySupplier(Map<String, Object> map) {
		return goodsDao.selectBySupplier(map);
	}
	
}
