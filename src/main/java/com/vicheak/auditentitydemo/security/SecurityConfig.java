package com.vicheak.auditentitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.vicheak.auditentitydemo.security.AuthorityBase.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManagerConfig() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails adminUser = User.withUsername("admin")
                .password("{noop}admin@123")
                //.roles("ADMIN")
                .authorities(RoleBase.ADMIN.getAuthorities())
                .build();

        UserDetails staffUser = User.withUsername("staff")
                .password("{noop}staff@123")
                //.roles("STAFF")
                .authorities(RoleBase.STAFF.getAuthorities())
                .build();

        manager.createUser(adminUser);
        manager.createUser(staffUser);

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChainConfig(HttpSecurity http) throws Exception {

        //implement role-based authorization

        http.authorizeHttpRequests(auth -> {
            //auth.requestMatchers("/bars/**").hasRole("ADMIN");

            //implement authority-based authorization
            auth.requestMatchers(HttpMethod.GET, "/bars/**").hasAuthority(BAR_READ.getDescription());
            auth.requestMatchers(HttpMethod.POST, "/bars/**").hasAuthority(BAR_WRITE.getDescription());
            auth.requestMatchers(HttpMethod.PUT, "/bars/**").hasAuthority(BAR_UPDATE.getDescription());
            auth.requestMatchers(HttpMethod.DELETE, "/bars/**").hasAuthority(BAR_DELETE.getDescription());

            auth.requestMatchers(HttpMethod.GET, "/foos/**").hasAuthority(FOO_READ.getDescription());
            auth.requestMatchers(HttpMethod.POST, "/foos/**").hasAuthority(FOO_WRITE.getDescription());
            auth.requestMatchers(HttpMethod.PUT, "/foos/**").hasAuthority(FOO_UPDATE.getDescription());
            auth.requestMatchers(HttpMethod.DELETE, "/foos/**").hasAuthority(FOO_DELETE.getDescription());

            auth.anyRequest().authenticated();
        });

        http.formLogin(AbstractHttpConfigurer::disable);

        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
