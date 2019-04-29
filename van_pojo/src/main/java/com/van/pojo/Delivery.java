package com.van.pojo;


import java.sql.Date;

public class Delivery {

  private String psId;
  private String aptId;
  private String stId;
  private String ckId;
  private Date psPicktime;
  private Date psDelitime;
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


  public Date getPsPicktime() {
    return psPicktime;
  }

  public void setPsPicktime(Date psPicktime) {
    this.psPicktime = psPicktime;
  }


  public Date getPsDelitime() {
    return psDelitime;
  }

  public void setPsDelitime(Date psDelitime) {
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

    public Delivery(String psId, String aptId, String stId, String ckId, Date psPicktime, Date psDelitime, String psType, String psName) {
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
