package de.iu.projekt.onlineshop.warenkorb;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.iu.projekt.onlineshop.model.Produkt;

public class Warenkorb {

	private Map<Long, Warenkorbeintrag> eintraege = new HashMap<>();
	
	//Zum Warenkorb hinzufügen
	public void hinzufuegen(Produkt produkt, int menge) {
		if (eintraege.containsKey(produkt.getId())) {
			Warenkorbeintrag produktGefunden = eintraege.get(produkt.getId());
			int mengeGefunden = produktGefunden.getMenge();
			produktGefunden.setMenge(mengeGefunden+menge);
		} else {
			eintraege.put(produkt.getId(), new Warenkorbeintrag(produkt,menge));
		}
	}
	
	//Alle Warenkorb einträge ausgeben
	public Collection<Warenkorbeintrag> getEintraege(){
		return eintraege.values();
	}
	
	//Artikel aus Warenkorb entfernen
	public void entfernen(Produkt produkt) {
		eintraege.remove(produkt.getId());
	}
	
	//Gesamt summe berechnen
	public BigDecimal getGesamtsumme() {
		BigDecimal summe = BigDecimal.ZERO;
		for (Warenkorbeintrag e: eintraege.values()) {
			BigDecimal preis = e.getProdukt().getPreis();
			BigDecimal menge = BigDecimal.valueOf(e.getMenge());
			BigDecimal zwischensumme = preis.multiply(menge);
			
			summe = summe.add(zwischensumme);
		}
		return summe;
	}

	//Warenkorb leeren
	public void leeren() {
		eintraege.clear();
	}
}