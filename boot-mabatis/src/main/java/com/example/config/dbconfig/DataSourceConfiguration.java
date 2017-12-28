package com.example.config.dbconfig;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库源配置
 * @author Jfei
 *
 */
@Configuration
public class DataSourceConfiguration {

	private static Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
    
	/**
	 * 写库 数据源配置
	 * @return
	 */
	@Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource writeDataSource() {
        log.info("-------------------- writeDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }
	
	/**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource01")
    @ConfigurationProperties(prefix = "spring.datasource.read01")
    public DataSource readDataSourceOne() {
        log.info("-------------------- read01 DataSourceOne init ---------------------");
        return DataSourceBuilder.create().build();
    }

    
}
