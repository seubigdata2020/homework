package com.zyb.crud.util;

import com.zyb.crud.entity.dto.DataResponse;
import com.zyb.crud.entity.enums.CodeEnum;

public class JsonUtils {

    /**
     * 构造统一响应json格式
     *
     * @param obj 
     * @return
     */
    public static DataResponse convertDataResponse(Object obj, CodeEnum codeEnum) {

        DataResponse dataResponse = new DataResponse();
        dataResponse.setData(obj);
        dataResponse.setCode(codeEnum.getCode());
        dataResponse.setMsg(codeEnum.getMsg());

        return dataResponse;

    }
}
