package com.shop.cart.userDAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.Item;
import com.shop.cart.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean getUser(User theUser) {
		boolean isValid=false;
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User s where s.username='"+theUser.getUsername()+"' AND s.password='"+theUser.getPassword()+"'");
		List<User> theRsUser=theQuery.getResultList();
		for(User userRs: theRsUser){
			if(userRs.getUsername().equals(theUser.getUsername()) && userRs.getPassword().equals(theUser.getPassword())){
				isValid=true;
				System.out.println(userRs.getPassword());
			}
		}

		return isValid;	
	}


}
