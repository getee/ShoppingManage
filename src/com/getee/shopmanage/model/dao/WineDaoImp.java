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
		// TODO Auto-generated method stub
		return null;
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
		String sql="update shop.wine set wine_name='"+w.getName()+"',kind='"+w.getKind()+"',price='"+w.getPrice()+"',detail='"+w.getDetail()+"',picture='"+w.getPicture()+"',picture4='"+w.getPicture4()+"' where wine_id='"+w.getId()+"'";
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
