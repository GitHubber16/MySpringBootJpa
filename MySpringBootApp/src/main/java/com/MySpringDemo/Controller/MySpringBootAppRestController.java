package com.MySpringDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MySpringDemo.Model.User;
import com.MySpringDemo.Service.UserService;

@RestController
public class MySpringBootAppRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String hello() {
		return "This is the homepage";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String userName,@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age,@RequestParam String password) {
		User user =new User(userName,firstName,lastName,age,password);
		userService.saveMyUser(user);
		return "User Saved";
	}
}
