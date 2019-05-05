package com.van.pojo;

import java.sql.Timestamp;

public class Store {

  private String sId;
  private Timestamp sTime;
  private Timestamp sOutime;
  private String sCount;
  private String sOutcount;
  private String stId;
  private String ckId;
  private String gId;

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

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Timestamp getsTime() {
        return sTime;
    }

    public void setsTime(Timestamp sTime) {
        this.sTime = sTime;
    }

    public Timestamp getsOutime() {
        return sOutime;
    }

    public void setsOutime(Timestamp sOutime) {
        this.sOutime = sOutime;
    }

    public String getsCount() {
        return sCount;
    }

    public void setsCount(String sCount) {
        this.sCount = sCount;
    }

    public String getsOutcount() {
        return sOutcount;
    }

    public void setsOutcount(String sOutcount) {
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

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    @Override
    public String toString() {
        return "Store{" +
                "sId='" + sId + '\'' +
                ", sTime=" + sTime +
                ", sOutime=" + sOutime +
                ", sCount='" + sCount + '\'' +
                ", sOutcount='" + sOutcount + '\'' +
                ", stId='" + stId + '\'' +
                ", ckId='" + ckId + '\'' +
                ", gId='" + gId + '\'' +
                '}';
    }
}
