package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;
	
	
	public MenuItemDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (ArrayList<MenuItem>) context.getBean("menuItems");
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				return;
			}
		}
		throw new MenuItemNotFoundException();
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws MenuItemNotFoundException {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		if(menuItem == null)
			throw new MenuItemNotFoundException();
		return menuItem;
	}
		
}
