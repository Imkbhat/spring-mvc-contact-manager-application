package main.webapp.com.kiran.luv2code.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.webapp.com.kiran.luv2code.domain.Contact;

import org.springframework.jdbc.core.RowMapper;


public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setUser_contact_id(rs.getInt("user_contact_id"));
		contact.setName(rs.getString("name"));
		contact.setAddress(rs.getString("address"));
		contact.setEmail(rs.getString("email"));
		contact.setPhone(rs.getString("phone"));
		contact.setRemark(rs.getString("remark"));
		contact.setUser_id(rs.getInt("user_id"));
		return contact;
	}

}
