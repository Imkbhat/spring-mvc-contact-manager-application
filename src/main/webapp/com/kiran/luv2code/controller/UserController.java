package main.webapp.com.kiran.luv2code.controller;

import javax.servlet.http.HttpSession;

import main.webapp.com.kiran.luv2code.command.LoginCommand;
import main.webapp.com.kiran.luv2code.command.UserCommand;
import main.webapp.com.kiran.luv2code.domain.User;
import main.webapp.com.kiran.luv2code.exception.UserBlockedException;
import main.webapp.com.kiran.luv2code.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/", "/index"})
	public String index(Model m){
		m.addAttribute("loginCommand", new LoginCommand());
		return "index";//JSP page, resolved by /WEB-INF/jsp/index.jsp
	}
	
	@RequestMapping(value={"/user/dashboard"})
	public String userDashBoard(){
		return "dashboard_user";//JSP page, resolved by /WEB-INF/jsp/index.jsp
	}
	
	@RequestMapping(value={"/admin/dashboard"})
	public String adminDashBoard(){
		return "dashboard_admin";//JSP page, resolved by /WEB-INF/jsp/index.jsp
	}
	
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUser_id());
		session.setAttribute("roleId", u.getRole());
	}
	
	@RequestMapping(value={"/login"}, method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("loginCommand") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.loginUser(cmd.getLoginName(),cmd.getPassword());
			if(loggedInUser == null) {
				//Failed Part
				m.addAttribute("error", "Login Failed ! Enter Valid Credentials.");
				return "index";//Jsp-Login Form
			} else {
				//Success Part
				//Check the role and redirect to respective dashboard pages
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					addUserInSession(loggedInUser, session);//added user to session 
					return "redirect:admin/dashboard";
				} else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					addUserInSession(loggedInUser, session);//added user to session 
					return "redirect:user/dashboard";
				} else {
					//add error msg and back to login-form
					m.addAttribute("error", "InValid User Role.");
					return "index";//Jsp-Login Form
				}
			}
		} catch(UserBlockedException ex) {
			m.addAttribute("error", ex.getMessage());
			return "index";//Jsp-Login Form
		}
	}
	
	@RequestMapping(value={"/logout"})
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index?act=lo";//JSP page, resolved by /WEB-INF/jsp/index.jsp
	}
	
	@RequestMapping(value={"reg_form"})
	public String registrationForm(Model m) {
		//Using Command
		m.addAttribute("registerCommand", new UserCommand());
		return "reg_form";//JSP Page 
	}
	
	@RequestMapping(value={"register"})
	public String registerUser(@ModelAttribute("registerCommand") UserCommand command, Model m) {
		//Using Command
		try {
			User u = command.getUser();
			u.setRole(UserService.ROLE_USER);
			u.setLogin_status(UserService.LOGIN_STATUS_ACTIVE);
			userService.registerUser(u);
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {
			//exception thrown by spring handling is recommended, not the exception thrown by jdbc template 
			e.printStackTrace();
			m.addAttribute("error", "User is Name is Already Taken. Please select another User Name");
			return "redirect:reg_form";
		}
	}
}
