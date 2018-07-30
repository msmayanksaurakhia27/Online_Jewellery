

package com.grocerybackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.grocerybackend")
@EnableTransactionManagement
public class DBconfig {
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/grocery");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
		
	}
	
	
	
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(dataSource);
		lsfb.addProperties(getHibernateProp());
		lsfb.scanPackages("com.grocerybackend");
		return lsfb.buildSessionFactory();
	}



	private Properties getHibernateProp() {
		Properties prop=new Properties();
		//Important Prop
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		//Optional Prop
		prop.put("hibernate.hbm2ddl.auto", "update");//update,create,create-drop,validate
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		//Optional Prop
		
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager getTM(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
