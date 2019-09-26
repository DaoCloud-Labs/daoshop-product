package io.daocloud.shop.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApiResult {
    private Integer code;
    private String message;
    private String data;
}
