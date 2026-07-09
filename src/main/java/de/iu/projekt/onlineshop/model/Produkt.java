package de.iu.projekt.onlineshop.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	private String beschreibung;
	private int lagerbestand;
	private String bildpfad;
	@ManyToOne
	@JoinColumn(name = "kategorie_id")
	private Kategorie kategorie;
	
	//Standard Konstruktor
	public Produkt() {}
	
	//Konstruktor mit alle Felder
	public Produkt(Long id, String hersteller, String modell, String zustand, BigDecimal preis, String beschreibung, 
			int lagerbestand, String bildpfad) {
		
		this.id = id;
		this.hersteller = hersteller;
		this.modell = modell;
		this.zustand = zustand;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.lagerbestand = lagerbestand;
		this.bildpfad = bildpfad;

	}
	
	//Konstruktor ohne id
	public Produkt(String hersteller, String modell, String zustand, BigDecimal preis, String beschreibung, 
			int lagerbestand, String bildpfad) {
		
		this.hersteller = hersteller;
		this.modell = modell;
		this.zustand = zustand;
		this.preis = preis;
		this.beschreibung = beschreibung;
		this.lagerbestand = lagerbestand;
		this.bildpfad = bildpfad;

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
	
	public String getBeschreibung() {
		return this.beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public int getLagerbestand() {
		return this.lagerbestand;
	}
	
	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}
	
	public String getBildpfad() {
		return this.bildpfad;
	}
	
	public void setBildpfad(String bildpfad) {
		this.bildpfad = bildpfad;
	}
	
	public Kategorie getKategorie() {
		return this.kategorie;
	}
	
	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}
	
	
}
