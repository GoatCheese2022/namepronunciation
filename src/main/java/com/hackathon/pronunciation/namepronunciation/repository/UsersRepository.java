package com.hackathon.pronunciation.namepronunciation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.pronunciation.namepronunciation.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{

	Users findByUserId(String userId);
	
}
