package fr.afcepf.ai83.itinelib.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Pointlocation;
import fr.afcepf.ai83.itinelib.service.IPointLocationService;

@Component("mapPointLocationBean")
@Scope("session")
public class MapPointLocationBean {

	private Pointlocation station;
	private List<Pointlocation> listPointLocation;
	private List<MapView> mapliste = new ArrayList<MapView>();


	private String latitude;
	private String longitude;
	private Integer idStation;

	@Autowired
	private IPointLocationService ipointLocationService;

	@PostConstruct
	public void listeStation() {

		listPointLocation = ipointLocationService.findAll();
		System.out.println(listPointLocation);
		for (Pointlocation station : listPointLocation) {
			latitude = String.valueOf(station.getLattitude());
			longitude = String.valueOf(station.getLongitude());
			MapView mv = new MapView(latitude, longitude);
			System.out.println(mv);
			mapliste.add(mv);
			
		}
		System.out.println(mapliste);
	}

	/* Accessor */




	public List<Pointlocation> getListPointLocation() {
		return listPointLocation;
	}

	public List<MapView> getMapliste() {
		return mapliste;
	}

	public void setMapliste(List<MapView> mapliste) {
		this.mapliste = mapliste;
	}

	public void setListPointLocation(List<Pointlocation> listPointLocation) {
		this.listPointLocation = listPointLocation;
	}

	public IPointLocationService getIpointLocationService() {
		return ipointLocationService;
	}

	public void setIpointLocationService(
			IPointLocationService ipointLocationService) {
		this.ipointLocationService = ipointLocationService;
	}


	public Integer getIdStation() {
		return idStation;
	}

	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}

	public Pointlocation getStation() {
		return station;
	}

	public void setStation(Pointlocation station) {
		this.station = station;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}