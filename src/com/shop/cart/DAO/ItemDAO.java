package com.shop.cart.DAO;

import java.util.List;

import com.shop.cart.model.Item;

public interface ItemDAO {

	public List<Item> getItems();

	public void saveItem(Item theItem);

	public Item getItem(int theId);

	public void deleteItem(int theId);
}
