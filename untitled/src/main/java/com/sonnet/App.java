package com.sonnet;

import com.sonnet.config.MyConfig;
import com.sonnet.pojo.Cat;
import com.sonnet.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        User user = context.getBean("user", User.class);
        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(user.getCat() == cat);

/*
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        MyConfig myConfig = context.getBean(MyConfig.class);
        User user1 = myConfig.user();
        User user2 = myConfig.user();
        System.out.println(user1 == user2);
*/

/*
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(user1);
        System.out.println(cat);
        System.out.println(user1 == user2);
*/
    }
}
