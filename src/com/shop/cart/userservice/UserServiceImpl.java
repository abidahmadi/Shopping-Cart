package com.shop.cart.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.model.User;
import com.shop.cart.userDAO.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public boolean isUserValid(User theUser) {
		return userDAO.getUser(theUser);
	}

}
