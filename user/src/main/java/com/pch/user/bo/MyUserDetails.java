package com.pch.user.bo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pch.user.po.UserPO;

/**
 * @Author: pch
 */
public class MyUserDetails implements UserDetails {

    private UserPO userPO;
    private List<RoleBo> roleBos;

    public MyUserDetails(UserPO userPO, List<RoleBo> roleBos) {
        this.userPO = userPO;
        this.roleBos = roleBos;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPO.getPassword();
    }

    @Override
    public String getUsername() {
        return userPO.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
