package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotAddedInCartException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException;

	public void deleteCartItem(String userId, long menuItemId) throws CartEmptyException, MenuItemNotAddedInCartException;
}