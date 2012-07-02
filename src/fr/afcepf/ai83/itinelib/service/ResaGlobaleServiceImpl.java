package fr.afcepf.ai83.itinelib.service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Registre;
import fr.afcepf.ai83.itinelib.model.Resaglobale;

@Service("resaGlobaleService")
@Transactional
public class ResaGlobaleServiceImpl implements IResaGlobaleService {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Resaglobale> findAll() {
		List<Resaglobale> liste = sessionFactory.getCurrentSession().createQuery("from Resaglobale rg where rg.registres <> empty").list();
		return liste;
		
//		for (Resaglobale resaglobale : liste) {			
//			Set<Registre> li = resaglobale.getRegistres();
//			Registre premierRegistre = (Registre) li.toArray()[0];
//			System.out.println(premierRegistre);
//			System.out.println(premierRegistre.getPointlocationByIdpointlocation().getNompointlocation() );
//
//		}
		
	}

	@Override
	public Resaglobale findById(Integer id) {
		return (Resaglobale) sessionFactory.getCurrentSession().get(Resaglobale.class, id);
		
	}

}
