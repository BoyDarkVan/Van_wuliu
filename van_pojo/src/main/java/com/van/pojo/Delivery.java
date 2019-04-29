package com.van.pojo;


import java.sql.Timestamp;

public class Delivery {

  private String psId;
  private String aptId;
  private String stId;
  private String ckId;
  private java.sql.Timestamp psPicktime;
  private java.sql.Timestamp psDelitime;
  private String psType;
  private String psName;


  public String getPsId() {
    return psId;
  }

  public void setPsId(String psId) {
    this.psId = psId;
  }


  public String getAptId() {
    return aptId;
  }

  public void setAptId(String aptId) {
    this.aptId = aptId;
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


  public java.sql.Timestamp getPsPicktime() {
    return psPicktime;
  }

  public void setPsPicktime(java.sql.Timestamp psPicktime) {
    this.psPicktime = psPicktime;
  }


  public java.sql.Timestamp getPsDelitime() {
    return psDelitime;
  }

  public void setPsDelitime(java.sql.Timestamp psDelitime) {
    this.psDelitime = psDelitime;
  }


  public String getPsType() {
    return psType;
  }

  public void setPsType(String psType) {
    this.psType = psType;
  }


  public String getPsName() {
    return psName;
  }

  public void setPsName(String psName) {
    this.psName = psName;
  }

    public Delivery(String psId, String aptId, String stId, String ckId, Timestamp psPicktime, Timestamp psDelitime, String psType, String psName) {
        this.psId = psId;
        this.aptId = aptId;
        this.stId = stId;
        this.ckId = ckId;
        this.psPicktime = psPicktime;
        this.psDelitime = psDelitime;
        this.psType = psType;
        this.psName = psName;
    }

    public Delivery() {
    }
}
