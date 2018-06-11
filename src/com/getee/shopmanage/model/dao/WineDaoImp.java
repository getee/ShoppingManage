package com.getee.shopmanage.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Wine;

public class WineDaoImp extends BaseDAOImp implements WineDAO {

	public WineDaoImp() {
		// TODO Auto-generated constructor stub
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

	@Override
	public ArrayList<Wine> getWinePage(int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Wine> getKindPage(String kind, int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Wine> getNamePage(String name, int page, int count) {
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

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
