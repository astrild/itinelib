package fr.afcepf.ai83.itinelib.web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Utilisateur;

@Component("userProfilMyAccountBean")
@Scope("session")
public class UserProfilMyAccountBean {
	
	private Utilisateur currentUser ;
	private Abonne currentAbonne ;
	private AbonneView currentAbonneView;
	private String password;
	private String passewordConfirm;


	@PostConstruct
	public void init(){
		
		//Recupere les info du user a partir du bean d'authetification
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		AuthBean authBean = (AuthBean)request.getSession().getAttribute("authBean");
		//Set l'utilisateur et l'abonne courrant
		currentUser = authBean.getCurrent();
		currentAbonne = authBean.getCurrent().getAbonne();
		
		
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
		currentAbonneView.setCodepostal(currentAbonne.getVille().getCodepostal());
		currentAbonneView.setEmail(currentUser.getEmail());
		currentAbonneView.setMotdepassHash(currentUser.getMotdepassHash());
		currentAbonneView.setMotdepassSalt(currentUser.getMotdepassSalt());
		
		if (currentAbonneView.getMotdepassHash().equals(currentAbonneView.getMotdepassSalt())){
			password = currentAbonneView.getMotdepassHash();
		}	
		
		for (Abonnement abo : currentAbonne.getAbonnements()) {
			currentAbonneView.setTypeAbo(abo.getTypeabonnement().getNomabonnement());
			currentAbonneView.setTypeAboId(abo.getTypeabonnement().getIdtype());
		}
		

		
		
	}

	
	/*Accessor*/
	
	public AbonneView getCurrentAbonneView() {
		return currentAbonneView;
	}
	public void setCurrentAbonneView(AbonneView currentAbonneView) {
		this.currentAbonneView = currentAbonneView;
	}
	public Utilisateur getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(Utilisateur currentUser) {
		this.currentUser = currentUser;
	}
	public Abonne getCurrentAbonne() {
		return currentAbonne;
	}
	public void setCurrentAbonne(Abonne currentAbonne) {
		this.currentAbonne = currentAbonne;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassewordConfirm() {
		return passewordConfirm;
	}

	public void setPassewordConfirm(String passewordConfirm) {
		this.passewordConfirm = passewordConfirm;
	}
	
	
	
}
