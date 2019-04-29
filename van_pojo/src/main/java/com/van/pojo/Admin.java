package com.van.pojo;


public class Admin {

  private long admId;
  private String admName;
  private String admPwd;


  public long getAdmId() {
    return admId;
  }

  public void setAdmId(long admId) {
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

    public Admin(long admId, String admName, String admPwd) {
        this.admId = admId;
        this.admName = admName;
        this.admPwd = admPwd;
    }

    public Admin() {
    }
}
