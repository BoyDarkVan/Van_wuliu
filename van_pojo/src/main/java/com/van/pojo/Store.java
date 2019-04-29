package com.van.pojo;


import java.sql.Timestamp;

public class Store {

  private String sId;
  private java.sql.Timestamp sTime;
  private java.sql.Timestamp sOutime;
  private String sCount;
  private String sOutcount;
  private String stId;
  private String ckId;
  private String gId;


  public String getSId() {
    return sId;
  }

  public void setSId(String sId) {
    this.sId = sId;
  }


  public java.sql.Timestamp getSTime() {
    return sTime;
  }

  public void setSTime(java.sql.Timestamp sTime) {
    this.sTime = sTime;
  }


  public java.sql.Timestamp getSOutime() {
    return sOutime;
  }

  public void setSOutime(java.sql.Timestamp sOutime) {
    this.sOutime = sOutime;
  }


  public String getSCount() {
    return sCount;
  }

  public void setSCount(String sCount) {
    this.sCount = sCount;
  }


  public String getSOutcount() {
    return sOutcount;
  }

  public void setSOutcount(String sOutcount) {
    this.sOutcount = sOutcount;
  }


  public String getStId() {
    return stId;
  }

  public void setStId(String stId) {
    this.stId = stId;
  }


  public String getCkId() {
    return ckId;
  }

  public void setCkId(String ckId) {
    this.ckId = ckId;
  }


  public String getGId() {
    return gId;
  }

  public void setGId(String gId) {
    this.gId = gId;
  }

    public Store(String sId, Timestamp sTime, Timestamp sOutime, String sCount, String sOutcount, String stId, String ckId, String gId) {
        this.sId = sId;
        this.sTime = sTime;
        this.sOutime = sOutime;
        this.sCount = sCount;
        this.sOutcount = sOutcount;
        this.stId = stId;
        this.ckId = ckId;
        this.gId = gId;
    }

    public Store() {
    }
}
