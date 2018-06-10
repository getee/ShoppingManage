package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.bean.Wine;

public interface DingDanDAO {
  /*
   * 添加新的订单
   *@param user_id
   * @param dd_id
   * @param number
   * @return
   */
    public boolean addDD(int user_id, int dd_id,int wine_id);
    
    /**
     * 删除订单
     * 通过删除订单ID来删除订单
     */
    public boolean delDD(int dd_id);
}
