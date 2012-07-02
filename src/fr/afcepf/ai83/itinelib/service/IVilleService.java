package fr.afcepf.ai83.itinelib.service;

import fr.afcepf.ai83.itinelib.model.Ville;

public interface IVilleService {
	Ville findByCodePostal(String codePostal);
}
