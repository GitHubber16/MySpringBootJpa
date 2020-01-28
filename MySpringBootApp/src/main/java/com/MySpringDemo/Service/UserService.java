package com.MySpringDemo.Service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MySpringDem0.Repository.UserRepository;
import com.MySpringDemo.Model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>(); 
		for(User user:userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}
	
	public User editUser(int id) {
		return userRepository.getOne(id);
	}
	public User findByUsernameAndPassword(String userName,String password) {
		return userRepository.findByUserNameAndPassword(userName, password);	
	}
	

}