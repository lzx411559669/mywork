package com.bookstore.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {
    @NotEmpty(message = "名称不能为null")
    private String name;
    @Min(value = 18, message = "你的年龄必须大于等于18岁")
    @Max(value = 150, message = "你的年龄必须小于等于150岁")
    private int age;
    @NotBlank(message = "手机号不能为空或null")
    private String mobile;
    @Email(message = "邮箱不正确")
    @NotBlank(message = "请输入邮箱")
    private String email;
}
