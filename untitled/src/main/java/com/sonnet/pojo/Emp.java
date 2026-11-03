package com.sonnet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get set toString 方法都不需要自己写
@AllArgsConstructor // 定义所有带参数的构造函数
@NoArgsConstructor // 定义无参数的构造函数
public class Emp {

    private String username;

    private Integer age;
}
