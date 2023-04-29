package com.example.mallelectron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallelectron.domain.Admin;
import com.example.mallelectron.dto.SecurityUser;
import com.example.mallelectron.service.AdminService;
import com.example.mallelectron.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin user = new Admin();
        user.setUsername(s);
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>(user);
        Admin admin = adminService.getOne(queryWrapper);
        if (admin == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        return new SecurityUser(admin, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }


}
