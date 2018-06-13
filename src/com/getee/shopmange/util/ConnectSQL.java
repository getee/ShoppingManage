package com.getee.shopmange.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectSQL {
    String url="jdbc:mysql://rm-wz97w0rps07c1wrg0ao.mysql.rds.aliyuncs.com:3306?zeroDateTimeBehavior=convertToNull";
    String user="admin";
    String pass="admin";
    
    public static void main(String[] args) {
        new ConnectSQL().selectResult();
        
    }
    public void selectResult(){

        try {
            Class.forName("com.mysql.jdbc.Driver");//反射加载
            Connection con=DriverManager.getConnection(url,user,pass);//对象链接
            if(!con.isClosed()){
                System.out.println("链接成功！");
            }
            //主键都设置自动增长不用指定id值，添加用户
            //String sql="insert into shop.users(user_name,password,picture) values('"+name+"','"+password+"','images/undefine.jpg')";
            //更改用户信息
            //String sql="update shop.users set user_name='"+u.getName()+"', address='"+u.getAddress()+"', phone="+u.getPhone()+", picture='"+u.getPicture()+"' where user_id="+u.getId();
            //删除用户信息
            //String sql="delete from shop.users where user_id="+u.id;

            Statement sta=con.createStatement();//创建会话
            sta.executeUpdate("update shop.dingdan set user_id="+1+",dd_id="+8+", wine_id="+11+",number="+111+",prices="+111+",state="+1+" where user_id="+1+" and dd_id="+8);
            /*ResultSet rs=sta.executeQuery("select * FROM shop.dingdan where user_id="+1+" and dd_id="+8);
            while(rs.next()){
                //System.out.println(rs.getInt("wine_id")+rs.getString("wine_name")+"="+rs.getString("kind"));
                System.out.println("订单号："+rs.getInt("dd_id")+"用户："+rs.getInt("user_id")+"商品："+rs.getInt("wine_id")+"状态："+rs.getInt("state")+"数量："+rs.getInt("number")+"总价："+rs.getFloat("prices"));
            }
            rs.close();//关闭结果集 
*/           sta.close();//关闭会话
            con.close();//关闭链接
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println("链接结束");
        }
    }
}
