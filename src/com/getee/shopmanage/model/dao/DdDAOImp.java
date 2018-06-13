package com.getee.shopmanage.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.DingDan;

public class DdDAOImp extends BaseDAOImp  implements DdDAO {
	@Override
	public ArrayList<DingDan> searchDd(int user_id) {
		ArrayList<DingDan> dds=new ArrayList<>();
		DingDan dd;
		ResultSet rs=null;
		Statement sta=null;//创建会话
		try {
			sta=getSta();
			rs=sta.executeQuery("select *  from  shop.dingdan where user_id="+user_id);
			while(rs.next()){
				dd=new DingDan();
				dd.setDd_id(rs.getInt("dd_id"));
				dd.setUser_id(rs.getInt("user_id"));
				dd.setWine_id(rs.getInt("wine_id"));
				dd.setState(rs.getInt("state"));
				dd.setNumber(rs.getInt("number"));
				dd.setPrices(rs.getFloat("prices"));
				dds.add(dd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getCon(),getSta(), rs);
		return  dds;
	}

	@Override
	public ArrayList<DingDan> listDd(int rows,int page) {
		ArrayList<DingDan> dds=new ArrayList<>();
		DingDan dd;
		ResultSet rs=null;
		Statement sta=null;//创建会话
		try {
			sta=getSta();
			rs=sta.executeQuery("select *  from  shop.dingdan limit  "+(page-1)*rows+" , "+rows);
			while(rs.next()){
				dd=new DingDan();
				dd.setDd_id(rs.getInt("dd_id"));
				dd.setUser_id(rs.getInt("user_id"));
				dd.setWine_id(rs.getInt("wine_id"));
				dd.setState(rs.getInt("state"));
				dd.setNumber(rs.getInt("number"));
				dd.setPrices(rs.getFloat("prices"));
				dds.add(dd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getCon(),getSta(), rs);
		return  dds;
	}

	@Override
	public boolean saveDd(DingDan dd) {
		Statement sta=null;//创建会话
		int result=0;
		try {
			sta=getSta();
			String sql="update shop.dingdan set user_id="+dd.getUser_id()+",dd_id="+dd.getDd_id()+", wine_id="+dd.getWine_id()+",number="+dd.getNumber()+",prices="+dd.getPrices()+",state="+dd.getState()+" where user_id="+dd.getUser_id()+" and dd_id="+dd.getDd_id();
			result=sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getSta());
		return result>0?true:false;
	}
	public ArrayList<DingDan> getAllCount(){
		ArrayList<DingDan> dds=new ArrayList<>();
		DingDan dd;
		ResultSet rs=null;
		Statement sta=null;//创建会话
		try {
			sta=getSta();
			rs=sta.executeQuery("select *  from  shop.dingdan");
			while(rs.next()){
				dd=new DingDan();
				dd.setDd_id(rs.getInt("dd_id"));
				dd.setUser_id(rs.getInt("user_id"));
				dd.setWine_id(rs.getInt("wine_id"));
				dd.setState(rs.getInt("state"));
				dd.setNumber(rs.getInt("number"));
				dd.setPrices(rs.getFloat("prices"));
				dds.add(dd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getCon(),getSta(), rs);
		return  dds;
	}
}
