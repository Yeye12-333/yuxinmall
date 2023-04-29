package com.example.mallelectron.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SecurityUser extends User {

    private final com.example.mallelectron.domain.Admin admin;

    public SecurityUser(com.example.mallelectron.domain.Admin admin, Collection<? extends GrantedAuthority> authorities) {
        super(admin.getUsername(), admin.getPassword(), authorities);
        this.admin = admin;
    }

}
