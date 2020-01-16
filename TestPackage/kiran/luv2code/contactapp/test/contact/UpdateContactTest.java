package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UpdateContactTest {
	
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		c.setAddress("Theerthahalli");
		c.setEmail("Bhatt");
		c.setName("K B");
		c.setPhone("17787");
		c.setRemark("Vande Mataram");
		c.setUser_id(1);
		c.setUser_contact_id(1);
		
		dao.update(c);
		
		System.out.println("Updated Successfully.");
		
	}

}
