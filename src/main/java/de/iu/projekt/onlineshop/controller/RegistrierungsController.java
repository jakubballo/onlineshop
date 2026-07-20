package de.iu.projekt.onlineshop.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Nutzer;
import de.iu.projekt.onlineshop.model.Rolle;
import de.iu.projekt.onlineshop.repository.NutzerRepository;

@Controller
public class RegistrierungsController {
	
	private final NutzerRepository nutzerRepository;
	private final PasswordEncoder passwordEncoder;
	
	public RegistrierungsController (NutzerRepository nutzerRepository, PasswordEncoder passwordEncoder) {
		this.nutzerRepository = nutzerRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	//Neuen nutzer anlegen
	@GetMapping("/registrieren")
	public String neuesNutzer(Model model) {
		Nutzer nutzer = new Nutzer();
		model.addAttribute("nutzer", nutzer);
		
		return "registrierformular";
	}
	
	//Neuen nutzer speichern
	@PostMapping("/registrieren")
	public String neuesNutzerPost(@ModelAttribute Nutzer nutzer) {
		String password = nutzer.getPasswort();
		String hashPassword = passwordEncoder.encode(password);
		
		nutzer.setPasswort(hashPassword);
		nutzer.setRolle(Rolle.KUNDE);
		
		nutzerRepository.save(nutzer);
		
		return "redirect:/";
	}
}
