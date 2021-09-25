package com.ymt.thinking.in.spring.ioc.overview.depedency.lookup;

import com.ymt.thinking.in.spring.ioc.overview.annotation.Super;
import com.ymt.thinking.in.spring.ioc.overview.domain.SuperUser;
import com.ymt.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Dependency lookup by annotation demo
 *
 * @author yumingtao
 * @date 2021/9/25 19:22
 */
public class DependencyLookupByAnnotationDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupCollectionByAnnotation(beanFactory);
    }
    private static void lookupCollectionByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, Object> users =  ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);
            System.out.println("Lookup users by type:" + users);
        }
    }
}
