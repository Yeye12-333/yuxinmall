package com.example.mallelectron.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Goods;
import com.example.mallelectron.service.GoodsService;
import com.example.mallelectron.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (Goods)表控制层
 *
 * @author
 */
@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private GoodsService goodsService;




    @PostMapping("/findAll")
    public Result findAll(@RequestParam(value = "page", required = false) Integer pageNum,
                          @RequestParam(value = "limit", required = false) Integer pageSize,
                          Goods goods) {
        Page<Goods> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return Result.ok().data("item", goodsService.findAllByPage(page, goods));
    }

    @PostMapping("/query/{id}")
    public Result findById(@PathVariable Integer id) {
        return Result.ok().data("model", goodsService.getById(id));
    }

    @PostMapping("/create")
    public Result insertModel(Goods goods) {
        System.out.println(goods);
        return Result.auto(goodsService.save(goods));
    }

    @PostMapping("/batch-create")
    public Result insertModel(@RequestBody List<Goods> goods) {
        System.out.println(goods);
        return Result.auto(goodsService.saveBatch(goods));
    }

    @GetMapping("/remove/{id}")
    public Result removeModel(@PathVariable Integer id) {
        return Result.auto(goodsService.removeById(id));
    }

    @PostMapping("/update")
    public Result updateModel(Goods goods) {
        return Result.auto(goodsService.updateById(goods));
    }

}
