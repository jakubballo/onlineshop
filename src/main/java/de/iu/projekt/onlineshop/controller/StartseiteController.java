package de.iu.projekt.onlineshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.iu.projekt.onlineshop.model.Produkt;
import de.iu.projekt.onlineshop.repository.ProduktRepository;

@Controller
public class StartseiteController {
	
	private final ProduktRepository produktRepository;
	
	public StartseiteController (ProduktRepository produktRepository) {
		this.produktRepository = produktRepository;
	}
	
	//Startseite 
	@GetMapping("/")
	public String startseite(Model model) {
		List <Produkt> produktListe = produktRepository.findTop6ByOrderByIdDesc();
		model.addAttribute("produktListe", produktListe);
		
		return "startseite";
	}
}
