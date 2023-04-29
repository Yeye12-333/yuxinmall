package com.example.mallelectron.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mallelectron.dto.OrderDto;
import com.example.mallelectron.param.OrderParam;

import java.util.Map;

/**
 *
 */
public interface OrderService extends IService<Order> {

    Page<OrderDto> findAllByPage(Page<Order> page, OrderParam orderParam);

    Boolean deleteByOrderNo(String orderNo);

    OrderDto findByOrder(String orderNo);
}
