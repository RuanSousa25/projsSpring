package com.seduc.appcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seduc.appcc.bodies.ReportBody;
import com.seduc.appcc.entities.Report;
import com.seduc.appcc.entities.School;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.servicies.ReportService;
import com.seduc.appcc.servicies.UserService;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public List<Report> findAll(){
		return reportService.findAll();
	}
	
	@PostMapping
	public School insertReport(@RequestBody ReportBody reportBody) {
		School newSchool = reportService.insertReport(reportBody.getReport(), reportBody.getSchoolId());
		return newSchool;
	}
	
	@DeleteMapping(value = "/{id}")
	public void DeleteUser(@PathVariable Long id) {
		reportService.deleteReport(id);
	}


	
	
}
