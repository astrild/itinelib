package fr.afcepf.ai83.itinelib.web;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IUtilisateurService;

@Component("authBean")
@Scope("session")
public class AuthBean {
	
	private String email;
	private String password;
	private Utilisateur current;
	private String isAdmin;
	
	@Autowired
	private transient IUtilisateurService iUtilisateurService;
	
	
	public String login() {
        current = iUtilisateurService.find(email, password);
        System.out.println(current);
        System.out.println(current.getRole());
        String lien="";
        if (current == null) {
        	lien = "";
        } else {
        	if(current.getRole().equals("User")) {
        		lien =  "userHome";
        	} else if(current.getRole().equals("Administrateur")) {
        		lien = "adminHome";
        	}
        }
		System.out.println(lien);
        return lien;
    }

	public void setIsAdmin(String isAdmin){
		this.isAdmin = isAdmin;
	}

	public String getIsAdmin(){
		current = iUtilisateurService.find(email, password);
		String lien="";
		System.out.println(current.getRole());
		if(!current.getRole().equals("Administrateur")) {
			lien = "accessDenied";
		}
		return lien;
	}
	
//	public String logout() {
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        return "index?faces-redirect=true";
//    }

	
	/* Accessors */

	public boolean isLoggedIn() {
        return current != null;
    }
	
	public String getEmail() {
		return email;
	}

	public Utilisateur getCurrent() {
		return current;
	}

	public void setCurrent(Utilisateur current) {
		this.current = current;
	}

	public IUtilisateurService getiUtilisateurService() {
		return iUtilisateurService;
	}

	public void setiUtilisateurService(IUtilisateurService iUtilisateurService) {
		this.iUtilisateurService = iUtilisateurService;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
