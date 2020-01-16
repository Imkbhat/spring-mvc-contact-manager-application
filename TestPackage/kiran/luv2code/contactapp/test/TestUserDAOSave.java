package kiran.luv2code.contactapp.test;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOSave {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("Hanumanthaaaa");
		u.setPassword("Rama123");
		u.setPhone("78677666632");
		u.setEmail("ramahanuma@gmail.com");
		u.setAddress("Ayodhya");
		u.setLogin_name("Hanumantha");
		u.setLogin_status(1);//Active
		u.setRole(1);//Admin
		userDAO.save(u);
		System.out.println("Data Saved");
	}
}
