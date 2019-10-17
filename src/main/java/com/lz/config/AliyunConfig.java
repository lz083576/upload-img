package com.lz.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AliyunConfig {

    @Autowired
    protected Environment environment;

    @Value("${aliyun.verify.regionid}")
    private String regionid;
    @Value("${aliyun.verify.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.verify.accessKeySecret}")
    private String accessKeySecret;

    @Bean
    public IAcsClient client() throws Exception {
        IClientProfile profile = DefaultProfile.getProfile(regionid, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "afs", "afs.aliyuncs.com");
        return client;
    }

}
