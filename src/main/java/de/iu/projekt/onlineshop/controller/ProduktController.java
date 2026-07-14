package de.iu.projekt.onlineshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Kategorie;
import de.iu.projekt.onlineshop.model.Produkt;
import de.iu.projekt.onlineshop.repository.KategorieRepository;
import de.iu.projekt.onlineshop.repository.ProduktRepository;

@Controller
public class ProduktController {

	private final ProduktRepository produktRepository;
	private final KategorieRepository kategorieRepository;
	
	public ProduktController(ProduktRepository produktRepository, KategorieRepository kategorieRepository) {
		this.produktRepository = produktRepository;
		this.kategorieRepository = kategorieRepository;
	}
	
	//Alle Produkte auflisten
	@GetMapping("/produkte")
	public String produktListe(Model model) {
		List<Produkt> produktListe = produktRepository.findAll();
		model.addAttribute("produkte", produktListe);
		
		return "produktliste";
	}
	
	//Produkt details zu einem Produkt "id"
	@GetMapping("/produkte/{id}")
	public String produktDetails(@PathVariable Long id, Model model) {
		Optional<Produkt> produktDetails = produktRepository.findById(id);
		Produkt produkt = produktDetails.orElseThrow();
		
		model.addAttribute("produkt", produkt);
		
		return "produktdetail";
	}
	
	//Produkt anlegen
	@GetMapping("/admin/produkte/neu")
	public String produktAnlegen(Model model) {
		Produkt produkt = new Produkt();
		model.addAttribute("produkt", produkt);
		
		List<Kategorie> kategorieListe = kategorieRepository.findAll();
		model.addAttribute("kategorien", kategorieListe);
		
		return "produktformular";
	}
	
	//Formular speichern 
	@PostMapping("/admin/produkte/neu")
	public String produktAnlegenPost(@ModelAttribute Produkt produkt) {
		produktRepository.save(produkt);
		
		return "redirect:/produkte";
	}
	
	//Produkt nach id Löschen
	@PostMapping("/admin/produkte/{id}/loeschen")
	public String produktLoeschen(@PathVariable Long id) {
		produktRepository.deleteById(id);
		
		return "redirect:/produkte";
	}
	
	//Produkt bearbeiten
	@GetMapping("/admin/produkte/{id}/bearbeiten")
	public String produktBearbeiten(@PathVariable Long id, Model model) {
		Optional<Produkt> produktDetails = produktRepository.findById(id);
		Produkt produkt = produktDetails.orElseThrow();
		
		model.addAttribute("produkt", produkt);
		
		List<Kategorie> kategorieListe = kategorieRepository.findAll();
		model.addAttribute("kategorien", kategorieListe);
		
		return "produktformular";
	}
	
	//Produkt bearbeiten Speichern
	@PostMapping("/admin/produkte/{id}/bearbeiten")
	public String produktBearbeitenPost(@PathVariable Long id, @ModelAttribute Produkt produkt) {
		produktRepository.save(produkt);
		
		return "redirect:/produkte";
	}
}
