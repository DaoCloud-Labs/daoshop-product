package io.daocloud.shop.product;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2Doc
public class ProductApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
