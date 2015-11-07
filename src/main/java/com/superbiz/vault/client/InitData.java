package com.superbiz.vault.client;


public class InitData {

    private int secret_shares;
    private int secret_threshold;

    public InitData(int secret_shares, int secret_threshold) {
        this.secret_shares = secret_shares;
        this.secret_threshold = secret_threshold;
    }

    public int getSecret_shares() {
        return secret_shares;
    }

    public void setSecret_shares(int secret_shares) {
        this.secret_shares = secret_shares;
    }

    public int getSecret_threshold() {
        return secret_threshold;
    }

    public void setSecret_threshold(int secret_threshold) {
        this.secret_threshold = secret_threshold;
    }
}
