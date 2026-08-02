package com.login_system.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public String PREFIX;

    public String KEY;

    public Long EXPIRATION;

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public Long getEXPIRATION() {
        return EXPIRATION;
    }

    public void setEXPIRATION(Long EXPIRATION) {
        this.EXPIRATION = EXPIRATION;
    }

}
