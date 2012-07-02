package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Registre;
import fr.afcepf.ai83.itinelib.model.Resaglobale;
import fr.afcepf.ai83.itinelib.service.IResaGlobaleService;


@Component("adminResaGlobaleIndexBean")
@Scope("session")
public class AdminResaGlobaleIndexBean implements Serializable {
	
	
	private List<ReservationView> reservationsListView;
	private List<Resaglobale> resaGlobaleList;
	
	
	@Autowired
	private transient IResaGlobaleService resaGlobaleService;
	
	
	//METHODS
	@PostConstruct
	public void init() {
		reservationsListView = new ArrayList<ReservationView>();
		resaGlobaleList = resaGlobaleService.findAll();
		
		
		for(Resaglobale rg : resaGlobaleList) {
			ReservationView resaView = new ReservationView();
			
			// on remplit la résa globale courante
			// récupération de l'identifiant de la réservation globale
			resaView.setIdresaglobale(rg.getIdresaglobale());
			
			// préparation du registre pour récupérer ce que je veux
			Set<Registre> li = rg.getRegistres();
			Registre premierRegistre = (Registre) li.toArray()[0];
			
			// récupération du nom de la station de départ de la réservation (donc du premier registre)
			resaView.setNompointlocation( premierRegistre.getPointlocationByIdpointlocation().getNompointlocation() );
			//récupération de la date et de l'heure prévues de la réservation
			resaView.setDhreservationprevue( premierRegistre.getDhreservationprevue() );
			
			// préparation de l'abonné
			// récupération de l'identifiant de l'abonné
			resaView.setIdabonne( rg.getAbonnement().getAbonne().getIdabonne() );
			// récupération du nom de l'abonné
			resaView.setNomabonne( rg.getAbonnement().getAbonne().getNomabonne() );
			// récupération du prénom de l'abonné
			resaView.setPrenomabonne( rg.getAbonnement().getAbonne().getPrenomabonne() );
			
			
			reservationsListView.add(resaView);
		}
	}
	
	
	
	//GETTERS & SETTERS
	public List<ReservationView> getReservationsListView() {
		return reservationsListView;
	}

	public void setReservationsListView(List<ReservationView> reservationsListView) {
		this.reservationsListView = reservationsListView;
	}

	public List<Resaglobale> getResaGlobaleList() {
		return resaGlobaleList;
	}

	public void setResaGlobaleList(List<Resaglobale> resaGlobaleList) {
		this.resaGlobaleList = resaGlobaleList;
	}

	public IResaGlobaleService getResaGlobaleService() {
		return resaGlobaleService;
	}

	public void setResaGlobaleService(IResaGlobaleService resaGlobaleService) {
		this.resaGlobaleService = resaGlobaleService;
	}

	
	
	
	
	
}
