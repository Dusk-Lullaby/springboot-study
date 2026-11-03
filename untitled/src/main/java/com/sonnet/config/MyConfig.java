package com.sonnet.config;

import com.sonnet.pojo.Animal;
import com.sonnet.pojo.Car;
import com.sonnet.pojo.Cat;
import com.sonnet.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = true) // 标识当前类是一个配置类 它的作用类似于spring中的xml配置文件
//@Import(value = {Animal.class, StudentConfig.class}) // 向容器中导入一个普通类的组件 bean的名称默认是类的权限定名
@Import(value = {MyImportSelector.class, ImportConfig.class})
@EnableConfigurationProperties(Car.class) // 开启对Car的属性配置功能，将Car放在IOC容器中
public class MyConfig {

    @Bean // 作用类似于 xml配置文件里面的bean标签，默认情况下bean的id就是方法的名称
    public User user() {
        User user = new User();
        user.setUsername("jiayi");
        user.setAge(18);
        user.setCat(cat());
        return user;
    }

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("jia");
        cat.setColor("红");
        return cat;
    }
}
