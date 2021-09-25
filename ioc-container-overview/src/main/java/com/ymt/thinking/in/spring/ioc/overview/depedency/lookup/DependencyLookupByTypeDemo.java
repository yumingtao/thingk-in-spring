package com.ymt.thinking.in.spring.ioc.overview.depedency.lookup;

import com.ymt.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Dependency lookup by type demo
 *
 * @author yumingtao
 * @date 2021/9/25 19:22
 */
public class DependencyLookupByTypeDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("Lookup by type:" + user);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("Lookup users by type:" + users);
        }
    }
}
