package com.link1nk.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link1nk.workshopmongo.domain.User;
import com.link1nk.workshopmongo.dto.UserDTO;
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
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
		
	}
	
	private void updateData(User newUser, User user) {
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
	}

	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
