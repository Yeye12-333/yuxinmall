package com.example.mallelectron.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName orders
 */
@Data
@TableName(value ="`order`")
public class Order implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 支付宝交易号
     */
    private String alipayNo;

    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}