package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Wine;

public interface WineDAO {
    /**
     * 根据ID获取酒数据
     */
    public Wine getIDWine(int id);

    /**
     * 获取总共酒的数量
     */
    public int getSize();

    /**
     * 分页获取酒信息
     * 
     * @return wine集合
     */
    ArrayList<Wine> listWineByPage(int page, int count);

    /**
     * 按种类分页获取酒信息
     * 
     * @return wine集合
     */
    public ArrayList<Wine> getKindPage(String kind, int page, int count);

    /**
     * 按名字分页获取酒信息
     * 
     * @return wine集合
     */
    public ArrayList<Wine> getNamePage(String name, int page, int count);

    /**
     * 添加酒信息(id会自动增长)
     * 
     * @param w
     * @return
     */
    public boolean addWine(Wine w);

    /**
     * 修改酒信息(id不可更改)
     * 
     * @param w
     * @return
     */
    public boolean update(Wine w);

    /**
     * 删除酒
     * 
     * @param id
     * @return
     */
    public boolean delete(int id);

	
}
