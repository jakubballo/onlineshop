package de.iu.projekt.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.iu.projekt.onlineshop.model.Kategorie;

@Repository
public interface KategorieRepository extends JpaRepository<Kategorie,Long>{

}
