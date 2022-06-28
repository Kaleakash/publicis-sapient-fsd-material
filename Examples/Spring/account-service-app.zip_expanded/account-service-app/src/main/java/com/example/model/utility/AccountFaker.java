package com.example.model.utility;

import java.util.Arrays;
import java.util.List;

import com.example.model.Account;

public class AccountFaker {

	public static Account fetchFakeAccounts(int accountNumber) {
		List<Account> fakeAccounts = Arrays.asList(
				new Account(1234, 3000),
				new Account(2345, 6000),
				new Account(4567, 8000),
				new Account(5678, 4000)
				);
		// find the data using streams, return null if not found
		return fakeAccounts
				.stream()
				.filter(item -> item.getAccountNumber() == accountNumber)
				.findFirst().orElse(null);
	}
}
