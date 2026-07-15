package de.iu.projekt.onlineshop.controller;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Produkt;
import de.iu.projekt.onlineshop.repository.ProduktRepository;
import de.iu.projekt.onlineshop.warenkorb.Warenkorb;
import de.iu.projekt.onlineshop.warenkorb.Warenkorbeintrag;
import jakarta.servlet.http.HttpSession;

@Controller
public class WarenkorbController {
	
	private final ProduktRepository produktRepository;
	
	public WarenkorbController(ProduktRepository produktRepository) {
		this.produktRepository = produktRepository;
	}

	//Session für Warenkorb anlegen oder bereits vorhandene nutzen.
	private Warenkorb warenkorbAusSession(HttpSession session) {
		Warenkorb warenkorb = (Warenkorb) session.getAttribute("warenkorb");
		if (warenkorb == null) {
			warenkorb = new Warenkorb();
			session.setAttribute("warenkorb", warenkorb);
		}
		return warenkorb;
	}
	
	//Artikel zu Warenkorb hinzufügen
	@PostMapping("/warenkorb/hinzufuegen/{id}")
	public String hinzufuegen(@PathVariable Long id, HttpSession session) {
		Warenkorb warenkorb = warenkorbAusSession(session);
		Produkt produkt = produktRepository.findById(id).orElseThrow();
		
		warenkorb.hinzufuegen(produkt, 1);
		
		return "redirect:/produkte";
	}
	
	 //Artikel aus dem Warenkorb anzeigen
	@GetMapping("/warenkorb/liste")
	public String warenkorbAnzeigen(Model model, HttpSession session) {
		Warenkorb warenkorb = warenkorbAusSession(session);
		Collection <Warenkorbeintrag> liste = warenkorb.getEintraege();
		BigDecimal gesamtSumme = warenkorb.getGesamtsumme();
		
		model.addAttribute("warenkorbeinträge", liste);
		model.addAttribute("gesamtsumme", gesamtSumme);
		
		return "warenkorbliste";
	}
	
	//Artikel aus dem Warenkorb entfernen
	@PostMapping("/warenkorb/entfernen/{id}")
	public String entfernen(@PathVariable Long id, HttpSession session) {
		Warenkorb warenkorb = warenkorbAusSession(session);
		Produkt produkt = produktRepository.findById(id).orElseThrow();
		
		warenkorb.entfernen(produkt);
		
		return "redirect:/warenkorb/liste";
	}
}
