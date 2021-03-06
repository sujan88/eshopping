
package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.validation.EmptyOrSize;

@Entity(name = "CREDENTIALS")
public class UserCredentials {

	@Id
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "{String.empty}")
	String username;

	@Column(nullable = false)
	@EmptyOrSize(min = 8, max = 16, message = "{EmptyOrSize}")
	String password;

	@Column(nullable = false)
	@EmptyOrSize(min = 8, max = 16, message = "{EmptyOrSize}")
	String verifyPassword;

	Boolean enabled;

	@OneToOne(mappedBy = "userCredentials")
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id")
	List<Authority> authority = new ArrayList<Authority>();

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

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isAdmin(){
		for (Authority auth : authority)
		{
			if (auth.getAuthority().equals("ROLE_ADMIN"))
				return true;
		}
		return false;
	}
	
	public boolean isUser(){
		for (Authority auth : authority)
		{
			if (auth.getAuthority().equals("ROLE_USER"))
				return true;
		}
		return false;
	}

}
