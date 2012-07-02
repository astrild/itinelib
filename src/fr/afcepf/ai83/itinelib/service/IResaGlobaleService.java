package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Resaglobale;

public interface IResaGlobaleService {
	
	public List<Resaglobale> findAll();
	public Resaglobale findById(Integer id);
	//public void save(Resaglobale newResaGlobale);
	
}
