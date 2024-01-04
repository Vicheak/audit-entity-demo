package com.vicheak.auditentitydemo.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthorityBase {

    BAR_READ("brand:read"),
    BAR_WRITE("brand:write"),
    BAR_UPDATE("brand:update"),
    BAR_DELETE("brand:delete"),
    FOO_READ("foo:read"),
    FOO_WRITE("foo:write"),
    FOO_UPDATE("foo:update"),
    FOO_DELETE("foo:delete");

    private final String description;

}
