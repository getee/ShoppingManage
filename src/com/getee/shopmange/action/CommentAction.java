package com.getee.shopmange.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.Comments;
import com.getee.shopmanage.model.dao.CommentDAO;
import com.getee.shopmanage.model.dao.CommentDAOImp;
import com.getee.shopmange.util.Responser;


public class CommentAction {
	private Comments com ;
	private CommentDAO dao;
	private int page;
	private int rows;
	private String val;
	private String key;
	
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public Comments getCom() {
		return com;
	}

	public void setCom(Comments com) {
		this.com = com;
	}
	public CommentAction() {
		dao=new CommentDAOImp();
	}
	public void scanComment() {
		ArrayList<Comments> comments=dao.listCommentByPage(page,rows);
		//ArrayList<Comments> comments=dao.listCommentByPage();
		System.out.println(comments);
		JSONArray  js=new JSONArray();
		JSONObject  data=new JSONObject();
		int count=dao.getAllCountOfComment();
		System.out.println(count);
		for(Comments c:comments)
		{
			try {
				JSONObject  j=new JSONObject();
				j.put("user_id", c.getUser_id());
				j.put("com_id", c.getCom_id());
				j.put("wine_id", c.getWine_id());
				j.put("state", c.getState());
				j.put("content", c.getContent());
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			data.put("total", count);
			data.put("rows", js);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		System.out.println(data.toString());
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	
	public String addComment() {
		System.out.println("进入添加评论管理");
		System.out.println(com.getUser_id());
		Comments comments=new Comments( com.getUser_id(), com.getWine_id(), com.getState(), com.getContent());
		Boolean flag=dao.add(comments);
		System.out.println(flag);
		if(flag) {
			ServletActionContext.getRequest().setAttribute("result", flag);
			return "success";
		}
		else {
			return "fail";
		}
		
	}
	
	/**
	 * 根据id删除评论的方法
	 */
	public void deleteCommentByComid() {
		System.out.println(com.getCom_id());
		boolean result=dao.delete(com.getCom_id());
		System.out.println("delete result:"+result);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), result+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 根据条件搜索评论的方法
	 */
	public void searchCommentByCondition() {
			System.out.println(key);
		   System.out.println(val);
		   ArrayList<Comments> comments=new ArrayList<Comments>();
		   if(key.equals("user_id")){
			   comments=dao.searchCommentByuserid(val);
		   }else if (key.equals("wine_id")) {
			   comments=dao.searchCommentByWineid(val);
		   }else if(key.equals("state")) {
			   comments=dao.searchCommentByState(val);
		   }
		   JSONArray ja=new JSONArray();
		
		for(Comments c:comments) {
			   JSONObject j=new JSONObject();
			   try {
				j.put("com_id", c.getCom_id());
				j.put("user_id", c.getUser_id());
				j.put("wine_id", c.getWine_id());
				j.put("state", c.getState());
				j.put("content", c.getContent());
				ja.put(j);	
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			   }
		   System.out.println(ja.toString());

			try {
				Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
			} catch (Exception e) {
			e.printStackTrace();
			}

		
	}
	
}
