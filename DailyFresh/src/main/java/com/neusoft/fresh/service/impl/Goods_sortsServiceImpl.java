package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.Goods_sortsDao;
import com.neusoft.fresh.model.Goods_sorts;
import com.neusoft.fresh.service.Goods_sortsService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class Goods_sortsServiceImpl implements Goods_sortsService{
	@Autowired
	private Goods_sortsDao goods_sortsDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(Goods_sorts record) {
		return goods_sortsDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return goods_sortsDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(Goods_sorts record) {
		return goods_sortsDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public Goods_sorts selectByPrimaryKey(int id){
		return goods_sortsDao.selectByPrimaryKey(id);
	}

	
	/**
	 * 分页、条件、排序查询
	 */
	@Override
	public List<Goods_sorts> select(Map<String,Object> map){
		return goods_sortsDao.select(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int count(Map<String,Object> map) {
		return goods_sortsDao.count(map);
	}
	
}
