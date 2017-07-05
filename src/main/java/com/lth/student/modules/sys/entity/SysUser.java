package com.lth.student.modules.sys.entity;


import java.io.Serializable;

public class SysUser implements Serializable{
    public int id;
    public String loginId;
    public String loginPass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
}
