package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.bean.Wine;

public interface DingDanDAO {
	 /**
     * 分页获取,根据用户ID(uid)获取订单信息
     * @param 用户id
     * @return 该用户添加的订单，酒的信息
     */
    public ArrayList<Wine> getUserWine(int uid,int page, int count);
    
    /**
     * 分页获取,根据酒的ID(wid)获取jiu被哪些用户添加
     * @param 酒id
     * @return 用户信息
     */
    public ArrayList<User> getWineUser(int wid,int page, int count);
	
    /**
     * 添加订单
     * @param uid 用户id
     * @param wid 酒id
     * @param number 数量
     * @return
     */
    public boolean addDD(int uid,int wid,int number);
    
    /**
     * 删除订单
     */
    public boolean delDD(int id);
}
