package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteByContactTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		c.setUser_contact_id(2);
		dao.delete(c);
		
		System.out.println("Delete By Contact Successfull.");
	}
}
