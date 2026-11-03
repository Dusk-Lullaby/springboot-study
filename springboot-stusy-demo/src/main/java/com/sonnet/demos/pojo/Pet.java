package com.sonnet.demos.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "person.pet")
public class Pet {
    private String name;
    private Double weight;
}