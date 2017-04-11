package com.keeper.config;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.OpenJpaDialect;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by AlexVasil on 26.03.2017.
 *
 * @author AlexVasil
 *
 */

//@Configuration
//@EnableTransactionManagement
//@EntityScan(basePackages = "com.keeper.entity.dao")
//@EnableJpaRepositories(basePackages =  {"com.keeper.repo"})
//@PropertySource(value = {"classpath:jdbc.properties"})
public class JpaSpringDataConfig {
    private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driverClassName";
    private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DB_URL = "db.url";
    private static final String PROPERTY_NAME_DB_USER = "db.username";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

//    /**
//     * Creates and configures the HikariCP datasource bean.
//     * @param env   The runtime environment of  our application.
//     * @return
//     */
//    @Bean(destroyMethod = "close")
//    DataSource dataSource(Environment env) {
//        HikariConfig dataSourceConfig = new HikariConfig();
//        dataSourceConfig.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
//        dataSourceConfig.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
//        dataSourceConfig.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
//        dataSourceConfig.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
//
//        return new HikariDataSource(dataSourceConfig);
//    }

    /**
     * Creates the bean that creates the JPA entity manager factory.
     * @param dataSource    The datasource that provides the database connections.
     * @param env           The runtime environment of  our application.
     * @return
     */
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.keeper.entity.dao");

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));

        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        //If the value of this property is true, Hibernate will use prettyprint
        //when it writes SQL to the console.
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    /**
     * Creates the jdbc template bean that we use to invoke SQL queries via JDBC.
     * @param dataSource    The datasource that provides the database connection.
     * @return
     */
    @Bean
    NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * Creates the transaction manager bean that integrates the used JPA provider with the
     * Spring transaction mechanism.
     * @param entityManagerFactory  The used JPA entity manager factory.
     * @return
     */
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

//
//    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driverClassName";
//    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";
//    protected static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";
//    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
//
//    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
//    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
//    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
//    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
//    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//
//    private static final String PROPERTY_PACKAGES_TO_SCAN = "com.keeper.entity";
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(JpaSpringDataConfig.class);

    @Resource
    private Environment environment;


//    /* FIRST WORKING VERSION *//*
///*    @Bean(destroyMethod = "close")
//    public ComboPooledDataSource myDataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//
//        dataSource.setDriverClass(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
//        dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
//        dataSource.setUser(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
//        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
//
//        return dataSource;
//    }*/
//
//    @Bean(destroyMethod = "close")
//    public EntityManagerFactory myEmf(@Qualifier("dataSource") DataSource dataSource) {
////        logger.info("Loading Entity Manager...");
//
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPackagesToScan(PROPERTY_PACKAGES_TO_SCAN);
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//        jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
//        jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
//        jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//        jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
//
//        factoryBean.setJpaProperties(jpaProperties);
//        factoryBean.afterPropertiesSet();
//
//        return factoryBean.getObject();
//    }
//
//
//    @Bean
//    public JpaTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
////        logger.info("Loading Transaction Manager...");
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
////    @Primary
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        try {
//            entityManagerFactoryBean.setDataSource(myDataSource());
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setPackagesToScan(PROPERTY_PACKAGES_TO_SCAN);
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
//        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
//        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
//        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }

    @Bean
    public PersistenceExceptionTranslator persistenceExceptionTranslator() {
        return new OpenJpaDialect();
    }

//    @Bean
////    @Primary
//    public HibernateExceptionTranslator hibernateExceptionTranslator(){
//        return new HibernateExceptionTranslator();
//    }


//    /* SECOND NOT WORKING
//     * from https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition
//     */
//    @Bean
//    public DataSource dataSource() {
//
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.keeper");
//        factory.setDataSource(dataSource());
//        return factory;
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory((EntityManagerFactory) entityManagerFactory());
//        return txManager;
//    }



//    /* THIRD VARIANT NOT WORKING
//    *  from https://blog.openshift.com/postgresql-polyglot-persistence-part-3/
//    */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource());
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
//        hibernateJpaVendorAdapter.setGenerateDdl(true);
//        hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean(environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL)));
//        entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
//        return entityManagerFactory;
//    }
//
//    @Bean(destroyMethod = "close")
//    @Primary
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
//        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
//        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USER));
//        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
//        dataSource.setTestOnBorrow(true);
//        dataSource.setTestOnReturn(true);
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
//        dataSource.setNumTestsPerEvictionRun(3);
//        dataSource.setMinEvictableIdleTimeMillis(1800000);
//        dataSource.setValidationQuery("SELECT version()");
//
//        return dataSource;
//    }
}