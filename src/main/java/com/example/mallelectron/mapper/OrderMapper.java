package com.example.mallelectron.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mallelectron.dto.OrderDto;
import com.example.mallelectron.param.OrderParam;

/**
 * @Entity com.example.mallelectron.domain.Order
 */
public interface OrderMapper extends BaseMapper<Order> {

    Page<OrderDto> getList(Page<Order> page, OrderParam orderParam);

    int deleteByOrderNo(String orderNo);

    OrderDto selectByOrder(String orderNo);
}




