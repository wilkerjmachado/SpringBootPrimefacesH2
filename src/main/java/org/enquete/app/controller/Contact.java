package org.enquete.app.controller;

import java.io.Serializable;

public class Contact implements Serializable{
	 
	private static final long serialVersionUID = 8912402061008299129L;
	
	private String firstname;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private Integer age;
    private String gender;
 
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getSurname() {
        return surname;
    }
 
    public void setSurname(String surname) {
        this.surname = surname;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
     
    public String getAddress() {
        return address;
    }
     
    public void setAddress(String address) {
        this.address = address;
    }
}
