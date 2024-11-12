package com.example.t2303e_wcd.entity;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String telephone;
    private Integer class_id;
    private String subject;

    public Student(Integer id, String name, String email, String address, String telephone, Integer class_id, String subject) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.class_id = class_id;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}
}
