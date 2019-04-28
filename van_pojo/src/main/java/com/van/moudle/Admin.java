package com.van.moudle;

public class Admin {
    private  String  adminId;
    private  String  adminPwd;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Admin(String adminId, String adminPwd) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }
}
