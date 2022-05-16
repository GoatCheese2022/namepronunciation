package com.hackathon.pronunciation.namepronunciation.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationDTO;
import com.hackathon.pronunciation.namepronunciation.dto.NamePronunciationsDTO;
import com.hackathon.pronunciation.namepronunciation.entity.User;
import com.hackathon.pronunciation.namepronunciation.entity.UserLogin;
import com.hackathon.pronunciation.namepronunciation.entity.Users;
import com.hackathon.pronunciation.namepronunciation.exceptions.NotFoundException;
import com.hackathon.pronunciation.namepronunciation.repository.UserLoginRepository;
import com.hackathon.pronunciation.namepronunciation.repository.UserRepository;
import com.hackathon.pronunciation.namepronunciation.repository.UsersRepository;
import com.hackathon.pronunciation.namepronunciation.service.NamePronunciationService;

@Service
public class NamePronunciationServiceImpl implements NamePronunciationService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
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
	
	@Override
	public ResponseEntity<NamePronunciationsDTO> getUserFullDetail(String userId) {
	
		
		Optional<Users> usersOptional = usersRepository.findById(userId);
		if(!usersOptional.isPresent()) {
			throw new NotFoundException("User details not found for User ID :"+userId);
		}
		
		final Users user = usersOptional.get();
		
		NamePronunciationsDTO responseDto = null;
		responseDto = mapper.map(user, NamePronunciationsDTO.class);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@Override
	public ResponseEntity<NamePronunciationsDTO> saveAudio(MultipartFile file, String userId) {
		
		String fileName = file.getOriginalFilename();
		System.out.println("File name is "+fileName);
		
		Optional<Users> usersOptional = usersRepository.findById(userId);
		if(!usersOptional.isPresent()) {
			throw new NotFoundException("User details not found for User ID :"+userId);
		}
		
		Users user = usersOptional.get();
		try {
			user.setAudioFileBytes(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Users savedUser = usersRepository.save(user);
		NamePronunciationsDTO responseDto = null;
		if(savedUser!=null) {
			
			responseDto = mapper.map(savedUser, NamePronunciationsDTO.class);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@Override
	public ResponseEntity<Resource> getAudio(String userId) throws IOException {
		
		Optional<Users> usersOptional = usersRepository.findById(userId);
		if(!usersOptional.isPresent()) {
			throw new NotFoundException("User details not found for User ID :"+userId);
		}
		
		final Users user = usersOptional.get();
		
		//MultipartFile multipartFile;
		
		File file;
		
		InputStream b_in = new ByteArrayInputStream(user.getAudioFileBytes());
		
		        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
		                  8000f,
		                  16,
		                  1,
		                  2, // frameSize
		                  8000f,// frameRate
		                  false);
		        
		        AudioInputStream stream = new AudioInputStream(b_in, format,
		        		user.getAudioFileBytes().length);
		        file = new File("f:\\file.wav");
		        AudioSystem.write(stream, Type.WAVE, file);
		        System.out.println("File saved: " + file.getName() + ", bytes: " + user.getAudioFileBytes().length);
		
		        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		        return ResponseEntity.ok()
		                .contentLength(file.length())
		                .contentType(MediaType.MULTIPART_FORM_DATA)
		                .body(resource);
		

	}

	@Override
	public ResponseEntity<Boolean> getAuthenticate(String userId, String password) {
		
		UserLogin usersOptional = userLoginRepository.findByUserIdAndPassword(userId, password);
		if(usersOptional!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.FALSE);
		}
		
	}
	
	
	
	

}
