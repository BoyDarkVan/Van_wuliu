package com.van.pojo;


public class Accept {

  private String cptId;
  private String cptName;
  private String cptSex;
  private String cptAddr;
  private String cptPhone;


  public String getCptId() {
    return cptId;
  }

  public void setCptId(String cptId) {
    this.cptId = cptId;
  }


  public String getCptName() {
    return cptName;
  }

  public void setCptName(String cptName) {
    this.cptName = cptName;
  }


  public String getCptSex() {
    return cptSex;
  }

  public void setCptSex(String cptSex) {
    this.cptSex = cptSex;
  }


  public String getCptAddr() {
    return cptAddr;
  }

  public void setCptAddr(String cptAddr) {
    this.cptAddr = cptAddr;
  }


  public String getCptPhone() {
    return cptPhone;
  }

  public void setCptPhone(String cptPhone) {
    this.cptPhone = cptPhone;
  }

    public Accept(String cptId, String cptName, String cptSex, String cptAddr, String cptPhone) {
        this.cptId = cptId;
        this.cptName = cptName;
        this.cptSex = cptSex;
        this.cptAddr = cptAddr;
        this.cptPhone = cptPhone;
    }

    public Accept() {
    }
}
