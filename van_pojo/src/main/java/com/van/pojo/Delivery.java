package com.van.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

public class Delivery implements Serializable {

  private static final long serialVersionUID = -1L;

  private String psId;

  private String cptId;

  private String stId;

  private String ckId;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date psPicktime;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date psDelitime;
  private String psType;
  private String psName;

//  接收人
  private Accept accept;

//  员工
  private Staff staff;

//仓库
  private Warehouse warehouse;

  public Accept getAccept() {
    return accept;
  }

  public void setAccept(Accept accept) {
    this.accept = accept;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  public String getPsId() {
    return psId;
  }

  public void setPsId(String psId) {
    this.psId = psId;
  }

  public String getCptId() {
    return cptId;
  }

  public void setCptId(String cptId) {
    this.cptId = cptId;
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

    public Delivery(String psId, String cptId, String stId, String ckId, Date psPicktime, Date psDelitime, String psType, String psName) {
        this.psId = psId;
        this.cptId = cptId;
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
