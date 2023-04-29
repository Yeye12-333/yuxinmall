package com.example.mallelectron.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.mallelectron.domain.Customer;
import com.example.mallelectron.domain.Goods;
import com.example.mallelectron.domain.Order;
import com.example.mallelectron.service.CustomerService;
import com.example.mallelectron.service.GoodsService;
import com.example.mallelectron.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@EnableScheduling
@Component
public class StaticTaskSchedule implements ApplicationRunner {

    @Lazy
    @Autowired
    private GoodsService goodsService;
    @Lazy
    @Autowired
    private CustomerService customerService;
    @Lazy
    @Autowired
    private OrderService orderService;

    private List<Goods> goodsList;
    private List<Customer> customerList;


    @Scheduled(cron = "0 15 0 ? * *")
    public void loadData() {
        goodsList = goodsService.list();
        customerList = customerService.list();
    }

    @Scheduled(fixedDelay = 5000)
    public void execute() {
        int c = RandomUtil.randomInt(0, 10);
        if (c > 7){
            Goods goods = goodsList.get((RandomUtil.randomInt(goodsList.size())));
            Customer customer = customerList.get((RandomUtil.randomInt(customerList.size())));
            Order order = new Order();
            order.setGoodsId(goods.getId());
            order.setCustomerId(customer.getId());
            order.setOrderNo(System.currentTimeMillis() + RandomUtil.randomNumbers(6));
            order.setAlipayNo(DateUtil.format(new Date(), "yyyyMMdd") + RandomUtil.randomNumbers("22001155191433074020".length()));
            order.setQuantity(RandomUtil.randomInt(1, 5));
            order.setStatus(RandomUtil.randomInt(2, 5));
            orderService.save(order);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        goodsList = goodsService.list();
        customerList = customerService.list();
    }
}
