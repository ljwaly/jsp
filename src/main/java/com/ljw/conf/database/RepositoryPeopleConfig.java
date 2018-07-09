package com.ljw.conf.database;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

/**
 * 此类作用类似与建表配置（used for creat pojo table）
 * 
 * @author ljw
 *
 */

@Configuration
//@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPeople", transactionManagerRef = "transactionManagerPeople", 
							basePackages = {"com.ljw.repository.people" }) // 设置dao（repo）所在位置
public class RepositoryPeopleConfig {

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	@Qualifier("datasourcePeople")
	private DataSource dataSource;

	
	@Bean(name = "entityManagerPeople")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder)
				.getObject()
				.createEntityManager();
	}
	
	@Bean(name = "entityManagerFactoryPeople")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {

		return builder
				.dataSource(dataSource)
				.properties(getVendorProperties(dataSource))
				.packages("com.ljw.domain.people")//实体类所在的位置
				.persistenceUnit("peoplePersistenceUnit")
				.build();
	}

	@Bean(name = "transactionManagerPeople")
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());

	}

	

	
	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}
}
