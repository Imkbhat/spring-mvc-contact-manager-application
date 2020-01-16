package kiran.luv2code.contactapp.test;

import java.util.List;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FindAllUserDAO {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		List<User> user1 = userDAO.findAll();
		for(User user : user1) {
			System.out.println("User Details: "+user.getName() +"=="+user.getLogin_name() +"=="+ user.getEmail() +"=="+ user.getPhone());
		}
		System.out.println("Data By Find By All.");
	}
}
