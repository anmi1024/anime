package com.anmi.anime.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by wangjue on 2017/8/23.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.authorize")
public class AuthorizeDataBaseConfig extends HikariConfig{
    @Bean("authorizeDataSource")
    @Qualifier("authorizeDataSource")
    public DataSource dataSource() throws SQLException {
        return new HikariDataSource(this);
    }
}
