package com.taskflow.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskflow.application.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
