package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class findContactByIdTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		Contact contact = dao.findById(3);
	
		System.out.println(contact.getName() +"======="+contact.getPhone());
		System.out.println("Fecthed Contact Successfull.");
	}
}
