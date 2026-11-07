package com.sonnet.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user") // 绑定指定的数据表
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
