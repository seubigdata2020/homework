package com.zyb.crud.entity.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DataResponse {

    private Integer code;

    private String msg;

    private Object data;
}
