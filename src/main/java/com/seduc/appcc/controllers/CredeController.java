package com.seduc.appcc.controllers;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.servicies.CredeService;
import com.seduc.appcc.servicies.UserService;

@RestController
@RequestMapping(value = "/credes")
public class CredeController {
	@Autowired
	private CredeService credesService;
	@Autowired
	private UserService userService;
	
	@PostMapping
	public Crede insertCrede(@RequestBody Crede crede) {
		return credesService.insertCrede(crede);
	}
	@PostMapping(value = "arr")
	public List<Crede> insertCredes(@RequestBody List<Crede> crede) {
		return credesService.insertCredes(crede);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteCrede(@PathVariable Long id) {
		credesService.deleteCrede(id);
	}
	
	@GetMapping
	public List<Crede> getCredeByUserId(@RequestHeader("User-Id") long id){
		List<Crede> result = userService.getCredeByUserId(id);
		result.sort((Crede a, Crede b)-> a.getName().compareTo(b.getName()));
		return result;
	}
	
	@PutMapping
	public Crede editCrede(@RequestBody Crede crede) {
		return credesService.editCrede(crede);
	}
	
	
}
