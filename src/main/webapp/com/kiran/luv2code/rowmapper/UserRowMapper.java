package main.webapp.com.kiran.luv2code.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.webapp.com.kiran.luv2code.domain.User;

import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setUser_id(rs.getInt("user_id"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		user.setLogin_name(rs.getString("login_name"));
		user.setPhone(rs.getString("phone"));
		user.setRole(rs.getInt("role"));
		user.setLogin_status(rs.getInt("login_status"));
		return user;
	}

}
