package io.daocloud.shop.product.service;

import io.daocloud.shop.product.controller.OrderVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Package io.daocloud.shop.product.service
 * @Classname OrderService
 * @Description TODO
 * @Date 2019/3/19 下午5:08
 * @Created by chenghao
 * @desc OrderService
 * @project product
 */

@FeignClient("daoshop-tenant03-daoshop-order")
@RequestMapping("/order/v1")
public interface OrderService {

    @PostMapping("/orders")
    public void createOrder(@RequestBody List<OrderVo> orderVolist, @RequestHeader("token") long token);
}
