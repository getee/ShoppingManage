package com.getee.shopmanage.model.bean;

public class Comments {
	private int com_id;
	private  int user_id;
	private int wine_id;
	private int state;
	private String content;
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getWine_id() {
		return wine_id;
	}
	public void setWine_id(int wine_id) {
		this.wine_id = wine_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Comments [com_id=" + com_id + ", user_id=" + user_id + ", wine_id=" + wine_id + ", state="
				+ state + ", content=" + content + "]";
	}
	public Comments(int com_id, int user_id, int wine_id, int state, String content) {
		super();
		this.com_id = com_id;
		this.user_id = user_id;
		this.wine_id = wine_id;
		this.state = state;
		this.content = content;
	}
	public Comments( int user_id, int wine_id, int state, String content) {
		super();
		
		this.user_id = user_id;
		this.wine_id = wine_id;
		this.state = state;
		this.content = content;
	}
	public Comments() {
		super();
	}
	
	
}
