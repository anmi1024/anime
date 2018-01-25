package com.anmi.anime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by wangjue on 2017/9/14.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryDaku",
        transactionManagerRef="transactionManagerDaku",
        basePackages= { "com.anmi.anime.repository.daku" })
public class DakuConfig {
    @Autowired @Qualifier("dakuDataSource")
    private DataSource dakuDataSource;

    @Primary
    @Bean(name = "entityManagerDaku")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryDaku(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryDaku")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDaku (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dakuDataSource)
                .properties(getVendorProperties(dakuDataSource))
                .packages("com.anmi.anime.model")
                .persistenceUnit("dakuPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerDaku")
    public PlatformTransactionManager transactionManagerDaku(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryDaku(builder).getObject());
    }

}
