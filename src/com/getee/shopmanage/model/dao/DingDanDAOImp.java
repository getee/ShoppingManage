package com.getee.shopmanage.model.dao;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.bean.Wine;

public class DingDanDAOImp extends BaseDAOImp implements DingDanDAO {

	
	/*
	 * 添加新的订单
	 * (non-Javadoc)
	 * @see com.getee.shopmanage.model.dao.DingDanDAO#addDD(int, int, int)
	 */
	@Override
	public boolean addDD(int user_id,int dd_id,int wine_id) {
		Statement sta=getSta();//获取连接
		String sql="insert into shop.dingdan(user_id,dd_id,wine_id) values("+user_id+","+dd_id+","+wine_id+")";//添加数据
		try {
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		 disposeResource(sta);
		return true;
	}

	
	/*
	 *删除订单
	 *(non-Javadoc)
	 * @see com.getee.shopmanage.model.dao.DingDanDAO#delDD(int)
	 */
		@Override
	public boolean delDD(int dd_id) {
			 Statement sta=getSta();
		        String sql="delete from shop.dingdan where dd_id="+dd_id+"";
		        try {
		            sta.executeUpdate(sql);
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		        disposeResource(sta);
			     return true;
	}

}
