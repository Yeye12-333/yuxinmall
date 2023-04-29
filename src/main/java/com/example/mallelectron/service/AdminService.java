package com.example.mallelectron.service;

import com.example.mallelectron.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mallelectron.dto.SecurityUser;

/**
 *
 */
public interface AdminService extends IService<Admin> {

    SecurityUser getSecurityUser(Integer id);

}
