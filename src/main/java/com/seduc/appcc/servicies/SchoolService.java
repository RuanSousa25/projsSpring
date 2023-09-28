package com.seduc.appcc.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seduc.appcc.entities.School;
import org.springframework.transaction.annotation.Transactional;

import com.seduc.appcc.repositories.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	SchoolRepository schoolRepository;
	
	
	@Transactional(readOnly = true)
	public List<School> findAll(){
		return schoolRepository.findAll();
	}

	
	@Transactional
	public School insertSchool(School school) {
		return schoolRepository.save(school);
	}
	@Transactional
	public List<School> insertSchools(List<School> school) {
		return schoolRepository.saveAll(school);
	}
	@Transactional
	public School editSchool(School school) {
		if(schoolRepository.findById(school.getId()).isPresent()) {
			School oldSchool = schoolRepository.findById(school.getId()).get();
			if(school.getName() != null && school.getName() != oldSchool.getName()) {
				oldSchool.setName(school.getName());
			}
			if(school.getReport() != null && !school.getReport().equals(oldSchool.getReport())) {
				oldSchool.setReports(school.getReport());
			}
			return schoolRepository.save(oldSchool);
		}
		return null;
	}
}
