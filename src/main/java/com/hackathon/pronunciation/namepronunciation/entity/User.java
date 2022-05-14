package com.hackathon.pronunciation.namepronunciation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	String userId;
	
	@Column(name = "legal_first_name")
	String firstName;
	
	@Column(name = "legal_last_name")
	String lastName;
	
	@Column(name = "prefered_name")
	String preferedName;

	@Column(name = "work_phone")
	String workPhone;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "mac")
	String mac;
	
	@Column(name = "logon_id")
	String logonId;

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
