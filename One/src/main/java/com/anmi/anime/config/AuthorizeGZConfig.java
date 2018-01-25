package com.anmi.anime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryAuthorizeGZ",
        transactionManagerRef="transactionManagerAuthorizeGZ",
        basePackages= { "com.anmi.anime.repository.authorize_gz" }) //设置Repository所在位置
public class AuthorizeGZConfig {

    @Autowired @Qualifier("authorizeGZDataSource")
    private DataSource AuthorizeGZDataSource;

    @Bean(name = "entityManagerAuthorizeGZ")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryAuthorizeGZ(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryAuthorizeGZ")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAuthorizeGZ (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(AuthorizeGZDataSource)
                .properties(getVendorProperties(AuthorizeGZDataSource))
                .packages("com.anmi.anime.model") //设置实体类所在位置
                .persistenceUnit("authorizeGZPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerAuthorizeGZ")
    PlatformTransactionManager transactionManagerAuthorizeGZ(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryAuthorizeGZ(builder).getObject());
    }

}