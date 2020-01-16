package kiran.luv2code.contactapp.test;

import javax.sql.DataSource;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "INSERT INTO user_main(name, phone, email, address, login_name, password) VALUES(?,?,?,?,?,?)";
		Object[] params = new Object[]{"Bhatt","97404444382","123d90@gmgai.com","Karnataka","b","b123"};
		jt.update(sql,params);
		System.out.println("Executed");
	}
}
