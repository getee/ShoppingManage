package com.getee.shopmanage.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;

/*CREATE TABLE users
(
	user_id int NOT NULL AUTO_INCREMENT,
	user_name varchar(20) NOT NULL,
	password varchar(99) NOT NULL,
	-- 省
	province varchar(20) COMMENT '省',
	-- 市
	city varchar(20) COMMENT '市',
	phone int(11),
	picture varchar(99),
	PRIMARY KEY (user_id),
	UNIQUE (user_name)
);*/
public class UserDaoImp extends BaseDAOImp implements UserDAO{

	@Override
	public User getIDUser(int id) {
		String sql="select * from shop.users where user_id="+id;
		User u=null;
		ResultSet rs=null;
		Statement sta=getSta();
		try {
			rs=sta.executeQuery(sql);
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt("user_id"));
				u.setName(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
				u.setProvince(rs.getString("province"));
				u.setCity(rs.getString("city"));
				u.setPhone(rs.getInt("phone"));
				u.setPicture(rs.getString("picture"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(sta,rs);
		return u;
	}

	@Override
	public User getNameUser(String name) {
		return null;
	}

	@Override
	public int getSize() {
		int count=0;
		String sql="select * from shop.users";
		ResultSet rs=null;
		Statement sta=getSta();
		try {
			rs=sta.executeQuery(sql);
			while(rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return count;
	}

	@Override
	public ArrayList<User> getUserPage(int page, int count) {
		return null;
	}

	@Override
	public ArrayList<User> searchNameUser(String name, int page, int count) {
		return null;
	}

	@Override
	public boolean addUser(String name, String password) {
		String sql="insert into shop.users(user_name,password) values('"+name+"','"+password+"')";
		int count=0;
		Statement sta=getSta();
		try {
			count=sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		disposeResource(sta);
		if(count>0) {
			return true;
		}
		else
			return false;
	}
	@Override
	public boolean update(User u) {
		 User uu=getNameUser(u.getName());//确定存在同名项
	        if(uu!=null)
	            if(uu.getId()!=u.getId()) return false;//且用户id不同，则用户名已被占用
		String sql="update shop.users set user_name ='"+u.getName()+"',password='"+u.getPassword()+"',province='"+u.getProvince()+"',city='"+u.getCity()+"',phone="+u.getPhone()+",picture='"+u.getPicture()+"' where user_id="+u.getId();
		int count=0;
		Statement sta=getSta();
		try {
			count=sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		disposeResource(sta);
		if(count>0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean delete(int id) {
		
		String sql="delete from shop.users where user_id="+id;
		int count=0;
		Statement sta=getSta();
		try {
			count=sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		disposeResource(sta);
		if(count>0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public ArrayList<User> searchProvinceUser(String name, int page, int count) {
		return null;
	}

	@Override
	public boolean addUser(User u) {
		String sql="insert into shop.users(user_name,password,province,city,phone,picture) values('"+u.getName()+"','"+u.getPassword()+"','"+u.getProvince()+"','"+u.getCity()+"',"+u.getPhone()+",'"+u.getPicture()+"')";
		System.out.println(sql);
		int count=0;
		Statement sta=getSta();
		try {
			count=sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		disposeResource(sta);
		if(count>0) {
			return true;
		}
		else
			return false;
	}

}
