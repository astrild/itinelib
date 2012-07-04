
package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.corba.se.impl.orb.ParserTable.TestContactInfoListFactory;

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
public class AdminAbonneUpdateBean implements Serializable {

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

	//Attribut message d'erreur
	private String erreurNomAbonne;
	private String erreurPrenomAbonne;
	private String erreurAdresse;
	private String erreurCodePostal;
	private String erreurTelephone;
	private String erreurMail;
	private String erreurTitulaireCompte;
	private String erreurCodeBanque;
	private String erreurCodeAgence;
	private String erreirNumeroCompte;
	private String erreurCleRib;
	private String erreurPassword;



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
	@PostLoad
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
		Boolean validation = true;


		/*String expression reguliere pour validation*/

		String regexNomAbonne = "^[a-zA-Z]{2,50}$";
		String regexPrenomAbonne = "^[a-zA-Z]{2,50}$";
		String regexDtNaissanceAbonne = "^[1-9]{2}+/s+[a-zA-Z_0-9]{1,5}+/s[1-9]{4}+/s";
		String regexAdresseAbonne = "^[a-zA-Z0-9 . - _ , ; ]{2,200}$";
		String regexCodePostal = "^[0-9]{5}$";
		String regexTelephoneAbonne = "^[0-9 -]{10,50}$";
		String regexTitulaireCompte = "^[a-zA-Z ]{2,50}$";
		String regexMailAbonne = "^[A-Za-z0-9 . - _]+@[a-z0-9 . - _]{2,}[a-z]{2,4}$";
		String regexPasswordAbonne = "^[a-zA-Z&0-9]{2,100}$";
		String regexCodeBanque = "^[0-9]{2,30}$";
		String regexCodeAgence = "^[0-9]{2,30}$";
		String regexNumeroCompte = "^[0-9]{2,30}$";
		String regexCleRib= "^[0-9]{2,30}$";

		/*String chaine de donnée à tester*/
		String testNomAbonne=currentAbonneView.getNomabonne();
		String testPrenomAbonne=currentAbonneView.getPrenomabonne();
		String testDatenaissance = currentAbonneView.getDatenaissance().toLocaleString();
		String testAdresse = currentAbonneView.getAdresse();
		String testCodePostale = codepostal;
		String testTelephone = currentAbonneView.getTel();
		String testMail = currentAbonneView.getEmail();
		String testTitulaireCompte = currentAbonneView.getTitulairecompte();
		String testCodeBanque = currentAbonneView.getCodebanque();
		String testCodeAgence = currentAbonneView.getCodeagence();
		String testNumeroCompte = currentAbonneView.getNumerocompte();
		String testCleRib = currentAbonneView.getClefrib();
		String testPassword = Password;

		System.out.println(testDatenaissance);
		System.out.println("test Nom "+testNomAbonne.matches(regexNomAbonne));
		System.out.println("test Prenom "+testPrenomAbonne.matches(regexPrenomAbonne));
		System.out.println("test DTnaissance "+testDatenaissance.matches(regexDtNaissanceAbonne));
		System.out.println("test Adresse "+testAdresse.matches(regexAdresseAbonne));
		System.out.println("test codepostal "+testCodePostale.matches(regexCodePostal));
		System.out.println("test Telephone "+testTelephone.matches(regexTelephoneAbonne));
		System.out.println("test Email "+testMail.matches(regexMailAbonne));
		System.out.println("test titulaire "+testTitulaireCompte.matches(regexTitulaireCompte));
		System.out.println("test CBanque "+testCodeBanque.matches(regexCodeBanque));
		System.out.println("test CAgence "+testCodeAgence.matches(regexCodeAgence));
		System.out.println("test numCompte" + testNumeroCompte.matches(regexNumeroCompte));
		System.out.println("test clerib "+testCleRib.matches(regexCleRib));
		System.out.println("test pass "+testPassword.matches(regexPasswordAbonne));

		System.out.println("validation1 " + validation);
		
