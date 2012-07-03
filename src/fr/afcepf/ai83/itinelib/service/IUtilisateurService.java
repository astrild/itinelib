package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Utilisateur;;

public interface IUtilisateurService {

	
	List<Utilisateur> findAll();
	Utilisateur findById(Integer id);
	Utilisateur findByIdAbonne (Abonne abonne);
	List<Utilisateur> findByEmail(String email);
	void saveAbonne(Utilisateur utilisateur, Integer id, String password);
	void update (Utilisateur utilisateur,String password);
	Utilisateur find(String email, String password);
}
