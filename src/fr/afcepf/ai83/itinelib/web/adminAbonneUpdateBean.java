
package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

@Component("adminAbonnesUpdateBean")
@Scope("session")
public class adminAbonneUpdateBean implements Serializable {
	
	private AbonneView currentAbonneView;
	private Abonne currentAbonne;

	private Utilisateur currentUtilisateur=new Utilisateur();
	private Abonnement currentAbonnement = new Abonnement();
	private Typeabonnement typeAbo;
	private List<SelectItem> listeTypeAboItems = new ArrayList<SelectItem>();
	private List<Typeabonnement> listeTypeAbo;
	private Integer idabonnement;
	private String codepostal;
	private String Password;
	


	@Autowired
	private transient ITypeAbonnementService iTypeAbonnementService;
	
	@Autowired
	private transient IVilleService iVilleService;
	
	@Autowired
	private transient IUtilisateurService iUtilisateurService;

	@Autowired
	private transient IAbonnementService iAbonnementService;
	
	@Autowired
	private transient IAbonneService iabonneservice;
	

	//Pour retourner sur la page index
	public String retour() {
		System.out.println("retour");
		return "index";
	}
	
	//montrer les informations de l'abonné selectionné
	public String viewDetail() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		Integer idAbo = Integer.parseInt(map.get("idAbo")); 
		Abonne currentAbonne = iabonneservice.findById(idAbo);
		currentAbonneView = new AbonneView();
		currentAbonneView.setIdabonne(currentAbonne.getIdabonne());
		currentAbonneView.setNomabonne(currentAbonne.getNomabonne());
		currentAbonneView.setPrenomabonne(currentAbonne.getPrenomabonne());
		currentAbonneView.setAdresse(currentAbonne.getAdresse());
		currentAbonneView.setTel(currentAbonne.getTel());
		currentAbonneView.setDatenaissance(currentAbonne.getDatenaissance());
		currentAbonneView.setSexe(currentAbonne.getSexe());
		currentAbonneView.setTitulairecompte(currentAbonne.getTitulairecompte());
		currentAbonneView.setCodebanque(currentAbonne.getCodebanque());
		currentAbonneView.setCodeagence(currentAbonne.getCodeagence());
		currentAbonneView.setNumerocompte(currentAbonne.getNumerocompte());
		currentAbonneView.setClefrib(currentAbonne.getClefrib());
		currentAbonneView.setIdville(currentAbonne.getVille().getIdville());
		currentAbonneView.setNomville(currentAbonne.getVille().getNomville());
		codepostal = currentAbonne.getVille().getCodepostal();
		currentAbonneView.setCodepostal(codepostal);
		
		for (Utilisateur util : currentAbonne.getUtilisateurs()) {
			currentAbonneView.setEmail(util.getEmail());
		}
		for (Utilisateur util : currentAbonne.getUtilisateurs()) {
			Password = util.getMotdepassHash();
		}
		for (Abonnement abo : currentAbonne.getAbonnements()) {
			currentAbonneView.setTypeAbo(abo.getTypeabonnement().getNomabonnement());
			currentAbonneView.setTypeAboId(abo.getTypeabonnement().getIdtype());
			idabonnement=currentAbonneView.getTypeAboId();
			System.out.println(idabonnement+"idab");
		}
		idabonnement=currentAbonneView.getTypeAboId();
		
		
		return "modifier";
	
	}
	
	
	public String update() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		Integer idAbo = Integer.parseInt(map.get("idAbo"));
		String PrenomAbo = map.get("prenomAbo");
		
		System.out.println(currentAbonneView.getPrenomabonne());
		System.out.println(iabonneservice);
		
		Abonne currentAbonne = iabonneservice.findById(idAbo);
		currentAbonne.setSexe(currentAbonneView.getSexe());
		currentAbonne.setNomabonne(currentAbonneView.getNomabonne());
		currentAbonne.setPrenomabonne(currentAbonneView.getPrenomabonne());
		currentAbonne.setDatenaissance(currentAbonneView.getDatenaissance());
		currentAbonne.setAdresse(currentAbonneView.getAdresse());
		currentAbonne.setTel(currentAbonneView.getTel());
		currentAbonne.setTitulairecompte(currentAbonneView.getTitulairecompte());
		currentAbonne.setCodebanque(currentAbonneView.getCodebanque());
		currentAbonne.setCodeagence(currentAbonneView.getCodeagence());
		currentAbonne.setNumerocompte(currentAbonneView.getNumerocompte());
		currentAbonne.setClefrib(currentAbonneView.getClefrib());
		codepostal = currentAbonneView.getCodepostal();
		
		Utilisateur currentUtilisateur = iUtilisateurService.findByIdAbonne(currentAbonne);
		System.out.println(currentUtilisateur);
		currentUtilisateur.setEmail(currentAbonneView.getEmail());
		
		System.out.println(currentAbonne.getIdabonne());
		System.out.println(Password);
		
	
		Abonnement currentAbonnement =iAbonnementService.findByAbonne(currentAbonne);
		System.out.println(currentAbonne);
		System.out.println(idabonnement);
		System.out.println(currentAbonnement+" current abonnement");
		
		
		iabonneservice.save(currentAbonne, codepostal);
		iUtilisateurService.update(currentUtilisateur, Password);
		iAbonnementService.update(currentAbonnement, idabonnement);
		
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
	
	public AbonneView getCurrentAbonneView() {
		return currentAbonneView;
	}

	public void setCurrentAbonneView(AbonneView currentAbonneView) {
		this.currentAbonneView = currentAbonneView;
	}

	public Abonne getCurrentAbonne() {
		return currentAbonne;
	}

	public void setCurrentAbonne(Abonne currentAbonne) {
		this.currentAbonne = currentAbonne;
	}
	
	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
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
		return Password;
	}


	public void setPassword(String password) {
		this.Password = password;
	}
	
	public Abonnement getCurrentAbonnement() {
		return currentAbonnement;
	}


	public void setCurrentAbonnement(Abonnement currentAbonnement) {
		this.currentAbonnement = currentAbonnement;
	}

	public IVilleService getiVilleService() {
		return iVilleService;
	}

	public void setiVilleService(IVilleService iVilleService) {
		this.iVilleService = iVilleService;
	}

	public IUtilisateurService getiUtilisateurService() {
		return iUtilisateurService;
	}

	public void setiUtilisateurService(IUtilisateurService iUtilisateurService) {
		this.iUtilisateurService = iUtilisateurService;
	}

	public IAbonnementService getiAbonnementService() {
		return iAbonnementService;
	}

	public void setiAbonnementService(IAbonnementService iAbonnementService) {
		this.iAbonnementService = iAbonnementService;
	}

}


