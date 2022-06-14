package com;

public class TestApp {
	public static void main(String[] args) {
		
		// List<User> list = new ArrayList<>();
		// list.add(user1);
		// list.add(user2);
		
		User user = new User();
		user.setName("James");
		user.setAge(35);
		
		// assuming the UI wants to display the name & age
		
		System.out.println("Name = "+user.getName());
		System.out.println("Age = "+user.getAge());
	}
}
