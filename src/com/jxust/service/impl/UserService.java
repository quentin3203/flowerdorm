package com.jxust.service.impl;

import java.util.List;

import com.jxust.dao.IUserDAO;
import com.jxust.model.User;
import com.jxust.service.IUserService;

public class UserService implements IUserService {
	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(user);
	}

	@Override
	public boolean addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.addOrUpdateUser(user);
	}

	@Override
	public boolean guashiUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.guashiUser(id);
	}

	@Override
	public boolean jieguaUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.jieguaUser(id);
	}

	@Override
	public List getGuashi() {
		// TODO Auto-generated method stub
		return userDAO.getGuashi();
	}

}
