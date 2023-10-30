package com.musicstreaminig.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicstreaminig.api.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
