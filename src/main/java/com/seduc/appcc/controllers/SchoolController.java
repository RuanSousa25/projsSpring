package com.seduc.appcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.School;
import com.seduc.appcc.servicies.CredeService;
import com.seduc.appcc.servicies.SchoolService;

@RestController
@RequestMapping(value = "/schools")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private CredeService credeService;
	
	@GetMapping
	public List<School> getCredeByUserId(@RequestHeader("Crede-Id") long id){
		List<School> result = credeService.getSchoolsByCredeId(id);
		result.sort((School a, School b)-> a.getName().compareTo(b.getName()));
		return result;
	}
	
	
	@PostMapping
	public School insertSchool(@RequestBody School school) {
		return schoolService.insertSchool(school);
	}
	
	@PostMapping(value = "arr")
	public List<School> insertSchools(@RequestBody List<School> schools){
		return schoolService.insertSchools(schools);
	}
	
	@PutMapping
	public School editSchool(@RequestBody School school) {
		return schoolService.editSchool(school);
	}
	
}
