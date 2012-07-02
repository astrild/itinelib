package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Registre;

@Service("registreService")
@Transactional
public class RegistreServiceImpl implements IRegistreService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Registre> findAll() {
		List<Registre> liste = sessionFactory.getCurrentSession().createQuery("from Registre r").list();
		return liste;
	}

}
