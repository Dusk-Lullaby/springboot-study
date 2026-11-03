package com.sonnet.config;

import com.sonnet.pojo.ObjectB;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportConfig implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean flag = registry.containsBeanDefinition(ObjectB.class.getName());
        if (!flag) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ObjectB.class);
            // 执行注册操作 参数1 bean的名称 参数2 bean的定义信息
            registry.registerBeanDefinition("ObjectB", rootBeanDefinition);
        }
    }
}
