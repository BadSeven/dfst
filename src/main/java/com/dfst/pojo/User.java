package com.dfst.pojo;

import sun.dc.pr.PRError;

import java.util.Date;

/**
 * @author seven
 * @create 2018-05-06 14:20
 **/
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String phonenum;
    private Date createtime;

    public User(int id, String name, int age, String email, String password, String phonenum, Date createtime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phonenum = phonenum;
        this.createtime = createtime;
    }

    public User() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
