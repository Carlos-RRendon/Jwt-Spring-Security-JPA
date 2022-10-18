package com.accolite.pru.health.AuthApp.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderKey {

    @Autowired
    public SenderKey() {

        try {
            this.senderJWK = new RSAKeyGenerator(2048)
                    .keyID("123")
                    .keyUse(KeyUse.SIGNATURE)
                    .generate();

            this.senderPublicJwk = senderJWK.toPublicJWK();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

    }

    private final RSAKey senderJWK;

    private final RSAKey senderPublicJwk;

    public RSAKey getSenderJWK() {
        return senderJWK;
    }

    public RSAKey getSenderPublicJwk(){
        return senderPublicJwk;
    }


}
