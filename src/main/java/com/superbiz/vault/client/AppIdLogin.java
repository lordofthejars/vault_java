package com.superbiz.vault.client;


public class AppIdLogin {

    private String app_id;
    private String user_id;

    public AppIdLogin(String app_id, String user_id) {
        this.app_id = app_id;
        this.user_id = user_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
