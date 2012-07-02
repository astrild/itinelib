package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IAbonneService;


@Component("adminAbonnesShowBean")
@Scope("session")
public class AdminAbonnesShowBean implements Serializable {
	private AbonneView currentAbonneView;
	private Abonne currentAbonne;

	@Autowired
	private transient IAbonneService iabonneservice;
	
	//Pour retourner sur la page index
	public String retour() {
		return "index";
	}
	
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
		currentAbonneView.setCodepostal(currentAbonne.getVille().getCodepostal());
		for (Utilisateur util : currentAbonne.getUtilisateurs()) {
			currentAbonneView.setEmail(util.getEmail());
		}
		for (Abonnement abo : currentAbonne.getAbonnements()) {
			currentAbonneView.setTypeAbo(abo.getTypeabonnement().getNomabonnement());
			currentAbonneView.setTypeAboId(abo.getTypeabonnement().getIdtype());
		}
		return "detail";
	}
	
	

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
}
