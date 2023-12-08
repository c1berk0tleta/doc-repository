package com.example.doc_repository;

public class user {
    int user_ID;
    String user_login;
    String user_password;
    int user_privilege;
            
    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_privilege() {
        return user_privilege;
    }

    public void setUser_privilege(int user_privilege) {
        this.user_privilege = user_privilege;
    }
    
    public user (int user_ID, String user_login, String user_password, int user_privilege) {
        this.user_ID = user_ID;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_privilege = user_privilege;
    }
}
