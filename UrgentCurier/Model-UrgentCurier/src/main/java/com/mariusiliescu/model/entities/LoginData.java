package com.mariusiliescu.model.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Embeddable
@Access(AccessType.PROPERTY)
public class LoginData {
	@Transient
	private Boolean isLogged;
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	public LoginData(final String username , final String password){
		this.isLogged = false;
		this.username = username;
		this.password = password;
	}
	
	public LoginData(){
		this.isLogged = false;
		this.username = new String();
		this.password = new String();
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
