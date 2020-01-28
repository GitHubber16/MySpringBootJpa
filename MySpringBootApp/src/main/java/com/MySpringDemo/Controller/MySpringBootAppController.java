package com.MySpringDemo.Controller;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MySpringDemo.Model.User;
import com.MySpringDemo.Service.UserService;


@Controller
public class MySpringBootAppController {
	/*
	@ResponseBody
	@RequestMapping("/home")
	public String Hello() {
		return "Hello from Spring";
	}
	*/
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String Registration(HttpServletRequest request) {
		request.setAttribute("mode","MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String RegisterUser(@ModelAttribute("User") User user,BindingResult bindingResult,HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/show-users")
	public String ShowUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String DeleteUser(@RequestParam int id,HttpServletRequest request)
	{
		userService.deleteUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String EditUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user",userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}

	@RequestMapping("/login")
	public String Login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String LoginUser(@ModelAttribute User user,HttpServletRequest request) {
		if (userService.findByUsernameAndPassword(user.getUserName(),user.getPassword())!=null) {
			return "homepage";
		}else {
			request.setAttribute("error", "Invalid UserName or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
			
		
	}
	
}	


