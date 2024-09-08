package com.link1nk.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link1nk.workshopmongo.domain.User;
import com.link1nk.workshopmongo.repository.UserRepository;
import com.link1nk.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		if (userRepository.findById(id).isPresent()) {
			return userRepository.findById(id).get();
		}
				 
		throw new ObjectNotFoundException("Objeto nao encontrado");
	}
}
