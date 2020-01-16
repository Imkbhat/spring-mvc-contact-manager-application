package main.webapp.com.kiran.luv2code.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//NOTE: do not use this in @Repository or @Service or @Component
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
	
	//setDataSource() method is final is jdbcdaosupport, 
	//hence we cannot use that method, hence created new method
	
	@Autowired
	public void setDataSource2(DataSource ds){ 
		super.setDataSource(ds);
	}
}
