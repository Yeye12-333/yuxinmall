package com.example.mallelectron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallelectron.domain.Order;
import com.example.mallelectron.dto.OrderDto;
import com.example.mallelectron.param.OrderParam;
import com.example.mallelectron.service.OrderService;
import com.example.mallelectron.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Page<OrderDto> findAllByPage(Page<Order> page, OrderParam orderParam) {
        return baseMapper.getList(page, orderParam);
    }

    @Override
    public Boolean deleteByOrderNo(String orderNo) {
        int i = orderMapper.deleteByOrderNo(orderNo);
        return i != 1;
    }

    @Override
    public OrderDto findByOrder(String orderNo) {

        return orderMapper.selectByOrder(orderNo);
    }
}




