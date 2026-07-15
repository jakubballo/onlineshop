package de.iu.projekt.onlineshop.warenkorb;

import de.iu.projekt.onlineshop.model.Produkt;

//Einfache Klasse für Warenkorbeintrag
//Keine Tabelle, da nur Session abhängig

public class Warenkorbeintrag {
	
	private Produkt produkt;
	private int menge;
	
	public Warenkorbeintrag(Produkt produkt, int menge) {
		this.produkt = produkt;
		this.menge = menge;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
}
