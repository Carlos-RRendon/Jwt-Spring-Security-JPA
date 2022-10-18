package com.accolite.pru.health.AuthApp.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipentKey {

    @Autowired
    public RecipentKey() {
        try {
            this.recipientJWK = new RSAKeyGenerator(2048)
                    .keyID("456")
                    .keyUse(KeyUse.ENCRYPTION)
                    .generate();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
        this.recipientPublicJWK = recipientJWK.toPublicJWK();
    }

    private final RSAKey recipientJWK;
    private final RSAKey recipientPublicJWK;

    public RSAKey getRecipientJWK() {
        return recipientJWK;
    }

    public RSAKey getRecipientPublicJWK() {
        return recipientPublicJWK;
    }
}
