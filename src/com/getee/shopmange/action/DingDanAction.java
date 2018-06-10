package com.getee.shopmange.action;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.dao.DingDanDAO;
import com.getee.shopmanage.model.dao.DingDanDAOImp;
import com.getee.shopmanage.model.dao.UserDAO;
import com.getee.shopmanage.model.dao.WineDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DingDanAction extends ActionSupport{
   private  UserDAO  uDAO;
   private  DingDanDAO ddDAO;
   private  WineDAO   wDAO;


public UserDAO getuDAO() {
	return uDAO;
}
public void setuDAO(UserDAO uDAO) {
	this.uDAO = uDAO;
}
public DingDanDAO getDdDAO() {
	return ddDAO;
}
public void setDdDAO(DingDanDAO ddDAO) {
	this.ddDAO = ddDAO;
}
public WineDAO getwDAO() {
	return wDAO;
}
public void setwDAO(WineDAO wDAO) {
	this.wDAO = wDAO;
}






public DingDanAction() {
	super();
	wDAO=new DingDanDAOImp();
	uDAO=new UserDAOImp();
	ddDAO=new DingDanDAOImp();
}



/*
 * 处理添加的业务方法
 * 根据用户ID来获取该用户的订单ID，从而获得该订单对应的商品id；
 */
public void addDD(int user_id, int dd_id, int wine_id){
	ArrayList<DingDan>  dingdan=ddDAO.addDD(user_id,dd_id,wine_id);
	JSONArray  js=new JSONArray();
	try {
		for(DingDan d:dingdan){
			JSONObject j=new JSONObject();
			j.put("user_id",d.getUser_id());
			j.put("dd_id",d.getDd_id());
			j.put("wine_id",d.getWine_id());
			j.put("state", d.getState());
			j.put("number", d.getNumber());
			j.put("prices", d.getPrices());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
try {

	}
} catch (Exception e) {
	e.printStackTrace();
}
}






}
