package com.hackathon.pronunciation.namepronunciation.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;
import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationsDTO;

public interface NamePronunciationService {
	
	ResponseEntity<NamePronunciationDTO> getUserDetail(String userId);
	
	ResponseEntity<NamePronunciationsDTO> getUserFullDetail(String userId);
	
	ResponseEntity<NamePronunciationsDTO> saveAudio(MultipartFile file, String userId);
	
	ResponseEntity<Resource> getAudio(String userId) throws FileNotFoundException, IOException;

}
