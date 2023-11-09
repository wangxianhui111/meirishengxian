package com.neusoft.fresh.model;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class User{
	
	/**
	 * 
	 */
	private	Integer id;
	
	/**
	 * 
	 */
	private	String username;
	
	/**
	 * 
	 */
	private	String password;
	
	/**
	 * 
	 */
	private	String sex;
	
	/**
	 * 
	 */
	private	String birthday;
	
	/**
	 * 
	 */
	private	String address;
	
	/**
	 * 
	 */
	private	java.math.BigDecimal money;
	
	
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	public java.math.BigDecimal getMoney(){
		return money;
	}
	
	public void setMoney(java.math.BigDecimal money){
		this.money=money;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", address=" + address + ", money=" + money + "]";
	}
	
}
