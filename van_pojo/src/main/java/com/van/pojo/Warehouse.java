package com.van.pojo;


public class Warehouse {

  private String ckId;
  private String ckName;
  private String ckSize;

  public Warehouse(String ckId, String ckName) {
    this.ckId = ckId;
    this.ckName = ckName;
  }

  public String getCkId() {
    return ckId;
  }

  public void setCkId(String ckId) {
    this.ckId = ckId;
  }


  public String getCkName() {
    return ckName;
  }

  public void setCkName(String ckName) {
    this.ckName = ckName;
  }


  public String getCkSize() {
    return ckSize;
  }

  public void setCkSize(String ckSize) {
    this.ckSize = ckSize;
  }

    public Warehouse(String ckId, String ckName, String ckSize) {
        this.ckId = ckId;
        this.ckName = ckName;
        this.ckSize = ckSize;
    }

    public Warehouse() {
    }
}
