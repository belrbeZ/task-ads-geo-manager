package com.keeper;

import com.keeper.config.JpaSpringConfig;
import com.keeper.service.hibernate.HibernateGenericService;
import com.keeper.service.jpa.JpaUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by AlexVasil on 26.03.2017.
 */


/**
 * Testing of JPA and Hibernate
 */

public class TestJpaDemoConfig {

    public static void main(String[] args) {

//        demoHibernateSpringXmlTransactionAnnotations();
//        demoJpaSpringJavaConfig();

    }

    public static void demoHibernateSpringXmlTransactionAnnotations() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-tx-annot.xml");
        HibernateGenericService productService = ctx.getBean(HibernateGenericService.class);
        productService.printItems();
    }

    public static void demoJpaSpringJavaConfig() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaSpringConfig.class);
        JpaUserService productService = ctx.getBean(JpaUserService.class);
        productService.printUsers();
    }
}
