package main.webapp.com.kiran.luv2code.dao;

import java.util.List;

import main.webapp.com.kiran.luv2code.domain.Contact;
import main.webapp.com.kiran.luv2code.domain.User;

public interface ContactDAO {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactId);
	public Contact findById(Integer contactId);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propertyName, Object propertyValue);
}
