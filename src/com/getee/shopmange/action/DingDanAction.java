package com.getee.shopmange.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.dao.DdDAO;
import com.getee.shopmanage.model.dao.DdDAOImp;
import com.getee.shopmange.util.Responser;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.HttpContext;

public class DingDanAction extends ActionSupport{
	private DingDan dd;
	private DdDAO dao;
	private JSONArray jj;
	 private int dd_id;
     private int user_id;
     private int wine_id;
     private int number;
     private float prices;
     private  int state;
     private int page;
     private int rows;
     
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getDd_id() {
		return dd_id;
	}
	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}
	public int getWine_id() {
		return wine_id;
	}
	public void setWine_id(int wine_id) {
		this.wine_id = wine_id;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public JSONArray getJj() {
		return jj;
	}
	public void setJj(JSONArray jj) {
		this.jj = jj;
	}
	public DingDanAction(){
		dao=new DdDAOImp();
	}
	public DingDan getDd() {
		return dd;
	}

	public void setDd(DingDan dd) {
		this.dd = dd;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * 搜索订单
	 */
	public void searchDingdan(){
		//System.out.println("进入到了搜索订单的后台了");
		ArrayList<DingDan> dds=dao.searchDd(user_id);
		JSONArray  js=new JSONArray();
		for(DingDan dd:dds)
		{
			try {
				JSONObject  j=new JSONObject();
				j.put("dd_id", dd.getDd_id());
				j.put("user_id", dd.getUser_id());
				j.put("wine_id", dd.getWine_id());
				j.put("state", dd.getState());
				j.put("number", dd.getNumber());
				j.put("prices", dd.getPrices());
				js.put(j);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllDingdan(){
		ArrayList<DingDan> dds=dao.listDd(rows,page);
		int count =(dao.getAllCount()).size();
		//System.out.println(count);
		JSONArray  js=new JSONArray();
		JSONObject data = new JSONObject();
		for(DingDan dd:dds)
		{
			try {
				JSONObject  j=new JSONObject();
				j.put("dd_id", dd.getDd_id());
				j.put("user_id", dd.getUser_id());
				j.put("wine_id", dd.getWine_id());
				j.put("state", dd.getState());
				j.put("number", dd.getNumber());
				j.put("prices", dd.getPrices());
				js.put(j);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		try {
				data.put("total", count);
				data.put("rows", js);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void processSave(){
		System.out.println("进入到保存数据库的方法了");
		DingDan dd=new DingDan();
		dd.setUser_id(user_id);
		dd.setDd_id(dd_id);
		dd.setWine_id(wine_id);
	    dd.setNumber(number);
	    dd.setPrices(prices);
	    dd.setState(state);
	    System.out.println(dd.toString());
	    boolean result = dao.saveDd(dd);
		JSONObject data = new JSONObject();
		try {
			data.put("result", result+"");
			System.out.println(result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(data.toString());
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
