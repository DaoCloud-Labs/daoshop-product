package io.daocloud.shop.product.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package io.daocloud.shop.product.controller
 * @Classname OrderVo
 * @Description TODO
 * @Date 2019/3/19 下午4:22
 * @Created by chenghao
 * @desc OrderVo
 * @project product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo {

    private int count;
    private double price;
    private long productId;
    private String productName;
}
