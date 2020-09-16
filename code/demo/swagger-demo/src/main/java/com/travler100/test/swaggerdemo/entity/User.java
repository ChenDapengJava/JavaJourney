package com.travler100.test.swaggerdemo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: swagger-demo
 * @description: 用户实体类
 * @author: 行百里者
 * @create: 2020/09/11 18:38
 **/
@Data
public class User {
    @ApiModelProperty(value = "编号", name = "id", dataType = "Long", example = "302918")
    private Long id;
    @ApiModelProperty(value = "姓名", name = "userName", dataType = "String", example = "张三")
    private String userName;
    @ApiModelProperty(value = "手机号", name = "mobile", dataType = "String", example = "13888888888")
    private String mobile;
    @ApiModelProperty(value = "性别", name = "gender", dataType = "Byte", example = "1")
    private Byte gender;
    @ApiModelProperty(value = "年龄", name = "gender", dataType = "Integer", example = "18")
    private Integer age;
}
