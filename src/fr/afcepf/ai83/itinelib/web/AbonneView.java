package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Categoriepermis;
import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Employe;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
*/

import fr.afcepf.ai83.itinelib.model.Ville;

public class AbonneView implements Serializable{

	/* Attributs Abonné */ 
	private Integer idabonne;

	private String nomabonne;
	private String prenomabonne;
	private String adresse;
	private String tel;
	private Date datenaissance;
	private String sexe;
	private String titulairecompte;
	private String codebanque;
	private String codeagence;
	private String numerocompte;
	private String clefrib;
	
	/* Attributs Utilisateur */ 
	private Integer idutilisateur;
	private String email;
	private String motdepassHash;
	private String motdepassSalt;
	private String role;
	
	/* Attributs Ville */
	private Integer idville;
	private String nomville;
	private String codepostal;
	
	/*Attribut type Abonnement*/
	private String typeAbo;
	private Integer typeAboId;
	
	/* Attribut Abonnement */
	private Date dhresiliation;
	
	
	public AbonneView() {
	}

	public AbonneView(Integer idabonne, String nomabonne, String prenomabonne,
			String adresse, String tel, Date datenaissance, String sexe,
			String titulairecompte, String codebanque, String codeagence,
			String numerocompte, String clefrib, Integer idutilisateur,
			String email, String motdepassHash, String motdepassSalt, String role,
			Integer idville, String nomville, String codepostal, String typeAbo, Integer typeAboId, Date dhresiliation) {
		this.idabonne = idabonne;
		this.nomabonne = nomabonne;
		this.prenomabonne = prenomabonne;
		this.adresse = adresse;
		this.tel = tel;
		this.datenaissance = datenaissance;
		this.sexe = sexe;
		this.titulairecompte = titulairecompte;
		this.codebanque = codebanque;
		this.codeagence = codeagence;
		this.numerocompte = numerocompte;
		this.clefrib = clefrib;
		this.idutilisateur = idutilisateur;
		this.email = email;
		this.motdepassHash = motdepassHash;
		this.motdepassSalt = motdepassSalt;
		this.role = role;
		this.idville = idville;
		this.nomville = nomville;
		this.codepostal = codepostal;
		this.typeAbo = typeAbo;
		this.typeAboId = typeAboId;
		this.dhresiliation = dhresiliation;
	}

	public String getTypeAbo() {
		return typeAbo;
	}

	public void setTypeAbo(String typeAbo) {
		this.typeAbo = typeAbo;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public Integer getIdville() {
		return idville;
	}

	public void setIdville(Integer idville) {
		this.idville = idville;
	}

	public String getNomville() {
		return nomville;
	}

	public void setNomville(String nomville) {
		this.nomville = nomville;
	}

	public Integer getIdabonne() {
		return idabonne;
	}

	public void setIdabonne(Integer idabonne) {
		this.idabonne = idabonne;
	}

	public String getNomabonne() {
		return nomabonne;
	}

	public void setNomabonne(String nomabonne) {
		this.nomabonne = nomabonne;
	}

	public String getPrenomabonne() {
		return prenomabonne;
	}

	public void setPrenomabonne(String prenomabonne) {
		this.prenomabonne = prenomabonne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTitulairecompte() {
		return titulairecompte;
	}

	public void setTitulairecompte(String titulairecompte) {
		this.titulairecompte = titulairecompte;
	}

	public String getCodebanque() {
		return codebanque;
	}

	public void setCodebanque(String codebanque) {
		this.codebanque = codebanque;
	}

	public String getCodeagence() {
		return codeagence;
	}

	public void setCodeagence(String codeagence) {
		this.codeagence = codeagence;
	}

	public String getNumerocompte() {
		return numerocompte;
	}

	public void setNumerocompte(String numerocompte) {
		this.numerocompte = numerocompte;
	}

	public String getClefrib() {
		return clefrib;
	}

	public void setClefrib(String clefrib) {
		this.clefrib = clefrib;
	}

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepassHash() {
		return motdepassHash;
	}

	public void setMotdepassHash(String motdepassHash) {
		this.motdepassHash = motdepassHash;
	}

	public String getMotdepassSalt() {
		return motdepassSalt;
	}

	public void setMotdepassSalt(String motdepassSalt) {
		this.motdepassSalt = motdepassSalt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Integer getTypeAboId() {
		return typeAboId;
	}

	public void setTypeAboId(Integer typeAboId) {
		this.typeAboId = typeAboId;
	}

	public Date getDhresiliation() {
		return dhresiliation;
	}

	public void setDhresiliation(Date dhresiliation) {
		this.dhresiliation = dhresiliation;
	}
	
}
