package com.seduc.appcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.servicies.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	
	@PostMapping
	public User insertUser(@RequestBody User user) {

		User insertedUser = userService.insertUser(user);
		return insertedUser;
	}
	
	@PostMapping(value = "arr")
	public List<User> insertUsers(@RequestBody List<User> users) {
		List<User> insertedUser = userService.insertUsers(users);
		return insertedUser;
	}
	
	@DeleteMapping(value = "/{id}")
	public void DeleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}	
	
	@PostMapping(value = "/auth")
	public User authUser(@RequestBody User user) {
		User userReturn = userService.authUser(user.getName(), user.getPassword());
		return  userReturn != null? userReturn: null ;
	}
	@PutMapping
	public User editUser(@RequestBody User user) {
		return userService.editUser(user);
	}
	        
	    
}
