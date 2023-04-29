package com.example.mallelectron.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Integer orderId;
    private String goodsName;
    private String goodsCover;
    private Double price;
    private Integer customerId;
    private String customerName;
    private String businessCode;
    private String orderNo;
    private Date createTime;
    private Integer quantity;
    private String alipayNo;
    private String status;

}
