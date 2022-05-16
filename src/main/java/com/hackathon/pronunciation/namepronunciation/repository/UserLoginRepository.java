package com.hackathon.pronunciation.namepronunciation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.pronunciation.namepronunciation.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{
	
	UserLogin findByUserIdAndPassword(String userId, String Password);

}
