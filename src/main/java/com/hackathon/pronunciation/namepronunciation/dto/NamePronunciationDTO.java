package com.hackathon.pronunciation.namepronunciation.dto;

import java.io.Serializable;

public class NamePronunciationDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6522861568487055102L;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String preferedName;
	
	public String getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPreferredName() {
		return preferedName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName ;
	}
	public void setPreferedName(String preferedName) {
		this.preferedName =  preferedName;
	}

	
/*	public NamePronunciationDTO(final String userId, final String firstName, final String lastName, final String preferredName) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredName = preferredName;
	}*/


	
	
}
