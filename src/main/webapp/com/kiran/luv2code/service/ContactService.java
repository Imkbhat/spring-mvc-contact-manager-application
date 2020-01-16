package main.webapp.com.kiran.luv2code.service;

import java.util.List;

import main.webapp.com.kiran.luv2code.domain.Contact;

public interface ContactService {
	
	public void saveContact(Contact c);
	public void updateContact(Contact c);
	public void deleteContact(Integer contactId);
	public void deleteContact(Integer[] contactIds);
	public Contact findById(Integer contactId);
	
	/**
	 * This method returns all user contact(user who is logged in)
	 * @param userId
	 * @return
	 */
	
	public List<Contact> findUserContact(Integer userId);
	
	/**
	 * This method Search contact for user(userId) based on given free text criterion 
	 * @param userId //user who logged in
	 * @param text //criterion for free text search.
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId, String text);
}
