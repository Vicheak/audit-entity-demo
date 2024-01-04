package com.vicheak.auditentitydemo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        log.info("Auth Name : {}", auth.getName());
//        log.info("Auth Principal : {}", auth.getPrincipal());
//        log.info("Auth Authorities : {}", auth.getAuthorities());

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return Optional.ofNullable(username);
    }

}
