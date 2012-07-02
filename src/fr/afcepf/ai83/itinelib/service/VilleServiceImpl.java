package fr.afcepf.ai83.itinelib.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Ville;

@Service("villeService")
@Transactional
public class VilleServiceImpl implements IVilleService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Ville findByCodePostal(String codePostal) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Ville v WHERE codepostal = :codePostal");
		query.setString("codePostal", codePostal);
		Ville ville = (Ville) query.uniqueResult();
		return ville;
	}

}
