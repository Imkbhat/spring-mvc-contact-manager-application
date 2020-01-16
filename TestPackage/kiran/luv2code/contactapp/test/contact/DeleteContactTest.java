package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteContactTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		dao.delete(1);
		
		System.out.println("Delete By Id Successfull.");
	}
}
