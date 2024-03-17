package com.ssi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.ssi")
@EnableWebMvc
public class ProjectConfig {
	
	public JavaMailSenderImpl mailSender()
	{
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
       jms.setHost("smtp.gmail.com");
       jms.setPort(587);
       jms.setUsername("ssiedu123@gmail.com");
       jms.setPassword("Ssiindore@123");

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        
        jms.setJavaMailProperties(properties);
        return jms;
	}
	
	//multipart bean for uploading a file
	@Bean
	public  CommonsMultipartResolver multipartResolver() {
		
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1500000);
		return resolver;
	}

	//SessionFactory Bean
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.ssi"); // Specify package(s) to scan for entity classes
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;

	}

	//Mysql
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
		dataSource.setUser("root");
		dataSource.setPassword("root");

		return dataSource;

	}
	
	//view Resolver
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

}
