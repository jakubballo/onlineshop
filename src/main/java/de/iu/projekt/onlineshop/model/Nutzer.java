package de.iu.projekt.onlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nutzer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String passwort;
	@Enumerated(EnumType.STRING)
	private Rolle rolle;
	
	public Nutzer() {}
	
	public Nutzer(Long id, String email, String passwort, Rolle rolle) {
		this.id = id;
		this.email = email;
		this.passwort = passwort;
		this.rolle = rolle;
	}
	
	public Nutzer(String email, String passwort, Rolle rolle) {
		this.email = email;
		this.passwort = passwort;
		this.rolle = rolle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}
}
