package com.getee.shopmanage.model.bean;

public class DingDan {
	private  int dd_id;
	private  int user_id;
	private  int wine_id;
	private  int state;
	private  int  number;
	private  float prices;
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DingDan [dd_id=" + dd_id + ", user_id=" + user_id + ", wine_id=" + wine_id + ", state=" + state
				+ ", number=" + number + ", price=" + prices + "]";
	}

	public DingDan(int dd_id, int user_id, int wine_id, int state, int number, float price) {
		super();
		this.dd_id = dd_id;
		this.user_id = user_id;
		this.wine_id = wine_id;
		this.state = state;
		this.number = number;
		this.prices = prices;
	}
  public DingDan(){
    super();
  }
		
}
