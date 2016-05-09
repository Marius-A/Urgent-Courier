package ro.go.mariusiliescu.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class LoginData {
	private Boolean isLogged;
	private String username;
	private String password;
	
	public LoginData(final String username , final String password){
		this.isLogged = false;
		this.username = username;
		this.password = password;
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
