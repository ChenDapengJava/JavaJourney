package com.travler100.test.swaggerdemo.controller;

import com.travler100.test.swaggerdemo.common.CommonResult;
import com.travler100.test.swaggerdemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: swagger-demo
 * @description: 用户管理Controller
 * @author: 行百里者
 * @create: 2020/09/11 18:09
 **/
@RestController
@Api(tags = {"用户管理API"})
public class UserController {

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/user/listUsers", method = RequestMethod.GET)
    public CommonResult<List<User>> listUsers() {
        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setId(1L);
        u1.setUserName("张三");
        u1.setMobile("13888888888");
        u1.setAge(18);
        u1.setGender((byte) 1);

        User u2 = new User();
        u2.setId(2L);
        u2.setUserName("韩梅");
        u2.setMobile("13888888889");
        u2.setAge(20);
        u2.setGender((byte) 0);

        list.add(u1);
        list.add(u2);

        return CommonResult.success(list);
    }

    @ApiOperation(value = "根据手机号码获取用户信息")
    @RequestMapping(value = "/user/{mobile}", method = RequestMethod.GET)
    public CommonResult<User> user(@PathVariable("mobile") String mobile) {
        User u = new User();
        u.setId(new Random().nextLong()*1000);
        u.setUserName("张三");
        u.setMobile(mobile);
        u.setAge(18);
        u.setGender((byte) 1);
        return CommonResult.success(u);
    }
}