		if (testNomAbonne.matches(regexNomAbonne)== false || testPrenomAbonne.matches(regexPrenomAbonne)==false
				||testAdresse.matches(regexAdresseAbonne)==false || testCodePostale.matches(regexCodePostal)== false
				||testTelephone.matches(regexTelephoneAbonne)==false || testMail.matches(regexMailAbonne)==false
				||testTitulaireCompte.matches(regexTitulaireCompte)==false || testCodeBanque.matches(regexCodeBanque)==false
				||testCodeAgence.matches(regexCodeAgence)==false || testNumeroCompte.matches(regexNumeroCompte)==false 
				||testCleRib.matches(regexCleRib)==false || testPassword.matches(regexPasswordAbonne)==false)
		{
			validation = false;
			System.out.println("validation2 " + validation);
		}
		else
		{
			validation = true;
			System.out.println("validation3 " + validation);
		}
		if(validation==true){
			System.out.println("in true");
			erreurNomAbonne = "";
			erreurPrenomAbonne = "";
			erreurAdresse = "";
			erreurCodePostal = "";
			erreurTelephone = "";
			erreurMail = "";
			erreurTitulaireCompte = "";
			erreurCodeBanque = "";
			erreurCodeAgence = "";
			erreirNumeroCompte = "";
			erreurCleRib = "";
			erreurPassword = "";

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
			System.out.println("validation5 " + validation);
			return "index";
			
		}
		else  {

			if(testNomAbonne.matches(regexNomAbonne)== false){
				erreurNomAbonne = "il y a une erreur dans le nom";
			}
			if(testPrenomAbonne.matches(regexPrenomAbonne)==false){
				erreurPrenomAbonne="il y a une erreur dans le prenom";
			}
			if(testAdresse.matches(regexAdresseAbonne)==false ){
				erreurAdresse="il y a une erreur dans l'adresse";
			}
			if(testCodePostale.matches(regexCodePostal)==false ){
				erreurCodePostal="il y a une erreur dans le code postal";
			}
			if(testTelephone.matches(regexTelephoneAbonne)==false ){
				erreurTelephone="il y a une erreur dans le numéro de telephone";
			}
			if(testMail.matches(regexMailAbonne)==false ){
				erreurMail="il y a une erreur dans l'adresse mail";
			}
			if(testTitulaireCompte.matches(regexTitulaireCompte)==false ){
				erreurTitulaireCompte="il y a une erreur dans le nom du titulaire du compte";
			}
			if(testCodeBanque.matches(regexCodeBanque)==false){
				erreurCodeBanque="il y a une erreur dans le code banque";
			}
			if(testCodeAgence.matches(regexCodeAgence)==false){
				erreurCodeAgence="il y a une erreur dans le code Agence";
			}
			if(testNumeroCompte.matches(regexNumeroCompte)==false ){
				erreirNumeroCompte="il y a une erreur dans le numero de compte";
			}
			if(testCleRib.matches(regexCleRib)==false){
				erreurCleRib="il y a une erreur dans la cle RIB";
			}
			if(testPassword.matches(regexPasswordAbonne)==false){
				erreurPassword="il y a une erreur dans le mot de passe n'utiliser que des caracteres alphanumériques";
			}
			System.out.println("validation6 " + validation);
			return "erreurDonne";
		}


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
	public String getErreurNom() {
		return erreurNomAbonne;
	}

	public void setErreurNom(String erreurNom) {
		this.erreurNomAbonne = erreurNom;
	}

	public void setIdabonnement(Integer idabonnement) {
		this.idabonnement = idabonnement;
	}
	public String getErreurNomAbonne() {
		return erreurNomAbonne;
	}

	public void setErreurNomAbonne(String erreurNomAbonne) {
		this.erreurNomAbonne = erreurNomAbonne;
	}

	public String getErreurPrenomAbonne() {
		return erreurPrenomAbonne;
	}

	public void setErreurPrenomAbonne(String erreurPrenomAbonne) {
		this.erreurPrenomAbonne = erreurPrenomAbonne;
	}

	public String getErreurAdresse() {
		return erreurAdresse;
	}

	public void setErreurAdresse(String erreurAdresse) {
		this.erreurAdresse = erreurAdresse;
	}

	public String getErreurCodePostal() {
		return erreurCodePostal;
	}

	public void setErreurCodePostal(String erreurCodePostal) {
		this.erreurCodePostal = erreurCodePostal;
	}

	public String getErreurTelephone() {
		return erreurTelephone;
	}

	public void setErreurTelephone(String erreurTelephone) {
		this.erreurTelephone = erreurTelephone;
	}

	public String getErreurMail() {
		return erreurMail;
	}

	public void setErreurMail(String erreurMail) {
		this.erreurMail = erreurMail;
	}

	public String getErreurTitulaireCompte() {
		return erreurTitulaireCompte;
	}

	public void setErreurTitulaireCompte(String erreurTitulaireCompte) {
		this.erreurTitulaireCompte = erreurTitulaireCompte;
	}

	public String getErreurCodeBanque() {
		return erreurCodeBanque;
	}

	public void setErreurCodeBanque(String erreurCodeBanque) {
		this.erreurCodeBanque = erreurCodeBanque;
	}

	public String getErreurCodeAgence() {
		return erreurCodeAgence;
	}

	public void setErreurCodeAgence(String erreurCodeAgence) {
		this.erreurCodeAgence = erreurCodeAgence;
	}

	public String getErreirNumeroCompte() {
		return erreirNumeroCompte;
	}

	public void setErreirNumeroCompte(String erreirNumeroCompte) {
		this.erreirNumeroCompte = erreirNumeroCompte;
	}

	public String getErreurCleRib() {
		return erreurCleRib;
	}

	public void setErreurCleRib(String erreurCleRib) {
		this.erreurCleRib = erreurCleRib;
	}

	public String getErreurPassword() {
		return erreurPassword;
	}

	public void setErreurPassword(String erreurPassword) {
		this.erreurPassword = erreurPassword;
	}


}


