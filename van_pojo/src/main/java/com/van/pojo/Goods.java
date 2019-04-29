package com.van.pojo;


public class Goods {

  private String gId;
  private String gName;
  private String gKind;
  private String gWeight;


  public String getGId() {
    return gId;
  }

  public void setGId(String gId) {
    this.gId = gId;
  }


  public String getGName() {
    return gName;
  }

  public void setGName(String gName) {
    this.gName = gName;
  }


  public String getGKind() {
    return gKind;
  }

  public void setGKind(String gKind) {
    this.gKind = gKind;
  }


  public String getGWeight() {
    return gWeight;
  }

  public void setGWeight(String gWeight) {
    this.gWeight = gWeight;
  }

    public Goods(String gId, String gName, String gKind, String gWeight) {
        this.gId = gId;
        this.gName = gName;
        this.gKind = gKind;
        this.gWeight = gWeight;
    }

    public Goods() {
    }
}
