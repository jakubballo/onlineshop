package de.iu.projekt.onlineshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Nutzer;
import de.iu.projekt.onlineshop.repository.NutzerRepository;

@Controller
public class ProfilController {
	private final NutzerRepository nutzerRepository;
	
	public ProfilController (NutzerRepository nutzerRepository) {
		this.nutzerRepository = nutzerRepository;
	}
	
	@GetMapping("/profil")
	public String profilBearbeiten(Authentication authentication, Model model) {
		String email = authentication.getName();
		Nutzer nutzer = nutzerRepository.findByEmail(email).orElseThrow();
		
		model.addAttribute("profil", nutzer);
		
		return "profil";
	}
	
	@GetMapping("/profil/bearbeiten")
	public String profilBearbeitenFormular(Authentication authentication, Model model) {
		String email = authentication.getName();
		Nutzer nutzer = nutzerRepository.findByEmail(email).orElseThrow();
		
		model.addAttribute("profil", nutzer);
		
		return "profilbearbeiten";
	}
	
	@PostMapping("/profil/bearbeiten")
	public String profilBearbeitenFormularPost(Authentication authentication, @ModelAttribute Nutzer nutzer) {
		String email = authentication.getName();
		Nutzer gefundeneNutzer = nutzerRepository.findByEmail(email).orElseThrow();
		
		gefundeneNutzer.setHausnummer(nutzer.getHausnummer());
		gefundeneNutzer.setOrt(nutzer.getOrt());
		gefundeneNutzer.setStrasse(nutzer.getStrasse());
		gefundeneNutzer.setPlz(nutzer.getPlz());
		
		nutzerRepository.save(gefundeneNutzer);
		
		return "redirect:/profil";		
	}
}
