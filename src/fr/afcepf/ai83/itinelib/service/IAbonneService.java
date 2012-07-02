package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;

public interface IAbonneService  {
	List<Abonne> findAll();
	List<Abonne> findByPrenom(String prenom);
	List<Abonne> findByNom(String nom);
	List<Abonne> findByTelephone(String telephone);
	List<Abonne> findByEmail(String email);
	Abonne findById(Integer id);
	List<Abonne> findByIdInList(Integer id);
	void save(Abonne abonne, String codepostal);
}
