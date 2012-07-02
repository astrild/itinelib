package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;;

public interface IAbonnementService {

	List<Abonnement> findAll();
	Abonnement findById(Integer id);
	Abonnement findByAbonne(Abonne abonne);
	void save(Abonnement abonnement,Abonne abonne, Integer idType);
	void update(Abonnement abonnement, Integer idType);
	void resilier(Abonnement abonnement);
}
