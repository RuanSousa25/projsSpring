package com.seduc.appcc.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.School;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.repositories.CREDERepository;
import com.seduc.appcc.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CredeService {
	
	@Autowired
	CREDERepository credeRepository;
	
	@Transactional(readOnly = true)
	public List<Crede> findAll(){
		List<Crede> credes = credeRepository.findAll();
		return  credes;
	}
	
	
	@Transactional
	public Crede insertCrede(Crede crede) {
		
		credeRepository.save(crede);
		return crede;
		
	}
	
	@Transactional
	public List<School> getSchoolsByCredeId(Long id){
		if(credeRepository.findById(id).isEmpty()) return null;
		return credeRepository.findById(id).get().getEscolas();
	}
	
	@Transactional
	public List<Crede> insertCredes(List<Crede> crede) {
		
		credeRepository.saveAll(crede);
		return crede;
		
	}
	
	
	@Transactional
	public Crede editCrede(Crede crede) {
		
		if(credeRepository.findById(crede.getId()).isEmpty()) return null;
		
		Crede oldCrede = credeRepository.findById(crede.getId()).get();
		
		if(crede.getEscolas() != null && !crede.getEscolas().equals(oldCrede.getEscolas())){
			oldCrede.setEscolas(crede.getEscolas());
		}
		if(crede.getName() != null && !crede.getName().equals(oldCrede.getName())) {
			oldCrede.setName(crede.getName());
		}
		
		return oldCrede;
		
	}
	
	
	
	@Transactional
	public void deleteCrede(Long id) {
		credeRepository.deleteById(id);
	}
}
