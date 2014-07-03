package com.exam;

import com.core.database.ConnectionPoolDataSource;
import com.core.database.JDBCAccess;
import com.core.database.JPAAccess;
import com.core.platform.DefaultAppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig extends DefaultAppConfig {

    @Inject
    Environment env;

    @Bean
    public DataSource dataSource() {
        ConnectionPoolDataSource dataSource = new ConnectionPoolDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        dataSource.setValidationQuery("select 1");
        dataSource.setDatabaseName(env.getRequiredProperty("jdbc.databaseName"));
        dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(AppConfig.class.getPackage().getName());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2008Dialect");
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public JPAAccess jpaAccess() {
        return new JPAAccess();
    }

    @Bean
    public JDBCAccess jdbcAccess() {
        JDBCAccess jdbcAccess = new JDBCAccess();
        jdbcAccess.setDataSource(dataSource());
        return jdbcAccess;
    }

}