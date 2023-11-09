package com.neusoft.fresh.dao;

import java.util.List;
import java.util.Map;

import com.neusoft.fresh.dao.BaseDao;
import com.neusoft.fresh.model.Supplier;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public interface SupplierDao extends BaseDao<Supplier>{

	/**
	 * 根据用户名查询
	 */
	Supplier selectByName(String name);

	Supplier login(Supplier supplier);
	
	List<Supplier> selectA(Map<String,Object> map);
	
	List<Supplier> selectS(Map<String,Object> map);
	
	int countA(Map<String,Object> map);
	
	int countS(Map<String,Object> map);
	
}
