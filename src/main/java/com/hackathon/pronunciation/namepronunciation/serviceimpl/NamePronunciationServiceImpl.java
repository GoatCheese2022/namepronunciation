package com.hackathon.pronunciation.namepronunciation.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;
import com.hackathon.pronunciation.namepronunciation.entity.User;
import com.hackathon.pronunciation.namepronunciation.exceptions.NotFoundException;
import com.hackathon.pronunciation.namepronunciation.repository.UserRepository;
import com.hackathon.pronunciation.namepronunciation.service.NamePronunciationService;

@Service
public class NamePronunciationServiceImpl implements NamePronunciationService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ResponseEntity<NamePronunciationDTO> getUserDetail(String userId) {
	
		
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new NotFoundException("User details not found for User ID :"+userId);
		}
		
		final User user = userOptional.get();
		
		NamePronunciationDTO responseDto = null;
		responseDto = mapper.map(user, NamePronunciationDTO.class);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	

}
