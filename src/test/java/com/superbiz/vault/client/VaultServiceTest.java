package com.superbiz.vault.client;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VaultServiceTest {

    @Test
    public void shouldWriteAndReadFromVault() throws UnknownHostException, NoSuchAlgorithmException, UnsupportedEncodingException {
        VaultService client = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(VaultService.class, "http://localhost:8200");

        //Initialize Vault
        InitResponse init = client.init(new InitData(1, 1));
        assertThat(init.getKeys(), is(notNullValue()));
        assertThat(init.getRoot_token(), is(notNullValue()));

        //Unseal
        SealStatus sealStatus = client.unseal(new UnsealData(1, init.getKeys().get(0)));
        assertThat(sealStatus.isSealed(), is(false));

        //Enable AppId backend
        client.enableAuthBackend("appid", init.getRoot_token(), new EnableBackendData("app-id", ""));
        client.listEnabledAuthBackends(init.getRoot_token());

        //Generate an appid
        final String appId = UUID.randomUUID().toString();

        Map<String, Object> content = new HashMap<String, Object>();
        content.put("value", "root");
        content.put("display_name", "foo");
        client.write("auth/appid/map/app-id/"+appId, init.getRoot_token(), content);

        Map<String, Object> content2 = new HashMap<String, Object>();
        content2.put("value", appId);
        final String hostAddress = InetAddress.getLocalHost().getHostAddress();
        final byte[] digest = MessageDigest.getInstance("SHA-1").digest(hostAddress.getBytes("UTF-8"));
        String userId = Base64.encodeBase64URLSafeString(digest);
        client.write("auth/appid/map/user-id/"+userId, init.getRoot_token(), content2);

        System.out.println(client.login("appid", new AppIdLogin(appId, userId)));
    }


}
