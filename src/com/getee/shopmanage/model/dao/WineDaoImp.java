package com.getee.shopmanage.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Wine;

public class WineDaoImp extends BaseDAOImp implements WineDAO {

	 
	/**
     * 分页获取酒信息
     * 
     * @return wine集合
     */
	@Override
	public ArrayList<Wine> listWineByPage(int page, int count) {
		ArrayList<Wine> wines = new ArrayList<Wine>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from   shop.wine order by wine_id desc   limit  "+(page-1)*count+" ,"+count);
			while (rs.next()) {

				wines.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wines;
	}
	
	
	
	/**
     * 按种类分页获取酒信息
     * 
     * @return wine集合
     */
	
    public ArrayList<Wine> getKindPage(String kind, int page, int count){
    	int startCount=(page-1)*count;
    	String sql="select * from shop.wine where kind='"+kind+"' limit " + startCount+" ,"+count;
    	ArrayList<Wine> winelist=getWinesByPage(sql);
    	return winelist;
    }

    /**
     * 按名字分页获取酒信息
     * 
     * @return wine集合
     */
    public ArrayList<Wine> getNamePage(String name, int page, int count){
    	int startCount=(page-1)*count;
		String sql="select * from shop.wine where wine_name='"+name+"' limit " + startCount+" ,"+count;
 
    	ArrayList<Wine> winelist=getWinesByPage(sql);
    	return winelist;
    }
    
    /**
     * 给一个sql语句，像数据库查询酒信息，返回一个酒集合
     * @param sql
     * @return
     */
    public ArrayList<Wine> getWinesByPage(String sql) {
		Wine wine=null;
		ArrayList<Wine> winelist=null;
		ResultSet rs = null;
		try {
			winelist = new ArrayList<Wine>();
			String sq=sql;
			rs = getSta().executeQuery(sq);
			while(rs.next()){
				wine = new Wine();
				wine.setId(rs.getInt("wine_id"));
				wine.setName(rs.getString("wine_name"));
				wine.setKind(rs.getString("kind"));
				wine.setPrice(rs.getFloat("price"));
				wine.setDetail(rs.getString("detail"));
				wine.setPicture(rs.getString("picture"));
				winelist.add(wine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(  getCon(),getSta(),rs);
		return winelist;

	}

	@Override
	public Wine getIDWine(int id) {

			Wine w=null;
			String sql="select * from shop.wine where wine_id='"+id+"'";
			try {
				ResultSet rs=getSta().executeQuery(sql);
				while(rs.next()) {
					w=new Wine();
					w.setId(rs.getInt("wine_id"));
					w.setName(rs.getString("wine_name"));
					w.setKind(rs.getString("kind"));
					w.setPrice(rs.getDouble("price"));
					w.setDetail(rs.getString("detail"));
					w.setPicture(rs.getString("picture"));
					w.setPicture4(rs.getString("picture4"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return w;

	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public ArrayList<Wine> getWinePage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 添加
	 */
	@Override
	public boolean addWine(Wine w) {
		String  sql="insert into shop.wine (wine_name,kind,price,detail,picture,picture4) values ('"+w.getName()+"','"+w.getKind()+"','"+w.getPrice()+"','"+w.getDetail()+"','"+w.getPicture()+"','"+w.getPicture4()+"')";
		try {
			 getSta().executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

		/**
		 * 修改
		 */
	@Override
	public boolean update(Wine w) {
		String sql=null;
		if(w.getPicture().equals("picture/null")) {
			sql="update shop.wine set wine_name='"+w.getName()+"',kind='"+w.getKind()+"',price='"+w.getPrice()+"',detail='"+w.getDetail()+"',picture4='"+w.getPicture4()+"' where wine_id='"+w.getId()+"'";
			System.out.println("没有修改图片");
		}else {
			sql="update shop.wine set wine_name='"+w.getName()+"',kind='"+w.getKind()+"',price='"+w.getPrice()+"',detail='"+w.getDetail()+"',picture='"+w.getPicture()+"',picture4='"+w.getPicture4()+"' where wine_id='"+w.getId()+"'";
			System.out.println("修改了图片");
			
		}
		try {
			getSta().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	 /**
     * 删除酒信息
     * 
     * @return 
     */
	@Override
	public boolean delete(int id) {
		int  n=0;
		Statement sta=getSta();
		try {
			String sql="delete from  shop.wine where wine_id="+id;
		    n=sta.executeUpdate(sql);
		    System.out.println(sql);
		    System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	public Wine parsetResultToCar(ResultSet rs) {
		Wine c = null;
		try {
			c = new Wine();
			c.setId(rs.getInt("wine_id"));
			c.setName(rs.getString("wine_name"));
			c.setKind(rs.getString("kind"));
			c.setPrice(rs.getDouble("price"));
			c.setDetail(rs.getString("detail"));
			c.setPicture(rs.getString("picture"));
			c.setPicture4(rs.getString("picture4"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;

	}

}
