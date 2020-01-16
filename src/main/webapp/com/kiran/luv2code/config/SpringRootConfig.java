package main.webapp.com.kiran.luv2code.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages={"main.webapp.com.kiran"}) //original
@ComponentScan(basePackages={"main.webapp.com.kiran.luv2code.dao", "main.webapp.com.kiran.luv2code.service"}) //testing
public class SpringRootConfig {
	//TODO: Services, DAO, DataSource, Email Sender and some other layer beans
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.postgresql.Driver");
		bds.setUrl("jdbc:postgresql://localhost:5432/contact?currentSchema=contact");
		bds.setUsername("postgres");
		bds.setPassword("postgres");
		bds.setMaxTotal(2);
		bds.setInitialSize(1);
		bds.setTestOnBorrow(true);
		bds.setValidationQuery("SELECT 1");
		bds.setDefaultAutoCommit(true);
		return bds;
	}
	
	
	
}
