package com.supinfo.courses.interfaces;

import javax.ejb.Remote;

import com.supinfo.courses.entity.User;

@Remote
public interface IUserDAO {
	public void createUser(User user);
	
	public User getUser(String username, String password);
}
