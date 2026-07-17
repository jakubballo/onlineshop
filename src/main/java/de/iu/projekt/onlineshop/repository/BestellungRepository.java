package de.iu.projekt.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.iu.projekt.onlineshop.model.Bestellung;

public interface BestellungRepository extends JpaRepository<Bestellung,Long>{

}
