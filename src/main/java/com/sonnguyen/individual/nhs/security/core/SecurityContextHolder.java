package com.sonnguyen.individual.nhs.security.core;

import com.sonnguyen.individual.nhs.exception.AuthenticationException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

@SessionScoped
public class SecurityContextHolder implements Serializable {
    private UserDetail principal;

    @Inject
    private UserDetailService userDetailService;
    @Inject
    private PasswordEncoder passwordEncoder;
    public UserDetail getPrincipal() {
        return principal;
    }
    public void setPrincipal(UserDetail userDetail) {
        this.principal = userDetail;
    }
    public UserDetail authenticate(String username,String password) throws AuthenticationException{
        UserDetail userdetail=userDetailService.findByUsername(username).orElseThrow(()->new AuthenticationException("Username not found"));
        if(!passwordEncoder.matches(password,userdetail.getPassword())) throw new AuthenticationException("Wrong password");
        return userdetail;
    }

}
