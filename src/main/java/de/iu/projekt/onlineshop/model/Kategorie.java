package de.iu.projekt.onlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kategorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String beschreibung;
	
	public Kategorie() {}
	
	public Kategorie(Long id, String name, String beschreibung) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
	}
	
	public Kategorie(String name,String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBeschreibung() {
		return this.beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
