package de.iu.projekt.onlineshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.iu.projekt.onlineshop.model.Kategorie;
import de.iu.projekt.onlineshop.repository.KategorieRepository;
import de.iu.projekt.onlineshop.repository.ProduktRepository;

@Controller
public class KategorieController {

	private final KategorieRepository kategorieRepository;
	private final ProduktRepository produktRepository;
	
	public KategorieController(KategorieRepository kategorieRepository, ProduktRepository produktRepository) {
		this.kategorieRepository = kategorieRepository;
		this.produktRepository = produktRepository;
	}
	
	//Kategorien auflisten
	@GetMapping("/kategorien")
	public String kategorieListe(Model model) {
		List<Kategorie> kategorieListe = kategorieRepository.findAll();
		model.addAttribute("kategorien", kategorieListe);
		
		return "kategorieliste";
	}
	
	//Für Kategorie Anlegen
	@GetMapping("/admin/kategorien/neu")
	public String kategorieAnlegen(Model model) {
		Kategorie kategorie = new Kategorie();
		model.addAttribute("kategorie",kategorie);
		
		return "kategorieformular";
	}
	
	//Daten aus Formular speichern
	@PostMapping("/admin/kategorien/neu")
	public String kategorieAnlegenPost(@ModelAttribute Kategorie kategorie) {
		kategorieRepository.save(kategorie);
		
		return "redirect:/kategorien";
	}
	
	//Kategorie Löschen
	@PostMapping("/admin/kategorien/{id}/loeschen")
	public String kategorieLoeschen(@PathVariable Long id) {
		
		if (produktRepository.countByKategorieId(id) == 0) {
			kategorieRepository.deleteById(id);
			return "redirect:/kategorien";
		}
			
		return "redirect:/kategorien";
	}
}
