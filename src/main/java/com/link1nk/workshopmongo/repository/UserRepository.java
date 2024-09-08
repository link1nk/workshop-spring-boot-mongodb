package com.link1nk.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.link1nk.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
