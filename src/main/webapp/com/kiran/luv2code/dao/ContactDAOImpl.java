package main.webapp.com.kiran.luv2code.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import main.webapp.com.kiran.luv2code.domain.Contact;
import main.webapp.com.kiran.luv2code.rowmapper.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	@Override
	public void save(Contact c) {
		String query = " INSERT INTO user_contact(user_id, name, phone, email, address, remark) VALUES "+
				" (:user_id, :name, :phone, :email, :address, :remark )";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", c.getUser_id());
		map.put("name", c.getName());
		map.put("phone", c.getPhone());
		map.put("email", c.getEmail());
		map.put("address", c.getAddress());
		map.put("remark", c.getRemark());
		
		SqlParameterSource source = new MapSqlParameterSource(map);
		KeyHolder kh = new GeneratedKeyHolder();
		super.getNamedParameterJdbcTemplate().update(query,source,kh, new String[]{"user_contact_id"});
		int userContactId = kh.getKey().intValue();
		c.setUser_contact_id(userContactId);
	}

	@Override
	public void update(Contact c) {
		String query = " UPDATE user_contact "
				+ " SET user_id=:user_id, "
				+ " name=:name, "
				+ " phone=:phone,"
				+ " email=:email, "
				+ " address=:address, "
				+ " remark=:remark "
				+ " WHERE user_contact_id=:user_contact_id ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", c.getUser_id());
		map.put("name", c.getName());
		map.put("phone", c.getPhone());
		map.put("email", c.getEmail());
		map.put("address", c.getAddress());
		map.put("remark", c.getRemark());
		map.put("user_contact_id", c.getUser_contact_id());
		
		getNamedParameterJdbcTemplate().update(query, map);
	}

	@Override
	public void delete(Contact c) {
		this.delete(c.getUser_contact_id());
	}

	@Override
	public void delete(Integer contactId) {
		String sql = " DELETE FROM user_contact WHERE user_contact_id=? ";
		getJdbcTemplate().update(sql, contactId);
	}

	@Override
	public Contact findById(Integer contactId) {
		String sql = " SELECT user_contact_id, user_id, name, phone, email, address, remark "+
				" FROM user_contact WHERE user_contact_id=? ";
		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
	}

	@Override
	public List<Contact> findAll() {
		String sql = " SELECT user_contact_id, user_id, name, phone, email, address, remark FROM user_contact ";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	@Override
	public List<Contact> findByProperty(String propertyName,
			Object propertyValue) {
		String sql = " SELECT user_contact_id, user_id, name, phone, email, address, remark FROM user_contact "
				+ " WHERE "+propertyName+"=? ";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), propertyValue);
	}
}
