package com.neusoft.fresh.model;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class Order{
	
	/**
	 * 
	 */
	private	Integer id;
	
	/**
	 * 
	 */
	private	Integer goodsid;
	
	/**
	 * 
	 */
	private	Integer buyerid;
	
	/**
	 * 
	 */
	private	Integer supplierid;
	
	/**
	 * 
	 */
	private	java.math.BigDecimal totalPrice;
	
	/**
	 * 
	 */
	private	String order_time;
	
	/**
	 * 
	 */
	private	String order_address;
	
	/**
	 * 
	 */
	private	String status;
	
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
	public Integer getGoodsid(){
		return goodsid;
	}
	
	public void setGoodsid(Integer goodsid){
		this.goodsid=goodsid;
	}
	public Integer getBuyerid(){
		return buyerid;
	}
	
	public void setBuyerid(Integer buyerid){
		this.buyerid=buyerid;
	}
	public Integer getSupplierid(){
		return supplierid;
	}
	
	public void setSupplierid(Integer supplierid){
		this.supplierid=supplierid;
	}
	public java.math.BigDecimal getTotalPrice(){
		return totalPrice;
	}
	
	public void setTotalPrice(java.math.BigDecimal totalPrice){
		this.totalPrice=totalPrice;
	}
	public String getOrder_time(){
		return order_time;
	}
	
	public void setOrder_time(String order_time){
		this.order_time=order_time;
	}
	public String getOrder_address(){
		return order_address;
	}
	
	public void setOrder_address(String order_address){
		this.order_address=order_address;
	}
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	public Integer getNum(){
		return num;
	}
	
	public void setNum(Integer num){
		this.num=num;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodsid=" + goodsid + ", buyerid=" + buyerid + ", supplierid=" + supplierid
				+ ", totalPrice=" + totalPrice + ", order_time=" + order_time + ", order_address=" + order_address
				+ ", status=" + status + ", num=" + num + "]";
	}
	
}
