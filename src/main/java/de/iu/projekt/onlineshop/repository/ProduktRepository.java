package de.iu.projekt.onlineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.iu.projekt.onlineshop.model.Produkt;

//Standard Repo- CRUD Funktionen sind Default

@Repository
public interface ProduktRepository  extends JpaRepository<Produkt, Long>{
	
	//Alle produkte nach Kategorie ID zählen
	long countByKategorieId(Long kategorieId);
	
	//Top 6 Items by Order
	List<Produkt> findTop6ByOrderByIdDesc();
	
}
