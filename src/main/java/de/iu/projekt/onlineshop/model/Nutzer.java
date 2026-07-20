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
	private String strasse;
	private String hausnummer;
	private String plz;
	private String ort;
	
	public Nutzer() {}
	
	public Nutzer(Long id, String email, String passwort, Rolle rolle, String strasse, String hausnummer, String plz, String ort) {
		this.id = id;
		this.email = email;
		this.passwort = passwort;
		this.rolle = rolle;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}
	
	public Nutzer(String email, String passwort, Rolle rolle, String strasse, String hausnummer, String plz, String ort) {
		this.email = email;
		this.passwort = passwort;
		this.rolle = rolle;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
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
