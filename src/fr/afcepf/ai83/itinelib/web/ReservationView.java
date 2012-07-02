package fr.afcepf.ai83.itinelib.web;

import java.util.Date;

public class ReservationView {
	
	// Attributs résa globale
	private Integer idresaglobale;
	
	// Attributs registre
	private Date dhreservationprevue;
	
	// Attributs abonné
	private Integer idabonne;
	private String nomabonne;
	private String prenomabonne;
	
	// Attributs point de location
	private String nompointlocation;

	
	//CONSTRUCTORS
	public ReservationView() {
		
	}
	
	public ReservationView(Integer idresaglobale, Date dhreservationprevue,
			Integer idabonne, String nomabonne, String prenomabonne,
			String nompointlocation) {
		super();
		this.idresaglobale = idresaglobale;
		this.dhreservationprevue = dhreservationprevue;
		this.idabonne = idabonne;
		this.nomabonne = nomabonne;
		this.prenomabonne = prenomabonne;
		this.nompointlocation = nompointlocation;
	}
	
	
	
	//GETTERS & SETTERS
	public Integer getIdresaglobale() {
		return idresaglobale;
	}

	public void setIdresaglobale(Integer idresaglobale) {
		this.idresaglobale = idresaglobale;
	}

	public Date getDhreservationprevue() {
		return dhreservationprevue;
	}

	public void setDhreservationprevue(Date dhreservationprevue) {
		this.dhreservationprevue = dhreservationprevue;
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

	public String getNompointlocation() {
		return nompointlocation;
	}

	public void setNompointlocation(String nompointlocation) {
		this.nompointlocation = nompointlocation;
	}

	
	
	
	
	
	
}
