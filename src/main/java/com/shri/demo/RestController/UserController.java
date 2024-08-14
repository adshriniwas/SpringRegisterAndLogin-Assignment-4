package com.shri.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shri.demo.Model.SystemUser;
import com.shri.demo.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userlist")
	public List<SystemUser> getALLUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/register")
	public String createUser(@RequestBody SystemUser user) {
		return userService.createUser(user);
	}
	@PostMapping("/login")
	public String loginUser(@RequestBody SystemUser user) {
		return userService.login(user);
	}
}
