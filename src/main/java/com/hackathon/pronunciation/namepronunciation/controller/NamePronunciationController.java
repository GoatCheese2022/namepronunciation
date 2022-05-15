package com.hackathon.pronunciation.namepronunciation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;
import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationsDTO;
import com.hackathon.pronunciation.namepronunciation.service.NamePronunciationService;

@RestController
@RequestMapping("/pronunciation")
@CrossOrigin("*")
public class NamePronunciationController {
	
	@Autowired
	private NamePronunciationService namePronunciationService;
	
	public static final Logger logger = LoggerFactory.getLogger(NamePronunciationController.class);

	@GetMapping("/get-details")
	public ResponseEntity<NamePronunciationDTO> getNamePronunciationDetails(@RequestParam final String userId ){
		
		logger.info("Getting User Details for :"+userId);
		
		return namePronunciationService.getUserDetail(userId);
	}
	
	@GetMapping("/get-user-details")
	public ResponseEntity<NamePronunciationsDTO> getUserPronunciationDetails(@RequestParam final String userId ){
		
		logger.info("Getting User Details for :"+userId);
		
		return namePronunciationService.getUserFullDetail(userId);
	}
	
	@PostMapping("/save-audio")
	public ResponseEntity<NamePronunciationsDTO> saveAudio(@RequestParam("file") MultipartFile file, @RequestParam("userId") final String userId ){
		
		logger.info("Saving Audio file for :"+userId);
		
		return namePronunciationService.saveAudio(file, userId);
	
	}
 
	@GetMapping("/get-audio")
	public ResponseEntity<Resource> getAudio(@RequestParam final String userId ) throws FileNotFoundException, IOException{
		
		logger.info("Getting User audio Detail for :"+userId);
		
		return namePronunciationService.getAudio(userId);
	}
}
