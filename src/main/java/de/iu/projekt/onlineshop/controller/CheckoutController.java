package de.iu.projekt.onlineshop.controller;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Bestellposition;
import de.iu.projekt.onlineshop.model.Bestellung;
import de.iu.projekt.onlineshop.model.Nutzer;
import de.iu.projekt.onlineshop.repository.BestellpositionRepository;
import de.iu.projekt.onlineshop.repository.BestellungRepository;
import de.iu.projekt.onlineshop.repository.NutzerRepository;
import de.iu.projekt.onlineshop.warenkorb.Warenkorb;
import de.iu.projekt.onlineshop.warenkorb.Warenkorbeintrag;
import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

	private final NutzerRepository nutzerRepository;
	private final BestellungRepository bestellungRepository;
	private final BestellpositionRepository bestellpositionRepository;
	
	public CheckoutController (NutzerRepository nutzerRepository, BestellungRepository bestellungRepository, BestellpositionRepository bestellpositionRepository) {
		this.nutzerRepository = nutzerRepository;
		this.bestellungRepository = bestellungRepository;
		this.bestellpositionRepository = bestellpositionRepository;				
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
	
	@PostMapping("/checkout")
	public String checkout(Authentication authentication, HttpSession session) {
		String email = authentication.getName();
		Nutzer nutzer = nutzerRepository.findByEmail(email).orElseThrow();
		
		Warenkorb warenkorb = warenkorbAusSession(session);
		
		Bestellung bestellung = new Bestellung(nutzer, LocalDateTime.now(), warenkorb.getGesamtsumme());
		bestellung = bestellungRepository.save(bestellung);
		
		for (Warenkorbeintrag eintrag : warenkorb.getEintraege()) {
			Bestellposition position = new Bestellposition(eintrag.getMenge(), eintrag.getProdukt().getPreis(), bestellung, eintrag.getProdukt());		
			bestellpositionRepository.save(position);
		}
		
		warenkorb.leeren();
		
		return "redirect:/";
	}
}
