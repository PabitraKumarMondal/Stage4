package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotAddedInCartException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		cartDao.addCartItem(userId, menuItemId);
	}
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	public void deleteCartItem(String userId, long menuItemId) throws CartEmptyException, MenuItemNotAddedInCartException {
		cartDao.deleteCartItem(userId, menuItemId);
	}
}
