package com.neusoft.fresh.model;

import java.sql.Timestamp;

/**
 * 描述：
 * 
 * 创建时间：2018/09/02 18:18
 */
public class Supplier{
	
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
	private	String create_time;
	
	/**
	 * 
	 */
	private	String is_admin;
	
	
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
	
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getIs_admin(){
		return is_admin;
	}
	
	public void setIs_admin(String is_admin){
		this.is_admin=is_admin;
	}

	public String toString() {
		return "Supplier [id=" + id + ", username=" + username + ", password=" + password + ", create_time="
				+ create_time + ", is_admin=" + is_admin + "]";
	}
}
