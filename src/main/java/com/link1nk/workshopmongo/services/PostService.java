package com.link1nk.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link1nk.workshopmongo.domain.Post;
import com.link1nk.workshopmongo.repository.PostRepository;
import com.link1nk.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
	    return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	} 
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
