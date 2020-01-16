package kiran.luv2code.contactapp.test.contact;

import java.util.List;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class findAllContactTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		List<Contact> conts = dao.findAll();
		
		for(Contact c: conts) {
			System.out.println("Name:"+c.getName());
			System.out.println("Phone:"+c.getPhone());
		}
		
		System.out.println("Fecthed All Contact Successfull.");
	}
}
