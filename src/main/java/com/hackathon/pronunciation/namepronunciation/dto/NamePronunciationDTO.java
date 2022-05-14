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
	private String workPhone;
	private String email;
	private String mac;
	private String logonId;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPreferedName() {
		return preferedName;
	}
	
	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}
	
	public String getWorkPhone() {
		return workPhone;
	}
	
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMac() {
		return mac;
	}
	
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getLogonId() {
		return logonId;
	}
	
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}
		

}
