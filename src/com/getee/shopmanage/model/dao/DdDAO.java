package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.DingDan;

public interface DdDAO {
	/**
	 * 搜索订单
	 * @return
	 */
	public ArrayList<DingDan> searchDd(int user_id); 
	
	/**
	 * 分页显示所有订单
	 * @return
	 */
	public ArrayList<DingDan> listDd(int rows,int page); 
	
	/**
	 * 
	 * 修改后的订单保存到数据库
	 * @param dd
	 * @return
	 */
	public boolean saveDd(DingDan dd);
	
	/**
	 * 搜索共有多少条订单
	 * @return
	 */
	public ArrayList<DingDan> getAllCount();
}
