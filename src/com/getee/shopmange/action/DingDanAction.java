package com.getee.shopmange.action;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.dao.DingDanDAO;
import com.getee.shopmanage.model.dao.DingDanDAOImp;
import com.opensymphony.xwork2.ActionSupport;

public class DingDanAction extends ActionSupport{
   private  DingDanDAO  DAO;
   private  DingDan  dd;
   private   int  user_id;
   private   int dd_id;
 
public DingDanDAO getDAO() {
	return DAO;
}
public void setDAO(DingDanDAO dAO) {
	DAO = dAO;
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
public int getDd_id() {
	return dd_id;
}
public void setDd_id(int dd_id) {
	this.dd_id = dd_id;
}

public void  DingDanDAOImp(){
	   DAO=new  DingDanDAOImp();
   }




/*
 * 处理添加的业务方法
 */
public void addDD(){
	ArrayList<DingDan>  dingdan=DAO.addDD(user_id,dd_id);
	JSONArray  js=new JSONArray();
	for(DingDan d:dingdan){
		JSONObject j=new JSONObject();
		j.put("user_id",d.getUser_id());
		j.put("dd_id",d.getDd_id());
		j.put("wine_id",d.getWine_id());
		
	}
	
}
}
