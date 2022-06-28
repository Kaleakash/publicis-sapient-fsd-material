package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Account;
import com.example.Wallet;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private RestTemplate rest;
	
	@GetMapping
	public String welcome() {
		String result = rest.getForObject("http://account-service/account", String.class);
		return "Wallet service got, "+result;
	}
	@GetMapping("/{number}")
	public Wallet amountThatCanBeSpent(@PathVariable("number") int number) {
		String url = "http://account-service/account/"+number;
		Account account = rest.getForObject(url, Account.class);
		Wallet wallet = new Wallet();
		wallet.setAccount(account);
		double amount = account.getBalance() + wallet.getWalletBalance();
		wallet.setMaxAmount(amount);
		return wallet;
	}
}
