package com.superbiz.vault.client;


import java.util.Map;

public class ReadKeyData {

    private String lease_id;
    private boolean renewable;
    private long lease_duration;
    private Map<String, Object> data;

    public ReadKeyData(String lease_id, boolean renewable, long lease_duration, Map<String, Object> data) {
        this.lease_id = lease_id;
        this.renewable = renewable;
        this.lease_duration = lease_duration;
        this.data = data;
    }

    public String getLease_id() {
        return lease_id;
    }

    public void setLease_id(String lease_id) {
        this.lease_id = lease_id;
    }

    public boolean isRenewable() {
        return renewable;
    }

    public void setRenewable(boolean renewable) {
        this.renewable = renewable;
    }

    public long getLease_duration() {
        return lease_duration;
    }

    public void setLease_duration(long lease_duration) {
        this.lease_duration = lease_duration;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
