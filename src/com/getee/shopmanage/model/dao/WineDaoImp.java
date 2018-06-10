package com.getee.shopmanage.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Wine;

public class WineDaoImp extends BaseDAOImp implements WineDAO {
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
	public boolean addWine(Wine w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Wine w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
