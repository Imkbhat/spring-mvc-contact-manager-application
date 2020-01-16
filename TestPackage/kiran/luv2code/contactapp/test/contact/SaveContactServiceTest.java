package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;
import main.webapp.com.kiran.luv2code.service.ContactService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SaveContactServiceTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService service = ctx.getBean(ContactService.class);
		Contact c = new Contact();
		c.setName("Kiran Bhatt");
		c.setAddress("Shimoga -Theerthahalli");
		c.setEmail("kbs-bhat");
		c.setPhone("987-098");
		c.setRemark("ATB-WATVB");
		c.setUser_id(1);
		service.saveContact(c);
		
		System.out.println("Data Saved from UserService Successfully.");
	}
}
