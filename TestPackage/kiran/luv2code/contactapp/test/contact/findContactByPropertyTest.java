package kiran.luv2code.contactapp.test.contact;

import java.util.List;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class findContactByPropertyTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		List<Contact> contacts = dao.findByProperty("phone", "987");
		for(Contact c : contacts) {
			System.out.println(c.getName() +"======="+c.getPhone());
		}
	
		System.out.println("Fecthed Contact By Property Successfull.");
	}
}
