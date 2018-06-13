package com.getee.shopmanage.model.bean;

public class DingDan {
	/*-- 订单id不唯一，具有相同id的视为同一订单
	dd_id int NOT NULL COMMENT '订单id不唯一，具有相同id的视为同一订单',
	user_id int NOT NULL,
	wine_id int NOT NULL,
	-- 0 待发货
	-- 1 快递中
	-- 2 已送达
	state int DEFAULT 0 NOT NULL COMMENT '0 待发货
1 快递中
2 已送达',
	-- 购买数量
	number int DEFAULT 1 NOT NULL COMMENT '购买数量',
	-- 总价格
	prices float NOT NULL COMMENT '总价格'*/
	private int user_id;
	private int dd_id;
	private int wine_id;
	private int number;
	private float prices;
	private int state;
	public int getDd_id() {
		return dd_id;
	}
	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public DingDan(int dd_id, int user_id, int wine_id, int state, int number, float prices) {
		super();
		this.dd_id = dd_id;
		this.user_id = user_id;
		this.wine_id = wine_id;
		this.state = state;
		this.number = number;
		this.prices = prices;
	}
	public DingDan() {
		super();
	}
	@Override
	public String toString() {
		return "DingDan [user_id=" + user_id + ", dd_id=" + dd_id + ", wine_id=" + wine_id + ", number=" + number
				+ ", prices=" + prices + ", state=" + state + "]";
	}
	
	
}
