package com.seduc.appcc.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.Report;
import com.seduc.appcc.entities.School;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.repositories.ReportRepository;
import com.seduc.appcc.repositories.SchoolRepository;
import com.seduc.appcc.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	
	@Transactional(readOnly = true)
	public List<Report> findAll(){
		List<Report> reports = reportRepository.findAll();
		
		return  reports;
	}
	
	
	@Transactional
	public School insertReport( Report report, Long id) {
		if(schoolRepository.findById(id).isEmpty()) return null;
		School school = schoolRepository.findById(id).get();
		List<Report> aReports = school.getReport();
		aReports.add(report);
		school.setReports(aReports);
		reportRepository.save(report);
		return schoolRepository.save(school);
	}
	
	
	@Transactional
	public void deleteReport(Long id) {
		reportRepository.deleteById(id);
	}
}
