package com.getee.shopmange.action;

import java.io.UnsupportedEncodingException;
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
	private String page;
	private String rows;
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
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
	/**
	 * 这是商品管理->搜索商品业务
	 * 可以按照种类与名字查询
	 */
	public void searchWine() {
		//String value=null;
		ArrayList<Wine> winelist=null;
		System.out.println(searchValue);
		/*try {//easyui传过来的种类kind是乱码的，故转了一下
			value=new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		
System.out.println(page);
System.out.println(rows);

		//用来判断搜索的方式,为kind是按种类，否则为名字
		if(searchKind.equals("kind")) {
			winelist=dao.getKindPage(searchValue,Integer.parseInt(page), Integer.parseInt(rows));
		}else {
			System.out.println("name");
			winelist=dao.getNamePage(searchValue,Integer.parseInt(page), Integer.parseInt(rows));
		}
		//将查出来的数据放到json中
System.out.println("1----");
		JSONArray  js=new JSONArray();
		for(Wine c:winelist) {
			try {
		System.out.println("2----");
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
System.out.println("3----");
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
