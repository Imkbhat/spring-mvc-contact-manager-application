package kiran.luv2code.contactapp.test;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;
import main.webapp.com.kiran.luv2code.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserServiceSave {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User u = new User();
		u.setName("Mangya");
		u.setPassword("Mangu123");
		u.setPhone("78677dsd666632");
		u.setEmail("rajahuli@gmail.com");
		u.setAddress("Bang");
		u.setLogin_name("Penga");
		u.setLogin_status(UserService.LOGIN_STATUS_ACTIVE);//Active
		u.setRole(UserService.ROLE_ADMIN);//Admin
		userService.registerUser(u);
		System.out.println("User Registration Successfull");
	}
}
