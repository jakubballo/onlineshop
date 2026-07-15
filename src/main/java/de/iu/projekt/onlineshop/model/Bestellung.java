package de.iu.projekt.onlineshop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bestellung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="nutzer_id")
	private Nutzer nutzer;
	private LocalDateTime bestelldatum;
	@Column(precision=10,scale=2)
	private BigDecimal gesamtsumme;
	
	public Bestellung() {}
	
	public Bestellung(Long id,Nutzer nutzer, LocalDateTime bestelldatum, BigDecimal gesamtsumme) {
		this.id = id;
		this.nutzer = nutzer;
		this.bestelldatum = bestelldatum;
		this.gesamtsumme = gesamtsumme;
	}
	
	public Bestellung(Nutzer nutzer, LocalDateTime bestelldatum, BigDecimal gesamtsumme) {
		this.nutzer = nutzer;
		this.bestelldatum = bestelldatum;
		this.gesamtsumme = gesamtsumme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nutzer getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

	public LocalDateTime getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(LocalDateTime bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public BigDecimal getGesamtsumme() {
		return gesamtsumme;
	}

	public void setGesamtsumme(BigDecimal gesamtsumme) {
		this.gesamtsumme = gesamtsumme;
	}
	
}
