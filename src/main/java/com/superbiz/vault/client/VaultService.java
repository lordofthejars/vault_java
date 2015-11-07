package com.superbiz.vault.client;


import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface VaultService {

    @RequestLine("PUT /v1/sys/init")
    InitResponse init(InitData initData);

    @RequestLine("PUT /v1/sys/unseal")
    SealStatus unseal(UnsealData unsealData);

    @RequestLine("POST /v1/sys/auth/{mount_point}")
    @Headers("X-Vault-Token: {token}")
    void enableAuthBackend(@Param("mount_point") String mountPoint, @Param("token") String token, EnableBackendData enableBackendData);

    @RequestLine("GET /v1/sys/auth")
    @Headers("X-Vault-Token: {token}")
    Map<String, Object> listEnabledAuthBackends(@Param("token") String token);

    @RequestLine("POST /v1/{key}")
    @Headers("X-Vault-Token: {token}")
    void write(@Param("key") String key, @Param("token") String token, Map<String, Object> data);

    @RequestLine("GET /v1/{key}")
    @Headers("X-Vault-Token: {token}")
    ReadKeyData read(@Param("key") String key, @Param("token") String token);

    @RequestLine("POST /v1/auth/{mount_point}/login")
    Map<String, Object> login(@Param("mount_point") String mountPoint, AppIdLogin appIdLogin);
}
