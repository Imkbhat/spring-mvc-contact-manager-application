package main.webapp.com.kiran.luv2code.service;

import java.util.List;

import main.webapp.com.kiran.luv2code.domain.User;
import main.webapp.com.kiran.luv2code.exception.UserBlockedException;

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	
	/**
	 * Method handles User Registration Task, takes User as Object 
	 * @param u
	 */
	
	public void registerUser(User u);
	
	/**	
	 * This Method handle login operation(Authentication) using given credentials
	 * it returns user Object when Success else null
	 * @param loginName
	 * @param password
	 * @return User
	 * @throws UserBlockedException //When user account is blocked. 1.When user Account is blocked and Exception will be thrown
	 */
	
	public User loginUser(String loginName, String password) throws UserBlockedException ;
	
	/**
	 * Provide list of all registered users
	 */
	
	public List<User> getUsersList();
	
	/**
	 * This Method change the User Login Status for details passed as argument
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
	/**This method is used to check User Availibility.
	 * 
	 * @param userName
	 * @return
	 */
	public Boolean isUserNameExists(String userName);
}