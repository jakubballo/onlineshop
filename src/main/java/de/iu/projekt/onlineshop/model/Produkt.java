package de.iu.projekt.onlineshop.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produkt {
	
	//Tabellen Felder
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hersteller;
	private String modell;
	private String zustand;
	@Column(precision = 10, scale = 2) //Spezielle formatierung für Preis: 10 stellen vor komma, 2 nach komma
	private BigDecimal preis;
	
	//Standard Konstruktor
	public Produkt() {}
	
	//Konstruktor mit Felder
	public Produkt(Long id, String hersteller, String modell, String zustand, BigDecimal preis) {
		this.id = id;
		this.hersteller = hersteller;
		this.modell = modell;
		this.zustand = zustand;
		this.preis = preis;
	}
	
	//Getter und Setter
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getHersteller() {
		return this.hersteller;
	}
	
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	
	public String getModell() {
		return this.modell;
	}
	
	public void setModell(String modell) {
		this.modell = modell;
	}
	
	public String getZustand() {
		return this.zustand;
	}
	
	public void setZustand(String zustand) {
		this.zustand = zustand;
	}
	
	public BigDecimal getPreis() {
		return this.preis;
	}
	
	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}
	
	
	
}
