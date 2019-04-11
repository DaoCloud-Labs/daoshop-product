package io.daocloud.shop.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Package io.daocloud.shop.product.entity
 * @Classname ProductEntity
 * @Description TODO
 * @Date 2019/3/14 下午6:41
 * @Created by chenghao
 * @desc ProductEntity
 * @project product
 */
@Data
@Entity
@Table(name = "t_product")
@ApiModel("商品信息")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id;

    @Column(name = "c_name")
    @ApiModelProperty("商品名称")
    private String name;

    @Column(name = "c_desc")
    @ApiModelProperty("商品描述")
    private String desc;

    @Column
    @ApiModelProperty("商品价格")
    private double price;

    @Column(name = "c_type")
    @ApiModelProperty("商品类型")
    private int type;
    @Column
    @ApiModelProperty("商品库存")
    private long stock;

    @Column
    @ApiModelProperty("商品已经出售的数量")
    private long sales;

    @Column(name = "image")
    @ApiModelProperty("商品图片")
    private String img;

}
