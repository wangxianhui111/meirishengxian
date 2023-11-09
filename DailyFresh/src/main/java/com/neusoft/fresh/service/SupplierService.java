package com.neusoft.fresh.service;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.model.Supplier;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface SupplierService {
	/**
	 * 插入
	 */
	int insert(Supplier record);
    
	
	/**
	 * 根据主键删除
	 */
	int deleteByPrimaryKey(int id);
	 
	
	/**
	 * 根据主键更新
	 */
	int updateByPrimaryKey(Supplier record);

	
	/**
	 * 根据主键查询
	 */
	Supplier selectByPrimaryKey(int id);
	
	/**
	 * 根据用户名查询
	 */
	Supplier selectByName(String name);
	
	/**
	 * 根据用户名查询
	 */
	Supplier login(Supplier supplier);

	
	/**
	 * 分页、条件、排序查询
	 */
	List<Supplier> selectA(Map<String,Object> map);
	
	/**
	 * 分页、条件、排序查询
	 */
	List<Supplier> selectS(Map<String,Object> map);
	
	
	/**
	 * 根据条件计算总数据量
	 */
	int countA(Map<String,Object> map);
	
	
	/**
	 * 根据条件计算总数据量
	 */
	int countS(Map<String,Object> map);
	
}
