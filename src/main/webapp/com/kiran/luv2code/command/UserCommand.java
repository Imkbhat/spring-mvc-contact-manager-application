package main.webapp.com.kiran.luv2code.command;

import main.webapp.com.kiran.luv2code.domain.User;

public class UserCommand {
	User  user; //incorporated user in userCommand
	//TODO: add more fields if required.
	
	public UserCommand() {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
