package com.sonnet.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "car") // 批量进行属性绑定

public class Car {
    @Value("${car.name}")
    private String name;
    @Value("${car.price}")
    private String price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
