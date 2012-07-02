package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Typeabonnement;

public interface ITypeAbonnementService {
	List<Typeabonnement> findAll();
	Typeabonnement findById(Integer id);
	Typeabonnement findByNomAbonnement (String nomTypeAbonnement);
	void save(Typeabonnement typeabonnement);
	
	
}
