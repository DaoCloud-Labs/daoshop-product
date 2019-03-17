package io.daocloud.shop.product.entity;

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
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_desc")
    private String desc;

    @Column
    private double price;

    @Column(name = "c_type")
    private int type;
    @Column
    private long stock;

    @Column
    private long sales;

    @Column(name = "image")
    private String img;

}
