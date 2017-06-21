package com.personal.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by josgar on 20/06/2017.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "customerservice")
public class CustomerServiceProperties {

    private long timeout;

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
