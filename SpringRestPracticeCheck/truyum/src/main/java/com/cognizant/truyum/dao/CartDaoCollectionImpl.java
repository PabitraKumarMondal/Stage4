package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotAddedInCartException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			cart.getMenuItemList().add(menuItem);
			cart.setTotal(cart.getTotal() + menuItem.getPrice());
			//userCarts.put(userId, cart);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		if (userCarts.containsKey(userId)) {
			return userCarts.get(userId).getMenuItemList();
		} else {
			throw (new CartEmptyException());
		}

	}

	@Override
	public void deleteCartItem(String userId, long menuItemId) throws CartEmptyException, MenuItemNotAddedInCartException {
		if (userCarts.containsKey(userId)) {		
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			for (int i = 0; i < menuItemList.size(); i++) {
				if (menuItemList.get(i).getId() == menuItemId) {
					menuItemList.remove(i);
					return;
				}
			}
			throw new MenuItemNotAddedInCartException();
		}
		throw new CartEmptyException();
	}
}
