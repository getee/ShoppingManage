package com.getee.shopmanage.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.DingDan;

public class DingDanDAOImp extends BaseDAOImp implements DingDanDAO {
	
	/*
	 * 添加新的订单
	 * (non-Javadoc)
	 * @see com.getee.shopmanage.model.dao.DingDanDAO#addDD(int, int, int)
	 */
	@Override
	public boolean addDD(Object o) {
		DingDan dd=(DingDan)o;
		ResultSet rs=null;
		boolean result=false;
		System.out.println(dd.toString());
		try {
			rs=getSta().executeQuery("select dd_id from shop.dingdan where dd_id="+dd.getDd_id());
			if(rs.next()){
				result=false;	
			}
			else{
				System.out.println("进入");
				int count=getSta().executeUpdate("insert into shop.dingdan(user_id, dd_id, wine_id,number,prices,state) values("+dd.getUser_id()+", "+dd.getDd_id()+","+dd.getWine_id()+","+dd.getNumber()+","+dd.getPrices()+","+dd.getState()+")");
				result = (count>0)?true:false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/*
	 *删除订单
	 *(non-Javadoc)
	 * @see com.getee.shopmanage.model.dao.DingDanDAO#delDD(int)
	 */
		@Override
	public boolean delDD(Object o) {
			DingDan c=(DingDan)o;
			boolean result=false;
		        try {
		        	System.out.println("shangmian"+c.toString());
		        	String str="delete from shop.dingdan where dd_id="+c.getDd_id()+"";
		        	System.out.println("SS"+str);
		        	//System.out.println(getSta().executeUpdate("delect from shop.dingdan where dd_id="+c.getDd_id()+""));
		            int count=getSta().executeUpdate(str);
		            result = (count>0)?true:false;
		            System.out.println(count);
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		        disposeResource(sta);
			     return result;
	}
		/*
		 * 复选框
		 */
		 public int watchcount(){
			int n=0;
			ResultSet rs=null;
			try {
				rs=getSta().executeQuery("select count(dd_id) from shop.dingdan");
				rs.next();
				n=rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return n;
		 }
		/*
		 * 分页
		 */


		@Override
		public ArrayList<DingDan> list(int row, int page) {
				ResultSet rs = null;
				ArrayList<DingDan> al = new ArrayList<>();
				try {
					rs = getSta().executeQuery("select * from shop.dingdan limit "+(page-1)*row+","+row);
					while(rs.next()) {
						DingDan dd = new DingDan();//这个是建立节点，必须一个一个的建
						dd.setDd_id(rs.getInt("dd_id"));
						dd.setUser_id(rs.getInt("user_id"));
						dd.setWine_id(rs.getInt("wine_id"));
						dd.setNumber(rs.getInt("number"));
						dd.setPrices(rs.getFloat("prices"));
						dd.setState(rs.getInt("state"));
						al.add(dd);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return al;
			}
		
		
		 
		
		
		

}
