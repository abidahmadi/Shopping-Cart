package com.shop.cart.service;

import java.util.List;

import com.shop.cart.model.Item;

public interface ItemService {


	public List<Item> getItems();
	
	public void saveItem(Item theItem);

	public Item getItems(int theId);

	public void deleteItem(int theId);
}
