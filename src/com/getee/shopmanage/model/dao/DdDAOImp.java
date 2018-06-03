package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.bean.Wine;

public class DdDAOImp extends BaseDAOImp implements DdDAO {
	
     
     
	/*
	 * 分页获取,根据用户ID(uid)获取订单信息
     * @param 用户id
     * @return 该用户添加的订单，酒的信息
	 * (non-Javadoc)
	 * @see com.getee.shopmanage.model.dao.DdDAO#getUserWine(int, int, int)
	 */
	@Override
	public ArrayList<Wine> getUserWine(int uid, int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getWineUser(int wid, int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDD(int uid, int wid, int number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delDD(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
