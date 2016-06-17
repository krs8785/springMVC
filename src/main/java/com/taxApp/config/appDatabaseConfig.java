package com.taxApp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taxApp.model.appUser;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class appDatabaseConfig {

	@Bean
	public HikariDataSource dataSource() {
	   final HikariDataSource ds = new HikariDataSource();
	   ds.setMaximumPoolSize(100);
	   ds.setDriverClassName("oracle.jdbc.driver.OracleDriver"); 
	   ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE"); ;
	   ds.setUsername("krs8785");
	   ds.setPassword("taxapp");
	   return ds;
	}
	
	@Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }
	
	@Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setAnnotatedClasses(appUser.class);

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
	
}
