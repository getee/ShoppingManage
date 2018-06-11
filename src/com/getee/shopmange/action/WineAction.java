package com.getee.shopmange.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.Wine;
import com.getee.shopmanage.model.dao.WineDaoImp;
import com.getee.shopmange.util.Responser;

public class WineAction {
	private Wine wine;
	private String searchValue;
	private String searchKind;
	WineDaoImp dao=null;
	
	
	public WineAction() {
		dao=new WineDaoImp();
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	
	
	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}

	public String execute() {
		
		return "success";
	}
	public void searchWine() {
		System.out.println("hi");
		ArrayList<Wine> winelist=null;
		
		if(searchKind.equals("kind")) {
			winelist=dao.getKindPage(searchValue, 1, 3);
		}else {
			winelist=dao.getNamePage(searchValue, 1, 3);
		}
		
		JSONArray  js=new JSONArray();
		for(Wine c:winelist) {
			try {
				JSONObject  j=new JSONObject();
				j.put("wine_id", c.getId());
				j.put("wine_name", c.getName());
				j.put("kind", c.getKind());
				j.put("price", c.getPrice());
				j.put("detail", c.getDetail());
				j.put("picture", "<img src='"+c.getPicture()+"'  style='width:20px;height:20px'/>");
				j.put("picture4", "<img src='"+c.getPicture4()+"'  style='width:20px;height:20px'/>");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
