package com.van.pojo;


public class Users {

  private String userId;
  private String userName;
  private String userSex;
  private String userPhone;
  private String userAddr;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserAddr() {
    return userAddr;
  }

  public void setUserAddr(String userAddr) {
    this.userAddr = userAddr;
  }

    public Users(String userId, String userName, String userSex, String userPhone, String userAddr) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userAddr = userAddr;
    }

  public Users(String userId) {
    this.userId = userId;
  }

  public Users() {
    }
}
