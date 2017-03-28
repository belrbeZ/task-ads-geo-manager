package com.keeper.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by AlexVasil on 26.03.2017.
 */

@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"com.keeper.config.*"})
@PropertySource(value = { "classpath:jdbc.properties" })
public class JpaSpringConfig {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource myDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    @Bean(destroyMethod = "close")
    public EntityManagerFactory myEmf(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.keeper.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        jpaProperties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }


    @Bean
    public JpaTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}