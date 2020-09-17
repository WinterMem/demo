package com.pch.user.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.pch.user.util.SecurityUtils;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Component("auditorAware")
public class AuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityUtils.getAuthentication();
        if (authentication != null) {
            return Optional.of(SecurityUtils.getCurrentUsername());
        }
        return Optional.of("System");
    }
}
