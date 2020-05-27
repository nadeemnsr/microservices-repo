package com.discovery.app.user.ui.model;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable{

	
	private static final long serialVersionUID = 2706120247981283349L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String UserId;
	private String encryptedPass;
	private List<AlbumResponseModel> model;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getEncryptedPass() {
		return encryptedPass;
	}
	public void setEncryptedPass(String encryptedPass) {
		this.encryptedPass = encryptedPass;
	}
	public List<AlbumResponseModel> getModel() {
		return model;
	}
	public void setModel(List<AlbumResponseModel> model) {
		this.model = model;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
