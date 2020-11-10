package com.wei1.work.crm.domain;

public class People {
    int userId;
    String userName;
    String password;
    char sex;
    String email;

    public People(int userId, String userName, String password, char sex, String emaill) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = emaill;
    }

    public People() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmaill() {
        return email;
    }

    public void setEmaill(String emaill) {
        this.email = emaill;
    }

    @Override
    public String toString() {
        return "People{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", emaill='" + email + '\'' +
                '}';
    }

}
