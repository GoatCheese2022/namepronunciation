package com.hackathon.pronunciation.namepronunciation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;
import com.hackathon.pronunciation.namepronunciation.service.NamePronunciationService;

@RestController
@RequestMapping("/pronunciation")
public class NamePronunciationController {
	
	@Autowired
	private NamePronunciationService namePronunciationService;
	
	public static final Logger logger = LoggerFactory.getLogger(NamePronunciationController.class);

	@GetMapping("/get-details")
	public ResponseEntity<NamePronunciationDTO> getNamePronunciationDetails(@RequestBody final String userId ){
		
		logger.info("Getting User Details for :"+userId);
		
		return namePronunciationService.getUserDetail(userId);
	}
}
