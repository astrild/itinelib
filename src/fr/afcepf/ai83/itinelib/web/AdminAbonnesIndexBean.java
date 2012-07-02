package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IAbonneService;
import fr.afcepf.ai83.itinelib.service.IAbonnementService;


@Component("adminAbonnesIndexBean")
@Scope("session")
public class AdminAbonnesIndexBean implements Serializable {
	private List<Abonne> abonneList;
	private List<AbonneView> abonneListView;
	
	private String id;



	private String prenom;
	private String nom;
	private String email;
	private String telephone;
	
	@Autowired
	private transient IAbonneService iabonneservice;
	
	@Autowired
	private transient IAbonnementService iabonnementservice;
	
	@PostConstruct
	public void init() {
		abonneListView = new ArrayList<AbonneView>();
		abonneList = iabonneservice.findAll();
	
		createAbonneView();
	}

	@PostConstruct
	public String recherche() {
		if(id != "" && nom == "" && prenom == "" && email == "" && telephone == "" ) {
			abonneListView = new ArrayList<AbonneView>();
			abonneList = (List<Abonne>) iabonneservice.findByIdInList(Integer.parseInt(id));
			
			createAbonneView();
			clearSearchForm();
		} else if (id == "" && nom != "" && prenom == "" && email == "" && telephone == "" ) {
			abonneListView = new ArrayList<AbonneView>();
			abonneList = (List<Abonne>) iabonneservice.findByNom(nom);
			
			createAbonneView();
			clearSearchForm();
		} else if (id == "" && nom == "" && prenom != "" && email == "" && telephone == "" ) {
			abonneListView = new ArrayList<AbonneView>();
			abonneList = (List<Abonne>) iabonneservice.findByPrenom(prenom);
			
			createAbonneView();
			clearSearchForm(); 
		} 
		else if (id == "" && nom == "" && prenom == "" && email != "" && telephone == "" ) {
			abonneListView = new ArrayList<AbonneView>();
			abonneList = (List<Abonne>) iabonneservice.findByEmail(email);
			
			createAbonneView();
			clearSearchForm();
		} 
		else if (id == "" && nom == "" && prenom == "" && email == "" && telephone != "" ) {
			abonneListView = new ArrayList<AbonneView>();
			abonneList = (List<Abonne>) iabonneservice.findByTelephone(telephone);
			
			createAbonneView();
			clearSearchForm();
		} 
		else if (id == "" && nom == "" && prenom == "" && email == "" && telephone == "" ) {
			init();
		}
		return "recherche";
	}

	public void clearSearchForm() {
		id = "";
		prenom = "";
		nom = "";
		email = "";
		telephone = "";		
	}
	
	public void createAbonneView() {
		for (Abonne abo : abonneList) {
			AbonneView abonneView = new AbonneView();
			abonneView.setIdabonne(abo.getIdabonne());
			abonneView.setNomabonne(abo.getNomabonne());
			abonneView.setPrenomabonne(abo.getPrenomabonne());
			abonneView.setAdresse(abo.getAdresse());
			abonneView.setTel(abo.getTel());
			abonneView.setDatenaissance(abo.getDatenaissance());
			abonneView.setSexe(abo.getSexe());
			abonneView.setTitulairecompte(abo.getTitulairecompte());
			abonneView.setCodebanque(abo.getCodebanque());
			abonneView.setCodeagence(abo.getCodeagence());
			abonneView.setNumerocompte(abo.getNumerocompte());
			abonneView.setClefrib(abo.getClefrib());
			abonneView.setIdville(abo.getVille().getIdville());
			abonneView.setNomville(abo.getVille().getNomville());
			abonneView.setCodepostal(abo.getVille().getCodepostal());
			
			for (Utilisateur util : abo.getUtilisateurs()) {
				abonneView.setEmail(util.getEmail());
			}
			
			for (Abonnement ab : abo.getAbonnements()) {
				abonneView.setDhresiliation(ab.getDhresiliation());  
			}
			abonneListView.add(abonneView);
		}
	}

	public String resilier(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		Integer idAbo = Integer.parseInt(map.get("idAbo"));
		Abonne currentAbonne = iabonneservice.findById(idAbo);
		Abonnement currentAbonnement =iabonnementservice.findByAbonne(currentAbonne);
		System.out.println(currentAbonnement);
		iabonnementservice.resilier(currentAbonnement);
		init();
		return "resilier";
	}
	
	/* Accessors */
	
	public void setAbonneListView(List<AbonneView> abonneListView) {
		this.abonneListView = abonneListView;
	}

	public String getId() {
		return id;
	}

	public List<Abonne> getAbonneList() {
		return abonneList;
	}

	public void setAbonneList(List<Abonne> abonneList) {
		this.abonneList = abonneList;
	}

	public List<AbonneView> getAbonneListView() {
		return abonneListView;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public void setId(String id) {
		this.id = id;
	}

	public IAbonneService getIabonneservice() {
		return iabonneservice;
	}

	public void setIabonneservice(IAbonneService iabonneservice) {
		this.iabonneservice = iabonneservice;
	}

	public IAbonnementService getIabonnementservice() {
		return iabonnementservice;
	}

	public void setIabonnementservice(IAbonnementService iabonnementservice) {
		this.iabonnementservice = iabonnementservice;
	}
	
}
