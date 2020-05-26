package com.example.druiddemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: Staro
 * @date: 2020/5/22 9:40
 * @Description:
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "default.druid")
public class DruidConnectPoolConfig {

    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private int minEvictableIdleTimeMillis;
    private int timeBetweenEvictionRunsMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;
    private String filters;
    private String connectionProperties;

    public DataSource initDataSource(String url, String driveClass, String username, String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driveClass);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            log.info("druidDataSource set filters fail");
        }
        druidDataSource.setConnectionProperties(connectionProperties);
        return druidDataSource;
    }
}
