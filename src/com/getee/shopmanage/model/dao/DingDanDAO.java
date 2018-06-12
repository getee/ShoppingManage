package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.DingDan;
import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.bean.Wine;

public interface DingDanDAO {
  /*
   * 添加新的订单
   */
    public boolean addDD(Object o);
    
   /*
    * 删除订单
    */
    public boolean delDD(Object o);
   
    /*
     * 复选框
     */
    public int watchcount();
    
    /*
     * 分页
     */
    public ArrayList<DingDan> list(int row, int page);
    
}
