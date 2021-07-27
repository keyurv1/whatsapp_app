package com.example.whatschatsapp;

public class User {
    private  String uid,name,email,profilrImg;

    public User(){

    }


    public User(String uid, String name, String email, String profilrImg) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.profilrImg = profilrImg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getProfilrImg() {
        return profilrImg;
    }

    public void setProfilrImg(String profilrImg) {
        this.profilrImg = profilrImg;
    }
}
