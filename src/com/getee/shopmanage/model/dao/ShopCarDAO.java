package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.*;
public interface ShopCarDAO {
    /**
     * 分页获取,根据uid获取购物车信息
     * @param 用户id
     * @return 该用户添加的购物车，酒的信息
     */
    public ArrayList<Wine> getUserWine(int uid,int page, int count);
    
    /**
     * 分页获取,根据酒wid获取被哪些用户添加到购物车
     * @param 酒id
     * @return 用户信息
     */
    public ArrayList<User> getWineUser(int wid,int page, int count);
    
    /**
     * 添加购物车
     * @param uid 用户id
     * @param wid 酒id
     * @param number 数量
     * @return
     */
    public boolean addShopCar(int uid,int wid,int number);
    
    /**
     * 修改购物车
     * @param uid 用户id
     * @param wid 酒id
     * @param number 数量
     * @return
     */
    public boolean updateShopCar(int uid,int wid,int number);//只能修改购物车中商品数量
    
    /**
     * 删除购物车
     * @param uid 用户id
     * @param wid 酒id
     * @return
     */
    public boolean delShopCar(int uid,int wid);
}
