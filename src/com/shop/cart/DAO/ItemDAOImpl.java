package com.shop.cart.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Item> theQuery = 
				currentSession.createQuery("from Item order", Item.class);
		
		List<Item> items = theQuery.getResultList();	
		return items;
	}

	@Override
	public void saveItem(Item theItem) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theItem);
	}

	@Override
	public Item getItem(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Item theItem = currentSession.get(Item.class, theId);
		return theItem;
	}

	@Override
	public void deleteItem(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Item where id=:itemId");
		theQuery.setParameter("itemId", theId);
		theQuery.executeUpdate();
	}
}
