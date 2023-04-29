package com.example.mallelectron.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Customer;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 *
 */
public interface CustomerService extends IService<Customer> {

    Page<Customer> findAllByPage(Page<Customer> page, Customer customer);
}
