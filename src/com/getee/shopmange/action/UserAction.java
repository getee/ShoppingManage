package com.getee.shopmange.action;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.dao.UserDaoImp;

public class UserAction {
    private User u;
    private User add;
    private UserDaoImp ud;
    
    public UserAction() {
    	ud=new UserDaoImp();
	}

	public User getAdd() {
		return add;
	}

	public void setAdd(User add) {
		this.add = add;
	}

	public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String login(){

        System.out.println(u.getName()+"$$"+u.getPassword());
        return "success";
    }
    public String AddUser() {
    	System.out.println(add);
    	System.out.println(add.getCity());
    	boolean b=ud.addUser(add);
    	System.out.println(b);
    	if(b==true) {
    		return "success";
    	}
    	else {
    		return "fail";
    	}
    }
}
