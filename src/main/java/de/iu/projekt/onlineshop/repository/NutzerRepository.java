package de.iu.projekt.onlineshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.iu.projekt.onlineshop.model.Nutzer;

public interface NutzerRepository extends JpaRepository<Nutzer, Long>{

	//Nutzer nach email finden
	Optional<Nutzer> findByEmail(String email);
}
