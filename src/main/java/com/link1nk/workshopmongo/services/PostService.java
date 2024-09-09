package com.link1nk.workshopmongo.services;

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

}
