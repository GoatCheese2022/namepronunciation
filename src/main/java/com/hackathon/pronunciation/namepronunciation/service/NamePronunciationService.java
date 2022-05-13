package com.hackathon.pronunciation.namepronunciation.service;

import org.springframework.http.ResponseEntity;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;

public interface NamePronunciationService {
	
	ResponseEntity<NamePronunciationDTO> getUserDetail(String userId);

}
