package com.msoft.noteappapi.Security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class Authority implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 123456L;
    private final String authority;

    public Authority(String authority) {
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
