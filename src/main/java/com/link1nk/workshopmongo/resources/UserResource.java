package com.link1nk.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.link1nk.workshopmongo.domain.User;
import com.link1nk.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		list.addAll(userService.findAll());
		return ResponseEntity.ok().body(list);
	}
}
