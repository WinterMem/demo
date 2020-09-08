package com.pch.user.model.po;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author: pch
 */
public class MyUserDetails implements UserDetails {

    private static final long serialVersionUID = 5528182141133050123L;

    private UserPo userPO;

    private List<RolePo> rolePos;

    public MyUserDetails(UserPo userPO, List<RolePo> rolePos) {
        this.userPO = userPO;
        this.rolePos = rolePos;
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
