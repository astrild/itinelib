package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Pointlocation;

@Service("pointLocationService")
@Transactional
public class PointLocationServiceImpl implements IPointLocationService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pointlocation> findAll() {
		List<Pointlocation> liste = sessionFactory.getCurrentSession().createQuery("from Pointlocation").list();
		return liste;
	}

	@Override
	public Pointlocation findById(Integer id) {
		return (Pointlocation) sessionFactory.getCurrentSession().get(Pointlocation.class, id);
		
	}

}
