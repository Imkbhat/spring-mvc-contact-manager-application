package kiran.luv2code.contactapp.test;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FindSingleUserDAO {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User user = userDAO.findById(1);
		System.out.println("User Details: "+user.getName() +"=="+user.getLogin_name() +"=="+ user.getEmail() +"=="+ user.getPhone());
		System.out.println("Data By Find By Id.");
	}
}
