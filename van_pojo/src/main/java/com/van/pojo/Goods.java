package com.van.pojo;


public class Goods {

  private String gId;
  private String gName;
  private String gKind;
  private String gWeight;

    public Goods(String gId, String gName, String gKind, String gWeight) {
        this.gId = gId;
        this.gName = gName;
        this.gKind = gKind;
        this.gWeight = gWeight;
    }

    public Goods() {
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgKind() {
        return gKind;
    }

    public void setgKind(String gKind) {
        this.gKind = gKind;
    }

    public String getgWeight() {
        return gWeight;
    }

    public void setgWeight(String gWeight) {
        this.gWeight = gWeight;
    }
}
