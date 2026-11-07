package com.sonnet.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
@ConfigurationProperties("person")
@Data
public class Boss implements Person{
    String name;
    Integer age;
}
