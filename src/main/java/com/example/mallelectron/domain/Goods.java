package com.example.mallelectron.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName goods
 */
@Data
@TableName(value ="goods")
@ToString
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品图片
     */
    private String cover;


    private String code;


    /**
     * 添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    private Date createTime;

    /**
     * 是否删除 0 否 1 是
     */
    @TableLogic
    private Boolean isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}