package de.iu.projekt.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartseiteController {
	
	//Startseite 
	@GetMapping("/")
	public String startseite() {
		return "startseite";
	}
}
