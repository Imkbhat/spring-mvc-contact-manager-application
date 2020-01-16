package main.webapp.com.kiran.luv2code.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.webapp.com.kiran.luv2code.domain.Contact;
import main.webapp.com.kiran.luv2code.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value={"/user/contact_form"})
	public String contactForm(Model m) {
		Contact cont = new Contact(); //Reusing contact domain class as command 
		m.addAttribute("contactCommand", cont);
		return "contact_form";//JSP
	}
	
	@RequestMapping(value={"/user/save_contact"})
	public String saveOrUpdateContact(@ModelAttribute("contactCommand") Contact contact, Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("aContactId");
		Integer userId = (Integer) session.getAttribute("userId");
		if(contactId == null) {
			//Save
			try {
				contact.setUser_id(userId);
				contactService.saveContact(contact);
				return "redirect:clist?act=sv";//redirecting to contact List
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("error", "Failed to save Contact");
				return "contact_form";
			}
		} else {
			//Update
			try {
				contact.setUser_contact_id(contactId);
				contact.setUser_id(userId);
				contactService.updateContact(contact);
				return "redirect:clist?act=ed";//redirecting to contact List
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("error", "Failed to Edit Contact");
				return "contact_form";
			}
		}
	}
	
	@RequestMapping(value={"/user/clist"})
	public String contactList(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		List<Contact> contactList = contactService.findUserContact(userId);
		m.addAttribute("contactList", contactList);
		return "clist";//JSP Page
	}
	
	@RequestMapping(value={"/user/del_contact"})
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		contactService.deleteContact(contactId);
		return "redirect:clist?act=del";//JSP Page
	}
	
	@RequestMapping(value={"/user/edit_contact"})
	public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
		session.setAttribute("aContactId", contactId);
		Contact c = contactService.findById(contactId);
		m.addAttribute("contactCommand",c);
		return "contact_form";//JSP PAGE
	}
}