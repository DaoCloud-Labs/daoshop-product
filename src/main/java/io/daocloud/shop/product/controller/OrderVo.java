package io.daocloud.shop.product.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("购买商品信息")
public class OrderVo {

    @ApiModelProperty("商品数量")
    private int count;
    @ApiModelProperty("商品价格")
    private double price;
    @ApiModelProperty("商品id")
    private long productId;
    @ApiModelProperty("商品名称")
    private String productName;
}
