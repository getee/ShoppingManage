  package com.getee.shopmanage.model.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Comments;

public class CommentDAOImp extends BaseDAOImp implements CommentDAO{
	/**
	 * 根据条件进行搜索评论
	 */
	@Override
	public ArrayList<Comments> searchCommentByuserid(String val) {
		String SQL="select * from shop.comments where user_id="+val;  
		System.out.println(SQL);
		ArrayList<Comments>  comments=new ArrayList<>();
		PreparedStatement sta=null;
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery(SQL);
			while(rs.next()) {
				Comments comment=new Comments();
				comment.setUser_id(rs.getInt("user_id"));
				comment.setCom_id(rs.getInt("com_id"));
				comment.setWine_id(rs.getInt("wine_id"));
				comment.setState(rs.getInt("state"));
				comment.setContent(rs.getString("content"));	
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta,rs);
		return comments;			
	}
	/**
	 * 根据评论ID查找总数量
	 */
	@Override
	public int getAllCountOfComment() {
		int  n=0;
		ResultSet  rs=null;
		try {
			  rs=getSta().executeQuery("select count(com_id)  from  shop.comments ");
			  rs.next();
			  n=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * 根据分页进行显示
	 */
	@Override
	public ArrayList<Comments> listCommentByPage( int page,int rows) {
		//public ArrayList<Comments> listCommentByPage( ) {
		ArrayList<Comments>  comments=new ArrayList<>();
		String sql="select * from shop.comments   limit  "+(page-1)*rows+" ,"+rows;
		//String sql="select * from shop.comments ";
		System.out.println(sql);
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery(sql);	
			while(rs.next()) {
				Comments comment=new Comments();
				comment.setUser_id(rs.getInt("user_id"));
				comment.setCom_id(rs.getInt("com_id"));
				comment.setWine_id(rs.getInt("wine_id"));
				comment.setState(rs.getInt("state"));
				comment.setContent(rs.getString("content"));
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource( sta,rs);
		return comments;
	}
	/**
	 * 根据评论ID删除评论
	 */
	@Override
	public boolean delete(int com_id) {
		int  n=0;
		String sql="delete from  shop.comments where  com_id="+com_id;
		ResultSet rs=null;
		try {
			n=getSta().executeUpdate(sql);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}
	/**
	 * 添加评论
	 */
	@Override
	public boolean add(Object o) {
		String sql="insert into shop.comments(user_id,wine_id,state,content) values (?,?,?,?) "; 			
		Comments com=(Comments) o;
		PreparedStatement pres=null;
		try {
				pres=(PreparedStatement) getCon().prepareStatement(sql);			 
				pres.setInt(1,  com.getUser_id());
				pres.setInt(2, com.getWine_id());				
				pres.setInt(3, com.getState());
				pres.setString(4,com.getContent());
				pres.executeUpdate();			
		}catch (SQLException e) {
			e.printStackTrace();	
			return false;
		}	
		return true;		
	}
	@Override
	public ArrayList<Comments> searchCommentByWineid(String val) {
		String SQL="select * from shop.comments where wine_id="+val;  
		System.out.println(SQL);
		ArrayList<Comments>  comments=new ArrayList<>();
		PreparedStatement sta=null;
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery(SQL);
			while(rs.next()) {
				Comments comment=new Comments();
				comment.setUser_id(rs.getInt("user_id"));
				comment.setCom_id(rs.getInt("com_id"));
				comment.setWine_id(rs.getInt("wine_id"));
				comment.setState(rs.getInt("state"));
				comment.setContent(rs.getString("content"));	
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta,rs);
		return comments;			
	}
	@Override
	public ArrayList<Comments> searchCommentByState(String val) {
		String SQL="select * from shop.comments where state="+val;  
		System.out.println(SQL);
		ArrayList<Comments>  comments=new ArrayList<>();
		Statement sta=null;
		ResultSet rs=null;
		try {
			sta=getSta();
			rs=sta.executeQuery(SQL);
			while(rs.next()) {
				Comments comment=new Comments();
				comment.setUser_id(rs.getInt("user_id"));
				comment.setCom_id(rs.getInt("com_id"));
				comment.setWine_id(rs.getInt("wine_id"));
				comment.setState(rs.getInt("state"));
				comment.setContent(rs.getString("content"));
				System.out.println("6666666"+comment);
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta,rs);
		return comments;			
	}

}
