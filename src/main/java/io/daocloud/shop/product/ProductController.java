package io.daocloud.shop.product;

import io.daocloud.shop.product.entity.ProductEntity;
import io.daocloud.shop.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

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

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    @PostMapping("/products/{id}/buy")
    public void buProduct(@PathVariable("id") long id,
                          @RequestParam("count")int count){

    }
}
