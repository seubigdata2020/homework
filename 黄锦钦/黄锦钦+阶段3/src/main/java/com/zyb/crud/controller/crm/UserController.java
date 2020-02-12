package com.zyb.crud.controller.crm;


import com.zyb.crud.entity.crm.User;
import com.zyb.crud.entity.dto.DataResponse;
import com.zyb.crud.entity.enums.CodeEnum;
import com.zyb.crud.mapper.crm.UserMapper;
import com.zyb.crud.util.JsonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author ZhangYuBiao
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "查询用户信息")
    @GetMapping("/selectUser")
    @ResponseBody
    public DataResponse selectUser() {
        List<User> users = userMapper.selectList(null);
        return JsonUtils.convertDataResponse(users, CodeEnum.SUCCESS);
    }


}
