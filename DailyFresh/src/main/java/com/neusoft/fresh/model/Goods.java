package com.neusoft.fresh.model;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class Goods{
	
	/**
	 * 
	 */
	private	Integer id;
	
	/**
	 * 
	 */
	private	String goodsname;
	
	/**
	 * 
	 */
	private	java.math.BigDecimal price;
	
	/**
	 * 
	 */
	private	Integer supplierid;
	
	/**
	 * 
	 */
	private	Integer sortid;
	
	/**
	 * 
	 */
	private	String details;
	
	/**
	 * 
	 */
	private	String pub_time;
	
	/**
	 * 
	 */
	private	String status;
	
	/**
	 * 
	 */
	private	String pic_url;
	
	/**
	 * 
	 */
	private	Integer inventory;
	
	
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public String getGoodsname(){
		return goodsname;
	}
	
	public void setGoodsname(String goodsname){
		this.goodsname=goodsname;
	}
	public java.math.BigDecimal getPrice(){
		return price;
	}
	
	public void setPrice(java.math.BigDecimal price){
		this.price=price;
	}
	public Integer getSupplierid(){
		return supplierid;
	}
	
	public void setSupplierid(Integer supplierid){
		this.supplierid=supplierid;
	}
	public Integer getSortid(){
		return sortid;
	}
	
	public void setSortid(Integer sortid){
		this.sortid=sortid;
	}
	public String getDetails(){
		return details;
	}
	
	public void setDetails(String details){
		this.details=details;
	}
	public String getPub_time(){
		return pub_time;
	}
	
	public void setPub_time(String pub_time){
		this.pub_time=pub_time;
	}
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	public String getPic_url(){
		return pic_url;
	}
	
	public void setPic_url(String pic_url){
		this.pic_url=pic_url;
	}
	public Integer getInventory(){
		return inventory;
	}
	
	public void setInventory(Integer inventory){
		this.inventory=inventory;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsname=" + goodsname + ", price=" + price + ", supplierid=" + supplierid
				+ ", sortid=" + sortid + ", details=" + details + ", pub_time=" + pub_time + ", status=" + status
				+ ", pic_url=" + pic_url + ", inventory=" + inventory + "]";
	}
	
	
}
