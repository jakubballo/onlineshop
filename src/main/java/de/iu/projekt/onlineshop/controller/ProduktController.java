package de.iu.projekt.onlineshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.iu.projekt.onlineshop.model.Produkt;
import de.iu.projekt.onlineshop.repository.ProduktRepository;

@Controller
public class ProduktController {

	private final ProduktRepository produktRepository;
	
	public ProduktController(ProduktRepository productRepository) {
		this.produktRepository = productRepository;
	}
	
	@GetMapping("/produkte")
	public String produktListe(Model model) {
		List<Produkt> produktListe = produktRepository.findAll();
		model.addAttribute("produkte", produktListe);
		
		return "produktliste";
	}
	
	@GetMapping("/produkte/{id}")
	public String produktDetails(@PathVariable Long id, Model model) {
		Optional<Produkt> produktDetails = produktRepository.findById(id);
		Produkt produkt = produktDetails.orElseThrow();
		
		model.addAttribute("produkt", produkt);
		
		return "produktdetail";
	}
}
