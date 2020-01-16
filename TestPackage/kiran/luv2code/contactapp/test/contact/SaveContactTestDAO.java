package kiran.luv2code.contactapp.test.contact;

import main.webapp.com.kiran.luv2code.config.SpringRootConfig;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SaveContactTestDAO {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO dao = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		c.setName("Kiran");
		c.setAddress("Shimoga");
		c.setEmail("kbs");
		c.setPhone("987");
		c.setRemark("ATB");
		c.setUser_id(1);
		dao.save(c);
		
		System.out.println("Data Saved Successfully.");
	}
}
