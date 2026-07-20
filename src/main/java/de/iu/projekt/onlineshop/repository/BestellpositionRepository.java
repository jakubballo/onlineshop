package de.iu.projekt.onlineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.iu.projekt.onlineshop.model.Bestellposition;

public interface BestellpositionRepository extends JpaRepository<Bestellposition, Long>{
	
	List<Bestellposition> findByBestellungId(Long bestellungId);
	long countByProduktId(Long produktId);
}
