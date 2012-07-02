package fr.afcepf.ai83.itinelib.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.model.Ville;

@Service("abonneService")
@Transactional
public class AbonneServiceImpl implements IAbonneService {
	
	@Autowired
	private IVilleService iVilleService;
	@Autowired
	private SessionFactory sessionFactory;
	
	//Faire la liste de tout les abonnés
	@Override
	public List<Abonne> findAll() {
		List<Abonne> liste = 
			sessionFactory.getCurrentSession().createQuery("from Abonne a LEFT JOIN FETCH a.utilisateurs").list();
		return liste;
	}
	
	//Trouver un abonne en fonction de son ID
	@Override
	public Abonne findById(Integer id) {
		return (Abonne) sessionFactory.getCurrentSession().get(Abonne.class, id);
	}

	//Chercher un abonne en fonction de son prenom
	@Override
	public List<Abonne> findByPrenom(String prenom) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE prenomabonne =:prenom");
		query.setString("prenom", prenom);
		List<Abonne> liste= query.list();
		return liste;
	}
	
	//Chercher un abonne en fonction de son nom
	@Override
	public List<Abonne> findByNom(String nom) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE nomabonne =:nom");
		query.setString("nom", nom);
		List<Abonne> liste= query.list();
		return liste;
	}

	@Override
	public List<Abonne> findByIdInList(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE id =:id");
		query.setInteger("id", id);
		List<Abonne> liste= query.list();
		System.out.println(liste);
		return liste;
	}

	@Override
	public List<Abonne> findByEmail(String email) {
		List<Abonne> liste = new ArrayList<Abonne>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Utilisateur a WHERE email =:email");
		query.setString("email", email);
		List<Utilisateur> listeUtilisateurs = query.list();
		for (Utilisateur utilisateur : listeUtilisateurs) {
			Abonne a = utilisateur.getAbonne();
			System.out.println(a);
			liste.add(a);
		}
		System.out.println();
		return liste;
	}	
	
	//Chercher un abonne en fonction de son telephone
	@SuppressWarnings("unchecked")
	@Override
	public List<Abonne> findByTelephone(String telephone) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE tel =:telephone");
		query.setString("tel", telephone);
		List<Abonne> liste= query.list();
		return liste;
	}
	
	//Modifier ou creer un abonne
	@Override
	public void save(Abonne abonne, String codepostal) {
		Ville ville = iVilleService.findByCodePostal(codepostal);
		abonne.setVille(ville);
		sessionFactory.getCurrentSession().saveOrUpdate(abonne);
		System.out.println(abonne.getVille().getCodepostal());
	}
}
