package com.pch.user.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Component("auditorAware")
public class AuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}
