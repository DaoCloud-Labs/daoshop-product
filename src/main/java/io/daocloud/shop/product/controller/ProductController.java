package io.daocloud.shop.product.controller;

import io.daocloud.shop.product.entity.ProductEntity;
import io.daocloud.shop.product.repository.ProductRepository;
import io.daocloud.shop.product.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Package io.daocloud.shop.product
 * @Classname ProductController
 * @Description TODO
 * @Date 2019/3/14 下午7:05
 * @Created by chenghao
 * @desc ProductController
 * @project product
 */
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final OrderService orderService;

    public ProductController(ProductRepository productRepository,
                             @SuppressWarnings("all")OrderService orderService) {
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public Iterable<ProductEntity> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductEntity findById(@PathVariable("id") long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no such product"));
    }
    @PostMapping("/products/buy")
    @Transactional
    public void buProduct(@RequestBody List<OrderVo> orderVoList,@RequestHeader("token") long token){
        orderVoList.forEach(orderVo->{
            ProductEntity productEntity = productRepository.findById(orderVo.getProductId()).get();
            orderVo.setPrice(productEntity.getPrice());
            orderVo.setProductName(productEntity.getName());
            updateProductCount(orderVo.getCount(),productEntity);
        });
        orderService.createOrder(orderVoList,token);
    }

    private synchronized void  updateProductCount(int count,ProductEntity productEntity){
        productEntity.setStock(productEntity.getStock()-count);
        productEntity.setSales(productEntity.getSales()+count);
        productRepository.save(productEntity);
    }
}
