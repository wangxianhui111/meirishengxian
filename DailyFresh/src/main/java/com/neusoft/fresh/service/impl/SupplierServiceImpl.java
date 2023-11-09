package com.neusoft.fresh.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.fresh.dao.SupplierDao;
import com.neusoft.fresh.model.Supplier;
import com.neusoft.fresh.service.SupplierService;


/**
 * 描述：Service实现
 * 
 * 创建时间：2018/09/02 18:18
 */
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierDao supplierDao;
	
	/**
	 * 插入
	 */
	@Override
	public int insert(Supplier record) {
		return supplierDao.insert(record);
	}
    
	
	/**
	 * 根据主键删除
	 */
	@Override
	public int deleteByPrimaryKey(int id) {
		return supplierDao.deleteByPrimaryKey(id);
	}
	 
	
	/**
	 * 根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(Supplier record) {
		return supplierDao.updateByPrimaryKey(record);
	}

	
	/**
	 * 根据主键查询
	 */
	@Override
	public Supplier selectByPrimaryKey(int id){
		return supplierDao.selectByPrimaryKey(id);
	}

	@Override
	public Supplier selectByName(String name) {
		return supplierDao.selectByName(name);
	}


	@Override
	public Supplier login(Supplier supplier) {
		return supplierDao.login(supplier);
	}


	@Override
	public List<Supplier> selectA(Map<String, Object> map) {
		return supplierDao.selectA(map);
	}


	@Override
	public List<Supplier> selectS(Map<String, Object> map) {
		return supplierDao.selectS(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int countA(Map<String,Object> map) {
		return supplierDao.countA(map);
	}
	
	
	/**
	 * 根据条件计算总数据量
	 */
	@Override
	public int countS(Map<String,Object> map) {
		return supplierDao.countS(map);
	}
	
}
