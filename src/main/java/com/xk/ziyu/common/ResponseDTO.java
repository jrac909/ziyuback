package com.xk.ziyu.common;

import lombok.Data;

@Data
public class ResponseDTO<Object> {
    private Integer code;
    private String message;
    private Integer total;
    private Object data;
}
