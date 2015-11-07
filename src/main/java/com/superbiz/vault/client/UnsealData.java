package com.superbiz.vault.client;

public class UnsealData {

    private int secret_shares;
    private String key;

    public UnsealData(int secret_shares, String key) {
        this.secret_shares = secret_shares;
        this.key = key;
    }

    public void setSecret_shares(int secret_shares) {
        this.secret_shares = secret_shares;
    }

    public int getSecret_shares() {
        return secret_shares;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
