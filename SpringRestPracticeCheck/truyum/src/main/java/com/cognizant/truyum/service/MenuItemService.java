package com.cognizant.truyum.service;

import java.util.List;
//import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
	
				
	public List<MenuItem> getMenuItemListCustomer(){		
		LOGGER.info("Start");
		return menuItemDao.getMenuItemListCustomer();
		//return menuItemRepository.findAllCurrentActiveMenuItems();
	}
	
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		LOGGER.info("Start");		
		menuItemDao.modifyMenuItem(menuItem);
		//menuItemRepository.save(menuItem);
		LOGGER.info("End");		
	}
	
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException {
		LOGGER.info("Start");
		return menuItemDao.getMenuItem(id);
		//return menuItemRepository.getOne(menuItemId);
	}
}
