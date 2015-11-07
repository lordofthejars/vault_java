package com.superbiz.vault.client;


public class SealStatus {

    private boolean sealed;
    private int t;
    private int n;
    private int progress;

    public SealStatus(boolean sealed, int t, int n, int progress) {
        this.sealed = sealed;
        this.t = t;
        this.n = n;
        this.progress = progress;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }

    public boolean isSealed() {
        return sealed;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}
