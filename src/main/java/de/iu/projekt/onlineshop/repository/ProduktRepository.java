package de.iu.projekt.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.iu.projekt.onlineshop.model.Produkt;

//Standard Repo- CRUD Funktionen sind Default

@Repository
public interface ProduktRepository  extends JpaRepository<Produkt, Long>{

}
