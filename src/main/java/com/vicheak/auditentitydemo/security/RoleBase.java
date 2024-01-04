package com.vicheak.auditentitydemo.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.vicheak.auditentitydemo.security.AuthorityBase.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleBase {

    ADMIN(Set.of(BAR_READ, BAR_WRITE, BAR_UPDATE, BAR_DELETE, FOO_READ, FOO_WRITE, FOO_UPDATE, FOO_DELETE)),
    STAFF(Set.of(BAR_READ, BAR_WRITE, BAR_UPDATE, FOO_READ, FOO_WRITE, FOO_UPDATE));

    private final Set<AuthorityBase> authorities;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> grantedAuthorities = this.authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getDescription()))
                .collect(Collectors.toSet());

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return grantedAuthorities;
    }

}
