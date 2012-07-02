package fr.afcepf.ai83.itinelib.service;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Typeabonnement;
import fr.afcepf.ai83.itinelib.model.Ville;

@Service("abonnementService")
@Transactional
public class AbonnementServiceImpl implements IAbonnementService {

	@Autowired
	private ITypeAbonnementService iTypeAbonnementService;
	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override

	//Faire une liste de tous les abonnements
	public List<Abonnement> findAll() {
		List<Abonnement> liste = 
			sessionFactory.getCurrentSession().createQuery("from Abonnement ab ").list();
		return liste;
	}
	//Trouver un abonnement en fonction de son ID
	@Override
	public Abonnement findById(Integer id) {
		return (Abonnement) sessionFactory.getCurrentSession().get(Abonnement.class, id);
	}
	
	//Trouver un abonnement en fonction de l'abonne 
	public Abonnement findByAbonne(Abonne abonne) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonnement ab WHERE abonne = :abonne");
		query.setEntity("abonne", abonne);
		Abonnement abonnement = (Abonnement) query.uniqueResult();
		return abonnement;
	}

	//Creer un abonnement
	@Override
	public void save(Abonnement abonnement, Abonne abonne, Integer idType) {
		Typeabonnement typeAbonnement = iTypeAbonnementService.findById(idType);
		abonnement.setTypeabonnement(typeAbonnement);
		abonnement.setAbonne(abonne);
		abonnement.setDhsouscription(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(abonnement);
		System.out.println(abonnement.getIdabonnement());
	}
	
	//Modifier un abonnement
	@Override
	public void update(Abonnement abonnement, Integer idType) {
		Typeabonnement typeAbonnement = iTypeAbonnementService.findById(idType);
		System.out.println(typeAbonnement.getIdtype());
		System.out.println(typeAbonnement.getNomabonnement());
		System.out.println(abonnement);
		abonnement.setTypeabonnement(typeAbonnement);
		abonnement.setDhsouscription(new Date());
		sessionFactory.getCurrentSession().update(abonnement);
		System.out.println(abonnement.getIdabonnement());
	}
	
	//Resilier un abonnement
	@Override
	public void resilier(Abonnement abonnement){
	abonnement.setDhresiliation(new Date());
	System.out.println(abonnement.getDhresiliation());
	sessionFactory.getCurrentSession().update(abonnement);
	}
	
	
	//Accessor
	public ITypeAbonnementService getiTypeAbonnementService() {
		return iTypeAbonnementService;
	}
	public void setiTypeAbonnementService(
			ITypeAbonnementService iTypeAbonnementService) {
		this.iTypeAbonnementService = iTypeAbonnementService;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
