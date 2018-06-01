package com.getee.shopmange.action;

import com.getee.shopmanage.model.bean.User;

public class UserAction {
    private User u;
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
}
