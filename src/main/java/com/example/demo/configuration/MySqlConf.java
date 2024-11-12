package com.example.demo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource(
        value = "classpath:application.properties",
        encoding = "UTF-8"
)
@EnableJpaRepositories(
        basePackages = {"com.example.demo.repository"},
        entityManagerFactoryRef = "confEntityManagerFactory",
        transactionManagerRef = "confTransactionManager"
)
@ComponentScan(basePackages = {"com.example.demo"})
public class MySqlConf {

    @Autowired
    private Environment environment;

    public MySqlConf(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public PlatformTransactionManager confTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(confEntityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean confEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.example.demo.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaProperties(additionalProperties());
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public static PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/chranchbydb");
        ds.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        ds.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        return ds;
    }

    private Properties additionalProperties(){
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return prop;
    }

    @Bean
    public ImplicitNamingStrategy implicitNamingStrategy() {
        return new SpringImplicitNamingStrategy();
    }

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl();
    }

}
