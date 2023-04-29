package com.example.mallelectron.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallelectron.domain.Goods;
import com.example.mallelectron.service.GoodsService;
import com.example.mallelectron.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

    @Override
    public Page<Goods> findAllByPage(Page<Goods> page, Goods goods) {
        return baseMapper.selectPage(page, new QueryWrapper<>(goods));
    }
}




