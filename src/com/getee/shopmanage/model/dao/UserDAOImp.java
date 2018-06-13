package com.getee.shopmanage.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;

public class UserDAOImp extends BaseDAOImp implements UserDAO {
/**
 * 
 */
	@Override
	public ArrayList<User> getIDUser(String val) {
	 ArrayList<User>  us=new ArrayList<User>();
		  PreparedStatement ps=null;
		  ResultSet rs=null;
			 try {
				ps=getCon().prepareStatement("select * from shop.users where user_id=? ");
				ps.setString(1, val);
				//ps.setInt(2, (page-1)*count);
				// ps.setInt(3, count);
				 rs=ps.executeQuery();
				 while(rs.next()) {
					 User u=new User();
					 u.setId(rs.getInt("user_id"));
					 u.setName(rs.getString("user_name"));
					 u.setCity(rs.getString("city"));
					 u.setProvince(rs.getString("province"));
					 u.setPhone(rs.getInt("phone"));
					 u.setPicture(rs.getString("picture"));
					 us.add(u);
					 System.out.println(u);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}disposeResource(ps, rs);
			return us;
	}

	@Override
	public User getNameUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
/**
 * 这是得到所有用户user的方法
 */
	@Override
	public ArrayList<User> getUserPage(int page, int count) {
		
		  ArrayList<User> user =new ArrayList<>();
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		
		 try {
			ps=getCon().prepareStatement("select * from shop.users order by user_id desc limit ?,?");
			 ps.setInt(1, (page-1)*count);
			 ps.setInt(2, count);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 User u=new User();
				 u.setId(rs.getInt("user_id"));
				 u.setName(rs.getString("user_name"));
				 u.setCity(rs.getString("city"));
				 u.setProvince(rs.getString("province"));
				 u.setPhone(rs.getInt("phone"));
				 u.setPicture(rs.getString("picture"));
				 user.add(u);
				 System.out.println(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}disposeResource(ps, rs);
		return user;
	}

	@Override
	public ArrayList<User> searchNameUser(String val, int page, int count) {
	   ArrayList<User>  us=new ArrayList<User>();
	   PreparedStatement ps=null;
	  ResultSet rs=null;
		 try {
			ps=getCon().prepareStatement("select * from shop.users where user_name=? ");
			ps.setString(1, val);
			//ps.setInt(2, (page-1)*count);
			// ps.setInt(3, count);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 User u=new User();
				 u.setId(rs.getInt("user_id"));
				 u.setName(rs.getString("user_name"));
				 u.setCity(rs.getString("city"));
				 u.setProvince(rs.getString("province"));
				 u.setPhone(rs.getInt("phone"));
				 u.setPicture(rs.getString("picture"));
				 us.add(u);
				 System.out.println(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}disposeResource(ps, rs);
		return us;
	}
	public ArrayList<User> searchProvinceUser(String val, int page, int count) {
		 ArrayList<User>  us=new ArrayList<User>();
		   PreparedStatement ps=null;
			  ResultSet rs=null;
				 try {
					ps=getCon().prepareStatement("select * from shop.users where province=? ");
					ps.setString(1, val);
					//ps.setInt(2, (page-1)*count);
					// ps.setInt(3, count);
					 rs=ps.executeQuery();
					 while(rs.next()) {
						 User u=new User();
						 u.setId(rs.getInt("user_id"));
						 u.setName(rs.getString("user_name"));
						 u.setCity(rs.getString("city"));
						 u.setProvince(rs.getString("province"));
						 u.setPhone(rs.getInt("phone"));
						 u.setPicture(rs.getString("picture"));
						 us.add(u);
						 System.out.println(u);
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}disposeResource(ps, rs);
				return us;
	}
	
	public ArrayList<User> searchCityUser(String val,int page, int count){
		 ArrayList<User>  us=new ArrayList<User>();
		   PreparedStatement ps=null;
			  ResultSet rs=null;
				 try {
					ps=getCon().prepareStatement("select * from shop.users where city=? ");
					ps.setString(1, val);
					//ps.setInt(2, (page-1)*count);
					// ps.setInt(3, count);
					 rs=ps.executeQuery();
					 while(rs.next()) {
						 User u=new User();
						 u.setId(rs.getInt("user_id"));
						 u.setName(rs.getString("user_name"));
						 u.setCity(rs.getString("city"));
						 u.setProvince(rs.getString("province"));
						 u.setPhone(rs.getInt("phone"));
						 u.setPicture(rs.getString("picture"));
						 us.add(u);
						 System.out.println(u);
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}disposeResource(ps, rs);
				return us;
	}

	
	
	@Override
	public boolean addUser(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
