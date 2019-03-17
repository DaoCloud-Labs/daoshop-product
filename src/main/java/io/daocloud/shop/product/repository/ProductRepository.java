package io.daocloud.shop.product.repository;

import io.daocloud.shop.product.entity.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Package io.daocloud.shop.product.repository
 * @Classname ProductRepository
 * @Description TODO
 * @Date 2019/3/14 下午7:12
 * @Created by chenghao
 * @desc ProductRepository
 * @project product
 */

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,Long> {
}
