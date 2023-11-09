package com.neusoft.fresh.model;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class Cart{
	
	/**
	 * 
	 */
	private	Integer id;
	
	/**
	 * 
	 */
	private	Integer buyerid;
	
	/**
	 * 
	 */
	private	Integer goodsid;
	
	/**
	 * 
	 */
	private	Integer num;
	
	
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getBuyerid(){
		return buyerid;
	}
	
	public void setBuyerid(Integer buyerid){
		this.buyerid=buyerid;
	}
	public Integer getGoodsid(){
		return goodsid;
	}
	
	public void setGoodsid(Integer goodsid){
		this.goodsid=goodsid;
	}
	public Integer getNum(){
		return num;
	}
	
	public void setNum(Integer num){
		this.num=num;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", buyerid=" + buyerid + ", goodsid=" + goodsid + ", num=" + num + "]";
	}
	
}
