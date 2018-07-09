package com.ljw.conf.database;

import java.util.Map;

import javax.sql.DataSource;

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

/**
 * 此类作用类似与建表配置（used for creat pojo table）
 * @author ljw
 *
 */
@Configuration
//@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMovie",
						transactionManagerRef = "transactionManagerMovie",
						basePackages = {"com.ljw.repository.movie"}
						)//设置dao（repo）所在位置
public class RepositoryMovieConfig {

	@Autowired
    private JpaProperties jpaProperties;
	
	@Autowired
    @Qualifier("datasourceMovie")
    private DataSource dataSource;
	
	
//	@Bean(name = "entityManagerMovie")
//	public EntityManager entityManager(EntityManagerFactoryBuilder builder){
//		return entityManagerFactory(builder)
//				.getObject()
//				.createEntityManager();
//		
//	}
	
	
	@Bean(name = "entityManagerFactoryMovie")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){
		
		return builder
				.dataSource(dataSource)
				.properties(getVendorProperties(dataSource))
				.packages("com.ljw.domain.movie")//实体类所在的包
				.persistenceUnit("moviePersistenceUnit")
				.build();
	}
	
	
	@Bean(name = "transactionManagerMovie")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
		
	}
	
	
	
	

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }
	
}
