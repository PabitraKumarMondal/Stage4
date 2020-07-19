package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	//@ResponseBody
	@GetMapping("/accounts/{number}")
	public String getAccountDetails(@PathVariable String number) {
		return "number: \""+number+"\", type: \"savings\", balance: 234343";
	}
}
