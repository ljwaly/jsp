package com.ljw.conf.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 此类作用是创建数据库（This class used for creating datasource）
 * 需要将创建表的url、username、password、driverClassName在配置文件中进行声明
 * 
 * 
 * 多数据源--内存数据库h2配置的数据源
 * 
 * @author PC
 *
 */

@Configuration
public class DataSourcePeopleConfig {

	
	@Bean(name = "datasourcePeople")
	@Primary
	@ConfigurationProperties(prefix = "people.datasource")//配置文件中，数据库信息的前缀
	public DataSource buildDataSource(){
		
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean(name = "peopleJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("datasourcePeople") DataSource dsMySQL) {
        return new JdbcTemplate(dsMySQL);
    }
}
