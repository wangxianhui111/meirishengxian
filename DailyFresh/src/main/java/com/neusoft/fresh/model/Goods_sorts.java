package com.neusoft.fresh.model;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class Goods_sorts{
	
	/**
	 * 
	 */
	private	Integer id;
	
	/**
	 * 
	 */
	private	String sortname;
	
	/**
	 * 
	 */
	private	String type;
	
	
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public String getSortname(){
		return sortname;
	}
	
	public void setSortname(String sortname){
		this.sortname=sortname;
	}
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	@Override
	public String toString() {
		return "Goods_sorts [id=" + id + ", sortname=" + sortname + ", type=" + type + "]";
	}
	
}
