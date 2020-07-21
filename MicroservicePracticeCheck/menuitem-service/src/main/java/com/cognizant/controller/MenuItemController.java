package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.MenuItem;
import com.cognizant.repository.MenuItemRepository;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
@Autowired
private MenuItemRepository menuItemRepo;

@GetMapping
public List<MenuItem> getMenuItemListCustomer(){
	return (List<MenuItem>) menuItemRepo.findAll();
}
@GetMapping("/{id}")
public MenuItem getMenuItemById(@PathVariable Long id) {
	return menuItemRepo.findAllById(id);
}
@PutMapping
public MenuItem updateMenuItem(@RequestBody MenuItem menuItem) {
	return menuItemRepo.save(menuItem);
}

}
