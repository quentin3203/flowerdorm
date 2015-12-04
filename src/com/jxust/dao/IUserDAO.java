package com.jxust.dao;

import java.util.List;

import com.jxust.model.User;

public interface IUserDAO {
	public User checkUser(User user);
	public boolean addOrUpdateUser(User user);
	public boolean guashiUser(int id);
	public boolean jieguaUser(int id);
	public List getGuashi();
}
