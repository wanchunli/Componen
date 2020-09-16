package com.anso.componen.bean;

import java.io.Serializable;

public class Token implements Serializable {


    private String token;
    private String linkPhone;
    private String userName;
    private String loginType;
    private int userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", loginType='" + loginType + '\'' +
                ", userId=" + userId +
                '}';
    }
}
