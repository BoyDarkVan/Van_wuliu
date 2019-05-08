package com.van.pojo;


import java.io.Serializable;

public class Admin implements Serializable {

  private Integer admId;
  private String admName;
  private String admPwd;


  public long getAdmId() {
    return admId;
  }

  public void setAdmId(Integer admId) {
    this.admId = admId;
  }


  public String getAdmName() {
    return admName;
  }

  public void setAdmName(String admName) {
    this.admName = admName;
  }


  public String getAdmPwd() {
    return admPwd;
  }

  public void setAdmPwd(String admPwd) {
    this.admPwd = admPwd;
  }

    public Admin(Integer admId, String admName, String admPwd) {
        this.admId = admId;
        this.admName = admName;
        this.admPwd = admPwd;
    }

    public Admin() {
    }

    public Admin(Integer admId,String admPwd){
      this.admId = admId;
      this.admPwd = admPwd;
    }
}
