package com.getee.shopmange.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.dao.UserDAO;
import com.getee.shopmanage.model.dao.UserDAOImp;
import com.getee.shopmange.util.Responser;

import jdk.nashorn.internal.runtime.JSONListAdapter;

public class UserAction implements RequestAware{
    private Map<String, Object> request=new HashMap<>();
    private UserDAO dao; 
    private String key;//搜索用户的列名
    private String val;//搜索用户的值

	private int page;
    private int count;
    private String name;
 
 

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String value) {
		this.val= val;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  
	public void UserAction() {
      dao=new UserDAOImp();
	}


	private User u;
    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String login(){

        System.out.println(u.getName()+"$$"+u.getPassword());
        return "success";
    }
    
    
    /**
     * 这是显示所有用户的方法
     * @param page
     * @param count
     */
   public void listUser() {
	   System.out.println(page+"/n "+count);
	   UserDAOImp dao=new  UserDAOImp();
	   ArrayList<User> user=dao.getUserPage( page, count);
	   JSONArray ja=new JSONArray();
	   for(User u:user) {
		   JSONObject j=new JSONObject();
		   try {
			j.put("userid", u.getId());
			j.put("username", u.getName());
			j.put("phone", u.getPhone());
			j.put("province", u.getProvince());
			j.put("city", u.getCity());
			j.put("picture", "<img src='\"+u.getPicture()+\"' style='width:20px;height:20px' />");
			ja.put(j);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
	   System.out.println(ja.toString());

		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
   /**
    * 这是搜索用户的方法
    */
   public void searchUsers() {
	   System.out.println(key);
	   System.out.println(val);
	   UserDAOImp dao=new  UserDAOImp();
	   ArrayList<User> users=new ArrayList<User>();
	   if(key.equals("username")){
		 users=dao.searchNameUser(val, page, count);
	   }else if (key.equals("userid")) {
		   users=dao.getIDUser(val);
	   }else if(key.equals("province")) {
		   users=dao.searchProvinceUser(val, page, count);
	   }
	   JSONArray ja=new JSONArray();
	
	for(User u:users) {
		   JSONObject j=new JSONObject();
		   try {
			j.put("userid", u.getId());
			j.put("username", u.getName());
			j.put("phone", u.getPhone());
			j.put("province", u.getProvince());
			j.put("city", u.getCity());
			j.put("picture", "<img src='\"+u.getPicture()+\"' style='width:20px;height:20px' />");
			ja.put(j);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
	   System.out.println(ja.toString());

		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
	@Override
	public void setRequest(Map<String, Object> arg0) {
	
		
	}



    
}
