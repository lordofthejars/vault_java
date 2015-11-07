package com.superbiz.vault.client;

import java.util.List;

public class InitResponse {

    private List<String> keys;
    private String root_token;

    public InitResponse(String root_token, List<String> keys) {
        this.root_token = root_token;
        this.keys = keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public void setRoot_token(String root_token) {
        this.root_token = root_token;
    }

    public List<String> getKeys() {
        return keys;
    }

    public String getRoot_token() {
        return root_token;
    }
}
