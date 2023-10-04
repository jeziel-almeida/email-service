package com.challenge.emailservice.infra.ses.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

public class MyAWSCredentialsProvider implements AWSCredentialsProvider {

    private String accessKeyId;
    private String secretAccessKey;

    public MyAWSCredentialsProvider(String accessKeyId, String secretAccessKey) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

    @Override
    public AWSCredentials getCredentials() {
        return new BasicAWSCredentials(accessKeyId, secretAccessKey);
    }

    @Override
    public void refresh() {
        //Atualizar credenciais AWS
    }
    
}
