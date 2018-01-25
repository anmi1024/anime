package com.anmi.anime.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by wangjue on 2017/9/14.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.daku")
public class DakuDataBaseConfig extends HikariConfig {
    @Bean("dakuDataSource")
    @Qualifier("dakuDataSource")
    @Primary
    public DataSource dataSource() throws SQLException {
        return new HikariDataSource(this);
    }
}
