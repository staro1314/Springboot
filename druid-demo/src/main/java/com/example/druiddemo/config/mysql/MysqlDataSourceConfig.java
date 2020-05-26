package com.example.druiddemo.config.mysql;

import com.example.druiddemo.config.DruidConnectPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: Staro
 * @date: 2020/5/22 10:04
 * @Description:
 */
@Slf4j
@Configuration
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE,sqlSessionTemplateRef = "sqlSessionTemplateMysql")
public class MysqlDataSourceConfig {
    static final String PACKAGE="com.example.druiddemo.dao.mysql";
    private static final String MAPPER_LOCATION="classpath:mapper/mysql/**/*.xml";

    private final DruidConnectPoolConfig config;

    @Value("${druid.datasource.url}")
    private String url;
    @Value("${druid.datasource.driverClassname}")
    private String driverClassName;
    @Value("${druid.datasource.username}")
    private String username;
    @Value("${druid.datasource.password}")
    private String password;

    @Autowired
    public MysqlDataSourceConfig(DruidConnectPoolConfig config) {
        this.config = config;
    }

    @Bean
    @Primary
    public DataSource dataSourceMysql(){
        return config.initDataSource(url,driverClassName,username,password);
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryMysql(DataSource dataSourceMysql) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceMysql);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplateMysql(SqlSessionFactory sqlSessionFactoryMysql){
        return new SqlSessionTemplate(sqlSessionFactoryMysql);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManagerMysql(DataSource dataSourceMysql){
        return new DataSourceTransactionManager(dataSourceMysql);
    }
}