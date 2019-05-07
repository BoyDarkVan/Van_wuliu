package com.van.pojo;


public class Orders {

    private String orderId;
    private String orderName;
    private String orderPrice;
    private Users users;
    private Accept accept;
    private Staff staff;
    private Goods goods;

    public Orders(String orderId, String orderName, String orderPrice, Users users, Accept accept, Staff staff, Goods goods) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.users = users;
        this.accept = accept;
        this.staff = staff;
        this.goods = goods;
    }

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }


    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", users=" + users +
                ", accept=" + accept +
                ", staff=" + staff +
                ", goods=" + goods +
                '}';
    }
}
