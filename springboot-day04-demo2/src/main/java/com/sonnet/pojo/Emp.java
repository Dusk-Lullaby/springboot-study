package com.sonnet.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Emp {

    private String name;

    private Integer age;
}
