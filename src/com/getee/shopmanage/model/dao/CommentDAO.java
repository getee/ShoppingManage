package com.getee.shopmanage.model.dao;

import java.util.ArrayList;

import com.getee.shopmanage.model.bean.Comments;

public interface CommentDAO {
	 /**
     * 根据条件查找相应的评论
     */
	public  ArrayList<Comments> searchCommentByuserid(String val );
	/**
     * 根据条件查找相应的评论
     */
	public  ArrayList<Comments> searchCommentByWineid(String val);
	/**
     * 根据条件查找相应的评论
     */
	public  ArrayList<Comments> searchCommentByState(String val);
	 /**
	 /**
     * 查找相应的评论的总数量
     */
	public  int getAllCountOfComment();
	/**
     * 分页显示相应的评论
     */
	public ArrayList<Comments> listCommentByPage(int rows ,int page);
	//public ArrayList<Comments> listCommentByPage();
	/**
     * 根据com_id删除相应的评论
     */
	public boolean delete(int  com_id);
	/**
     * 添加相应的评论
     */
	public boolean add(Object o);
	
}
