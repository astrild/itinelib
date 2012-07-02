package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IAbonneService;


@Component("adminAbonnesRechercheBean")
@Scope("session")
public class AdminAbonnesRechercheBean implements Serializable{
	
	private List<Abonne> abonneList;
	private List<AbonneView> abonneListView;
	private String prenom;



	@Autowired
	private transient IAbonneService iabonneservice;
	
	
	public void recherche() {
		abonneListView = new ArrayList<AbonneView>();
		abonneList = iabonneservice.findByPrenom(prenom);
	
		
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
			abonneListView.add(abonneView);
		}
	}

	/* Accessors */
	public List<Abonne> getAbonneList() {
		return abonneList;
	}


	public void setAbonneList(List<Abonne> abonneList) {
		this.abonneList = abonneList;
	}


	public List<AbonneView> getAbonneListView() {
		return abonneListView;
	}


	public void setAbonneListView(List<AbonneView> abonneListView) {
		this.abonneListView = abonneListView;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	

}
