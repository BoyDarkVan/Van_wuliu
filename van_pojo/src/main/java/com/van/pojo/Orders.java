package com.van.pojo;


public class Orders {

  private String orderId;
  private String orderName;
  private String orderPrice;
  private String userId;
  private String aptId;
  private String stId;
  private String gId;


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }


  public String getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(String orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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


  public String getGId() {
    return gId;
  }

  public void setGId(String gId) {
    this.gId = gId;
  }

    public Orders(String orderId, String orderName, String orderPrice, String userId, String aptId, String stId, String gId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.aptId = aptId;
        this.stId = stId;
        this.gId = gId;
    }

    public Orders() {
    }
}
