package com.mockbean.mockbean.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;

//@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfig(Environment environment) {
        InetUtils inetUtils = new InetUtils(new InetUtilsProperties());
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        String ipAddress = inetUtils.findFirstNonLoopbackAddress().getHostAddress();
        config.setIpAddress(ipAddress);
        config.setPreferIpAddress(true);
        config.setNonSecurePort(Integer.parseInt(environment.getProperty("server.port", "8082")));
        config.setAppname(environment.getProperty("spring.application.name"));
        return config;
    }

}

