package com.example.mallelectron.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallelectron.domain.Admin;
import com.example.mallelectron.dto.SecurityUser;
import com.example.mallelectron.service.AdminService;
import com.example.mallelectron.mapper.AdminMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 *
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    @Override
    public SecurityUser getSecurityUser(Integer id) {
        Admin admin = baseMapper.selectById(id);
        return new SecurityUser(admin, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}




