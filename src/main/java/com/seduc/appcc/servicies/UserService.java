package com.seduc.appcc.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seduc.appcc.entities.Crede;
import com.seduc.appcc.entities.User;
import com.seduc.appcc.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		List<User> users = userRepository.findAll();
		
		return  users;
	}
	
	@Transactional
	public List<Crede> getCredeByUserId(long id){
		if(!userRepository.findById(id).isEmpty()) {
			return userRepository.findById(id).get().getCrede();
		}
		return null;
	}
	
	@Transactional
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public List<User> insertUsers(List<User> users) {
		return userRepository.saveAll(users);
	}
	
	@Transactional
	public User editUser(User user) {
		
		if(userRepository.findById(user.getId()).isPresent()) {
			User oldUser = userRepository.findById(user.getId()).get();
			if(user.getCrede() != null && !user.getCrede().equals(oldUser.getCrede())) {
				oldUser.setCrede(user.getCrede());
			}
			if(user.getEmail() != null && user.getEmail() != oldUser.getEmail()) {
				oldUser.setEmail(user.getEmail());
			}
			if(user.getName() != null && user.getName() != oldUser.getName()) {
				oldUser.setName(user.getName());
			}
			if(user.getPassword() != null && user.getPassword() != oldUser.getPassword()) {
				oldUser.setPassword(user.getPassword());
			}
			return userRepository.save(oldUser);
		};
		return null;
	}
	
	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User authUser(String username, String password) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			if(user.getName().equals(username) && user.getPassword().equals(password)) return user;
		}
		return null;
		
	}
	
}
