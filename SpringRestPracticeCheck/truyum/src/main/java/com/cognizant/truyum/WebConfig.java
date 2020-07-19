package com.cognizant.truyum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;

@Configuration
@ComponentScan(basePackages = "com.cognizant.truyum")
public class WebConfig {
	@Bean
	public MenuItemDao menuItemDao() {
		return new MenuItemDaoCollectionImpl(); 
	}
}