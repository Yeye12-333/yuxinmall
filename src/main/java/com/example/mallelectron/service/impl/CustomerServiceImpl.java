package com.example.mallelectron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallelectron.domain.Customer;
import com.example.mallelectron.service.CustomerService;
import com.example.mallelectron.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
    implements CustomerService{

    @Override
    public Page<Customer> findAllByPage(Page<Customer> page, Customer customer) {
        return baseMapper.selectPage(page, new QueryWrapper<>(customer));
    }
}




