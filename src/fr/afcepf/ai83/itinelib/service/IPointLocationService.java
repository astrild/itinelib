package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Pointlocation;

public interface IPointLocationService {
	
	public List<Pointlocation> findAll();
	public Pointlocation findById(Integer id);
	
}
