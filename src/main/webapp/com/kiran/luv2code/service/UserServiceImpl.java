package main.webapp.com.kiran.luv2code.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.webapp.com.kiran.luv2code.dao.BaseDAO;
import main.webapp.com.kiran.luv2code.dao.UserDAO;
import main.webapp.com.kiran.luv2code.domain.User;
import main.webapp.com.kiran.luv2code.exception.UserBlockedException;
import main.webapp.com.kiran.luv2code.rowmapper.UserRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void registerUser(User u) {
		userDAO.save(u);
	}

	@Override
	public User loginUser(String loginName, String password)
			throws UserBlockedException {
		String query = " SELECT user_id, name, phone, email, address, role, login_status, login_name "+
					   " FROM user_main WHERE login_name=:ln AND password=:pw ";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
			if(u.getLogin_status().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your account has been Blocked. Contact to admin.");
			} else {
				return u;
			}
		} catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public List<User> getUsersList() {
		return userDAO.findByProperty("role", ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String sql = " UPDATE user_main set login_status=:lst WHERE user_id=:uid ";
		
		Map m = new HashMap();
		m.put("lst", loginStatus);
		m.put("uid", userId);
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public Boolean isUserNameExists(String userName) {
		String sql = " SELECT count(login_name) FROM user_main WHERE login_name=?";
		Integer count = getJdbcTemplate().queryForObject(sql, new String[]{userName}, Integer.class);
		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}
}
