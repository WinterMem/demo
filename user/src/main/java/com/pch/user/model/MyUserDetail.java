package com.pch.user.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pch.user.model.dto.UserDTO;

import lombok.AllArgsConstructor;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@AllArgsConstructor
public class MyUserDetail implements UserDetails {

    private static final long serialVersionUID = 2752154068012264471L;

    private final UserDTO userDTO;

//    private final List<MenuDTO> menuDTOS;

    private final List<GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDTO.getLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userDTO.getEnable();
    }
}
