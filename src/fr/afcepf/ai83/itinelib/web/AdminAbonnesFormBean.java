package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Typeabonnement;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IAbonneService;
import fr.afcepf.ai83.itinelib.service.IAbonnementService;
import fr.afcepf.ai83.itinelib.service.ITypeAbonnementService;
import fr.afcepf.ai83.itinelib.service.IUtilisateurService;
import fr.afcepf.ai83.itinelib.service.IVilleService;

@Component("adminAbonnesFormBean")
@Scope("session")
public class AdminAbonnesFormBean implements Serializable {
	private Abonne currentAbonne = new Abonne();
	private Utilisateur currentUtilisateur=new Utilisateur();
	private Abonnement currentAbonnement = new Abonnement();
	private Typeabonnement typeAbo;
	private List<SelectItem> listeTypeAboItems = new ArrayList<SelectItem>();
	private List<Typeabonnement> listeTypeAbo;
	private int idabonnement;
	private String codepostal;
	private String password;
	


	@Autowired
	private transient IAbonneService iabonneservice;

	@Autowired
	private transient ITypeAbonnementService iTypeAbonnementService;
	
	@Autowired
	private transient IVilleService iVilleService;
	
	@Autowired
	private transient IUtilisateurService iUtilisateurService;

	@Autowired
	private transient IAbonnementService iAbonnementService;
	
	//Pour retourner sur la page index
	public String retour() {
		System.out.println("retour");
		return "index";
	}
	
	public String viewNew() {
		currentAbonne = new Abonne();
		return "new";
	}
	
	
	public String update() {
		iabonneservice.save(currentAbonne, codepostal);
		iUtilisateurService.saveAbonne(currentUtilisateur, currentAbonne.getIdabonne(), password);
		iAbonnementService.save(currentAbonnement, currentAbonne, idabonnement);
		
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			AdminAbonnesIndexBean indexBean = (AdminAbonnesIndexBean)request.getSession().getAttribute("adminAbonnesIndexBean");
			indexBean.init();
		}catch (Exception e){
			e.printStackTrace();
		}
		return "index";
	}

	
	//Accessor
	
	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public Abonne getCurrentAbonne() {
		return currentAbonne;
	}

	public void setCurrentAbonne(Abonne currentAbonne) {
		this.currentAbonne = currentAbonne;
	}
	
	public IAbonneService getIabonneservice() {
		return iabonneservice;
	}

	public void setIabonneservice(IAbonneService iabonneservice) {
		this.iabonneservice = iabonneservice;
	}

	public ITypeAbonnementService getiTypeAbonnementService() {
		return iTypeAbonnementService;
	}

	public void setiTypeAbonnementService(
		ITypeAbonnementService iTypeAbonnementService) {
		this.iTypeAbonnementService = iTypeAbonnementService;
	}

	public Typeabonnement getTypeAbo() {
		return typeAbo;
	}

	public void setTypeAbo(Typeabonnement typeAbo) {
		this.typeAbo = typeAbo;
	}

	public List<SelectItem> getListeTypeAboItems() {
		return listeTypeAboItems;
	}

	public void setListeTypeAboItems(List<SelectItem> listeTypeAboItems) {
		this.listeTypeAboItems = listeTypeAboItems;
	}

	public List<Typeabonnement> getListeTypeAbo() {
		return listeTypeAbo;
	}

	public void setListeTypeAbo(List<Typeabonnement> listeTypeAbo) {
		this.listeTypeAbo = listeTypeAbo;
	}

	public int getIdabonnement() {
		return idabonnement;
	}


	public void setIdabonnement(int idabonnement) {
		this.idabonnement = idabonnement;
	}


	@PostConstruct
	public List<SelectItem> getListeVilleItems() {
		listeTypeAbo = iTypeAbonnementService.findAll();
		listeTypeAboItems = new ArrayList<SelectItem>();
		for (Typeabonnement ta : listeTypeAbo) {
			SelectItem si = new SelectItem(ta.getIdtype(), ta.getNomabonnement());
			listeTypeAboItems.add(si);
		}
		return listeTypeAboItems;
	}
	
	public Utilisateur getCurrentUtilisateur() {
		return currentUtilisateur;
	}


	public void setCurrentUtilisateur(Utilisateur currentUtilisateur) {
		this.currentUtilisateur = currentUtilisateur;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public Abonnement getCurrentAbonnement() {
		return currentAbonnement;
	}


	public void setCurrentAbonnement(Abonnement currentAbonnement) {
		this.currentAbonnement = currentAbonnement;
	}

}
