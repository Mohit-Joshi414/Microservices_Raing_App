package com.mohit.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.userService.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
