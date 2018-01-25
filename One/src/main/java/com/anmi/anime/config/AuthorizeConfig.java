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
        entityManagerFactoryRef="entityManagerFactoryAuthorize",
        transactionManagerRef="transactionManagerAuthorize",
        basePackages= { "com.anmi.anime.repository.authorize" }) //设置Repository所在位置
public class AuthorizeConfig {

    @Autowired @Qualifier("authorizeDataSource")
    private DataSource AuthorizeDataSource;


    @Bean(name = "entityManagerAuthorize")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryAuthorize(builder).getObject().createEntityManager();
    }


    @Bean(name = "entityManagerFactoryAuthorize")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAuthorize (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(AuthorizeDataSource)
                .properties(getVendorProperties(AuthorizeDataSource))
                .packages("com.anmi.anime.model") //设置实体类所在位置
                .persistenceUnit("authorizePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }


    @Bean(name = "transactionManagerAuthorize")
    public PlatformTransactionManager transactionManagerAuthorize(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryAuthorize(builder).getObject());
    }

}