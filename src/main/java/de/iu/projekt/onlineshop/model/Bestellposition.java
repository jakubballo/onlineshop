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
public class Bestellposition {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private int menge;
		@Column(precision= 10, scale= 2)
		private BigDecimal einzelpreis;
		@ManyToOne
		@JoinColumn(name= "bestellung_id")
		private Bestellung bestellung;
		@ManyToOne
		@JoinColumn(name = "produkt_id")
		private Produkt produkt;
		
		public Bestellposition() {}
		
		public Bestellposition(Long id, int menge, BigDecimal einzelpreis, Bestellung bestellung, Produkt produkt) {
			this.id = id;
			this.menge = menge;
			this.einzelpreis = einzelpreis;
			this.bestellung  = bestellung;
			this.produkt  = produkt;
		}
		
		public Bestellposition(int menge, BigDecimal einzelpreis, Bestellung bestellung, Produkt produkt) {
			this.menge = menge;
			this.einzelpreis = einzelpreis;
			this.bestellung  = bestellung;
			this.produkt  = produkt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getMenge() {
			return menge;
		}

		public void setMenge(int menge) {
			this.menge = menge;
		}

		public BigDecimal getEinzelpreis() {
			return einzelpreis;
		}

		public void setEinzelpreis(BigDecimal einzelpreis) {
			this.einzelpreis = einzelpreis;
		}

		public Bestellung getBestellung() {
			return bestellung;
		}

		public void setBestellung(Bestellung bestellung) {
			this.bestellung = bestellung;
		}

		public Produkt getProdukt() {
			return produkt;
		}

		public void setProdukt(Produkt produkt) {
			this.produkt = produkt;
		}
		
		
}
