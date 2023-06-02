package com.example.restau.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restau.entities.Ville;
import com.example.restau.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
	List<Zone> findByVilleId(int villeId);
	Zone findById(int id);
	Zone findByIdAndVille(int id, Ville ville);
	
	List<Zone> findByVille(Ville ville);
	
	
	Zone findByNomAndVille(String nom, Ville ville);
	
/*	List<Zone> findByVille(Ville ville);
	
	Zone findByNom(String nom);
	
	Zone findByNomAndVille(String nom, Ville ville);
	*/
}