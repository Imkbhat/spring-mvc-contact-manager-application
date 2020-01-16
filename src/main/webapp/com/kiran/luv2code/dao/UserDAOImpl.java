package main.webapp.com.kiran.luv2code.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.webapp.com.kiran.luv2code.domain.User;
import main.webapp.com.kiran.luv2code.rowmapper.UserRowMapper;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {
		String sql = "INSERT INTO user_main(name, phone, email, address, login_name, password, role, login_status) "+
				" VALUES(:name, :phone, :email, :address, :login_name, :password, :role, :login_status )";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", u.getName());
		params.put("phone", u.getPhone());
		params.put("email", u.getEmail());
		params.put("address", u.getAddress());
		params.put("login_name", u.getLogin_name());
		params.put("password", u.getPassword());
		params.put("role", u.getRole());
		params.put("login_status", u.getLogin_status());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(params);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh, new String[] { "user_id" }); 
		//here user_id used, because, in postgres sql it returns set of data, so be specific which is the Key
		
		Integer userId = kh.getKey().intValue();
		u.setUser_id(userId);
	}

	@Override
	public void update(User u) {
		String sql ="UPDATE user_main "
					+ "SET name=:name, "
					+ "phone=:phone, "
					+ "email=:email, "
					+ "address=:address, "
					+ "role=:role, "
					+ "login_status=:login_status "
					+ "WHERE user_id=:user_id ";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", u.getName());
		params.put("phone", u.getPhone());
		params.put("email", u.getEmail());
		params.put("address", u.getAddress());
		params.put("role", u.getRole());
		params.put("login_status", u.getLogin_status());
		params.put("user_id", u.getUser_id());
		
		getNamedParameterJdbcTemplate().update(sql, params);
		
		
	}

	@Override
	public void delete(User u) {
		this.delete(u.getUser_id());
	}

	@Override
	public void delete(Integer userId) {
		String sql = " DELETE FROM user_main WHERE user_id=? ";
		getJdbcTemplate().update(sql, userId);
	}

	@Override
	public User findById(Integer userId) {
		String sql = " SELECT user_id, name, phone, email, address, login_name, role, login_status "
				+ " FROM user_main WHERE user_id=? ";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		return user;
	}

	@Override
	public List<User> findAll() {
		String sql = " SELECT user_id, name, phone, email, address, login_name, role, login_status "
				+ " FROM user_main";
		List<User> userList = getJdbcTemplate().query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object propertyValue) {
		String sql = " SELECT user_id, name, phone, email, address, login_name, role, login_status "
				+ " FROM user_main WHERE "+propertyName+"=?";
		List<User> userList = getJdbcTemplate().query(sql, new UserRowMapper(), propertyValue);
		return userList;
	}

}
