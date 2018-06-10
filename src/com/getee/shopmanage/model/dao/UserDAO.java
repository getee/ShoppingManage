package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;

public interface UserDAO {
    /**
     * 根据ID获取用户数据
     */
    public ArrayList<User> getIDUser(String val);

    /**
     * 根据Name获取用户数据(每个用户名都是唯一的)
     */
    public User getNameUser(String name);

    /**
     * 获取总共用户的数量
     */
    public int getSize();

    /**
     * 分页获取用户信息
     */
    public ArrayList<User> getUserPage(int page, int count);

    /**
     * 分页获取,按用戶名搜索用户信息
     */
    public ArrayList<User> searchNameUser(String val,int page, int count);// 按%name%条件搜索用户
    
    /**
     * 分页获取,按城市搜索用户信息
     */
    public ArrayList<User> searchProvinceUser(String val,int page, int count);// 按城市条件搜索用户
	

    /**
     * 新添加用户数据(id会自动增长)
     */
    public boolean addUser(String name, String password);

    /**
     * 修改用户数据(用户id,name不可修改)
     */
    public boolean update(User u);

    /**
     * 删除用户数据
     */
    public boolean delete(int id);
}
