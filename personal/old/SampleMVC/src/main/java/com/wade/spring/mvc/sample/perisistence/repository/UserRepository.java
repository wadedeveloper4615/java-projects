package com.wade.spring.mvc.sample.perisistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.wade.spring.mvc.sample.perisistence.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {
}
