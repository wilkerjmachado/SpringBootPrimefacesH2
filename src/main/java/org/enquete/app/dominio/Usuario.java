package org.enquete.app.dominio;

import javax.persistence.Entity;

import org.enquete.framework.dominio.Entidade;

@Entity
public class Usuario extends Entidade {

	private String username;

	private String password;

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
