package com.ymt.thinking.in.spring.ioc.overview.depedency.injection;

import com.ymt.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dependency lookup by name demo
 *
 * @author yumingtao
 * @date 2021/9/25 19:22
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println(userRepository.getUsers());

        //dependency injection
        System.out.println(userRepository.getBeanFactory());
        //System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println("userObjectFactory : " + userObjectFactory.getObject());

        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println("objectFactory : " + objectFactory.getObject());
        System.out.println("objectFactory == beanFactory : " + (objectFactory.getObject() == beanFactory));

        //dependency lookup
        //(error)
        //System.out.println(beanFactory.getBean(BeanFactory.class));

    }
}
