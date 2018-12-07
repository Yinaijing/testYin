package com.winterchen.util;

import java.text.SimpleDateFormat;


public class UserInfo implements java.io.Serializable {

    private java.lang.Integer userId;
    private java.lang.String username;
    private java.util.Date birthDate;
    private java.lang.Integer age;

    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public UserInfo() {
    }

    public UserInfo(
            java.lang.Integer userId,
            java.lang.String username,
            java.util.Date birthDate,
            java.lang.Integer age
    ) {
        this.userId = userId;
        this.username = username;
        this.birthDate = birthDate;
        this.age = age;
    }

    public void setUserId(java.lang.Integer value) {
        this.userId = value;
    }

    public java.lang.Integer getUserId() {
        return this.userId;
    }

    public void setUsername(java.lang.String value) {
        this.username = value;
    }

    public java.lang.String getUsername() {
        return this.username;
    }

    public void setBirthDate(java.util.Date value) {
        this.birthDate = value;
    }

    public java.util.Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDatestr(String value) throws Exception {
        setBirthDate(formater.parse(value));
    }

    public java.lang.String getBirthDatestr() {
        return formater.format(getBirthDate());
    }

    public void setAge(java.lang.Integer value) {
        this.age = value;
    }

    public java.lang.Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append(getUserId())
                .append("; " + getUsername())
                .append("; " + getBirthDatestr())
                .append("; " + getAge())
                .toString();
    }
}
