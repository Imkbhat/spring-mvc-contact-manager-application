package main.webapp.com.kiran.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.webapp.com.kiran.luv2code.dao.BaseDAO;
import main.webapp.com.kiran.luv2code.dao.ContactDAO;
import main.webapp.com.kiran.luv2code.domain.Contact;
import main.webapp.com.kiran.luv2code.rowmapper.ContactRowMapper;
import main.webapp.com.kiran.luv2code.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public void saveContact(Contact c) {
		contactDAO.save(c);
	}

	@Override
	public void updateContact(Contact c) {
		contactDAO.update(c);
	}

	@Override
	public void deleteContact(Integer contactId) {
		contactDAO.delete(contactId);
	}

	@Override
	public void deleteContact(Integer[] contactIds) {
		String ids = StringUtil.toCommaSeperatedString(contactIds);
		String sql = " DELETE FROM user_contact WHERE user_contact_id IN("+ids+") ";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("user_id", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String text) {
		String sql = " SELECT user_contact_id, user_id, name, phone, email, address, remark FROM user_contact "
				+ " WHERE user_id=? AND (name LIKE '%"+text+"%' OR address LIKE '%"+text+"%' OR phone LIKE '%"+text+"%' OR email LIKE '%"+text+"%' OR address LIKE '%"+text+"%' OR remark LIKE '%"+text+"%')";
		
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

	@Override
	public Contact findById(Integer contactId) {
		return contactDAO.findById(contactId);
	}
	
}
