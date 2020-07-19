package com.cognizant.truyum.dao;

import java.util.List;
//import java.util.Set;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	
	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException;

	public MenuItem getMenuItem(long menuItemId) throws MenuItemNotFoundException;
}
