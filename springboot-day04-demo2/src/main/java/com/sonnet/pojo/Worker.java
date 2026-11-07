package com.sonnet.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
@ConfigurationProperties("person")
@Data
public class Worker implements Person{

    private Integer age;
    private String name;

}
