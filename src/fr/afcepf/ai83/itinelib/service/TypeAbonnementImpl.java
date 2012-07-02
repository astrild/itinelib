package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Typeabonnement;

@Service("typeAbonnementService")
@Transactional
public class TypeAbonnementImpl implements ITypeAbonnementService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Typeabonnement> findAll() {
		List<Typeabonnement> liste = 
			sessionFactory.getCurrentSession().createQuery("from Typeabonnement").list();
		return liste;
	}

	@Override
	public Typeabonnement findById(Integer id) {
		return (Typeabonnement) sessionFactory.getCurrentSession().get(Typeabonnement.class, id);
	}

	@Override
	public Typeabonnement findByNomAbonnement(String nomAbonnement) {
		Query query=sessionFactory.getCurrentSession().createQuery("FROM TypeAbonnement t WHERE nomabonement= :nomAbonnement");
		query.setString("nomAbonnement", nomAbonnement);
		Typeabonnement typeAbonnement = (Typeabonnement) query.uniqueResult();
		return typeAbonnement;

	}

	@Override
	public void save(Typeabonnement typeabonnement) {
		sessionFactory.getCurrentSession().saveOrUpdate(typeabonnement);
		System.out.println(typeabonnement.getNomabonnement());
		
	}

}
