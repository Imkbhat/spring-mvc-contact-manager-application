package kiran.luv2code.contactapp.test;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOUpdate {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("Anjaneya");
		u.setPhone("78677666632");
		u.setEmail("anjaneya@gmail.com");
		u.setAddress("Ayodhya, U P");
		u.setLogin_status(1);//Active
		u.setRole(1);//Admin
		u.setUser_id(5);
		userDAO.update(u);
		System.out.println("Data Updated.");
	}
}
