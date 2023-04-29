package com.example.mallelectron.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallelectron.domain.Customer;
import com.example.mallelectron.domain.Goods;
import com.example.mallelectron.service.CustomerService;
import com.example.mallelectron.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (Customer)表控制层
 *
 * @author
 */
@CrossOrigin
@RestController
@RequestMapping("customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Autowired
    private CustomerService customerService;


    @PostMapping("/findAll")
    public Result findAll(@RequestParam(value = "page", required = false) Integer pageNum,
                          @RequestParam(value = "limit", required = false) Integer pageSize,
                          Customer customer) {
        Page<Customer> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return Result.ok().data("item", customerService.findAllByPage(page, customer));
    }

    @PostMapping("/query/{id}")
    public Result findById(@PathVariable Integer id) {
        return Result.ok().data("model", customerService.getById(id));
    }

    @PostMapping("/create")
    public Result insertModel(Customer customer) {
        return Result.auto(customerService.save(customer));
    }

    @PostMapping("/batch-create")
    public Result insertModel(@RequestBody List<Customer> customer) {
        System.out.println(customer);
        return Result.auto(customerService.saveBatch(customer));
    }


    @GetMapping("/remove/{id}")
    public Result removeModel(@PathVariable Integer id) {
        return Result.auto(customerService.removeById(id));
    }

    @PostMapping("/update")
    public Result updateModel(Customer customer) {
        return Result.auto(customerService.updateById(customer));
    }

}
