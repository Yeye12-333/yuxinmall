package com.example.mallelectron.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Goods;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 *
 */
public interface GoodsService extends IService<Goods> {

    Page<Goods> findAllByPage(Page<Goods> page, Goods goods);
}
