package com.van.moudle;


import java.io.Serializable;

public class Student implements Serializable {

  private String stuId;
  private String stuName;
  private String stuPwd;
  private String stuAddress;

  public String getStuId() {
    return stuId;
  }

  public void setStuId(String stuId) {
    this.stuId = stuId;
  }


  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }


  public String getStuPwd() {
    return stuPwd;
  }

  public void setStuPwd(String stuPwd) {
    this.stuPwd = stuPwd;
  }


  public String getStuAddress() {
    return stuAddress;
  }

  public void setStuAddress(String stuAddress) {
    this.stuAddress = stuAddress;
  }

  public Student(String stuId, String stuName, String stuPwd, String stuAddress) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.stuPwd = stuPwd;
    this.stuAddress = stuAddress;
  }

  public Student() {
  }

  @Override
  public String toString() {
    return "Student{" +
            "stuId='" + stuId + '\'' +
            ", stuName='" + stuName + '\'' +
            ", stuPwd='" + stuPwd + '\'' +
            ", stuAddress='" + stuAddress + '\'' +
            '}';
  }
}
