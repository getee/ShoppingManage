package com.getee.shopmange.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.dao.*;

import com.getee.shopmange.util.Responser;
import com.opensymphony.xwork2.ActionSupport;
public class DingDanAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	 private DingDanDAO  dao;
	 private int page;
     private int rows;
     private int dd_id;
     private int user_id;
     private int wine_id;
     private int number;
     private float prices;
     private  int state;
     private  int delId;
     
   
	public int getDelId() {
		return delId;
	}
	public void setDelId(int delId) {
		this.delId = delId;
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
	public int getDd_id() {
		return dd_id;
	}
	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}
	public DingDanDAO getDao() {
		return dao;
	}
	public void setDao(DingDanDAO dao) {
		this.dao = dao;
	}
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



public DingDanAction() {
	super();

	dao=new DingDanDAOImp();

}



/*
 * 处理添加的业务方法
 */
public String addDD(){
	DingDan dd=new DingDan();
	dd.setDd_id(dd_id);
	dd.setUser_id(user_id);
	dd.setWine_id(wine_id);
    dd.setNumber(number);
    dd.setPrices(prices);
    dd.setState(state);
    System.out.println(dd.toString());
    boolean result = dao.addDD(dd);
	JSONObject data = new JSONObject();
	try {
		data.put("result", result+"");
		System.out.println(result);
	} catch (JSONException e) {
		e.printStackTrace();
	}
	try {
		System.out.println(data.toString());
		Responser.responseToJson(response, request, data.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

/*
 * 删除订单的业务
 */
public String delDD() {
	DingDan dd=new DingDan();
	dd.setDd_id(delId);
	System.out.println(dd.toString());
	boolean result=dao.delDD(dd);
	JSONObject data = new JSONObject();
	try {
		data.put("result", result+"");
	} catch (JSONException e) {
	e.printStackTrace();
	}
	try {
		Responser.responseToJson(response, request, data.toString());
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	return null;
}

/*
 * 分页
 */
public String listDeliveryByPage() {
	ArrayList<DingDan> all = (ArrayList<DingDan>)dao.list(rows, page);
	int count = dao.watchcount();
	JSONObject data = new JSONObject();
	JSONArray rowsCollection = new JSONArray();
	for(DingDan dd:all) {
		JSONObject propertiseobject = new JSONObject();
		try {
			propertiseobject.put("dd_id",dd.getDd_id());
			propertiseobject.put("user_id",dd.getUser_id());
			propertiseobject.put("wine_id",dd.getWine_id());
			propertiseobject.put("number",dd.getNumber());
			propertiseobject.put("prices",dd.getPrices() );
			propertiseobject.put("state",dd.getState());
			rowsCollection.put(propertiseobject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	try {
		data.put("total", count);
		data.put("rows", rowsCollection);
	} catch (JSONException e1) {
		e1.printStackTrace();
	}
	try {
		System.out.println(data.toString());
		Responser.responseToJson(response, request, data.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}


public String listObligationByPage() {
	ArrayList<DingDan> all = (ArrayList<DingDan>)dao.list(rows, page);
	int count = dao.watchcount();
	JSONObject data = new JSONObject();
	JSONArray rowsCollection = new JSONArray();
	for(DingDan dd:all) {
		JSONObject propertiseobject = new JSONObject();
		try {
			propertiseobject.put("dd_id",dd.getDd_id());
			propertiseobject.put("user_id",dd.getUser_id());
			propertiseobject.put("wine_id",dd.getWine_id());
			propertiseobject.put("number",dd.getNumber());
			propertiseobject.put("prices",dd.getPrices() );
			propertiseobject.put("state",dd.getState());
			rowsCollection.put(propertiseobject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	try {
		data.put("total", count);
		data.put("rows", rowsCollection);
	} catch (JSONException e1) {
		e1.printStackTrace();
	}
	try {
		Responser.responseToJson(response, request, data.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}


}
