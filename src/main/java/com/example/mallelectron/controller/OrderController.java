package com.example.mallelectron.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Order;
import com.example.mallelectron.param.OrderParam;
import com.example.mallelectron.service.OrderService;
import com.example.mallelectron.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;






/**
 * (Order)表控制层
 *
 * @author
 */
@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderService;


    @PostMapping("/findAll")
    public Result findAll(@RequestParam(value = "page", required = false) Integer pageNum,
                          @RequestParam(value = "limit", required = false) Integer pageSize,
                          OrderParam orderParam) {
        Page<Order> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        System.out.println(pageNum + pageSize);
        return Result.ok().data("item", orderService.findAllByPage(page, orderParam));
    }

    @GetMapping("/findOrderNo")
    public Result findByOrderNo(String orderNo){
        return Result.ok().data("data", orderService.findByOrder(orderNo));
    }

    @PutMapping("/del/{orderNo}")
    public Result delByOrderNo(@PathVariable String orderNo){
        return Result.auto(orderService.deleteByOrderNo(orderNo));
    }


}
