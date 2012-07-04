package fr.afcepf.ai83.itinelib.web;

import java.util.Enumeration;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


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
	private boolean admin;
	
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
        		admin = false;
        		lien =  "userHome";
        	} else if(current.getRole().equals("Administrateur")) {
        		admin = true;
        		lien = "adminHome";
        	}
        }
		System.out.println(lien);
		System.out.println(admin);
        return lien;
    }
	
	public String logout(){
		HttpServletRequest request =
			(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		for(Enumeration en = request.getSession().getAttributeNames();en.hasMoreElements();){
			request.getSession().setAttribute(en.nextElement().toString(), null);
		}
		this.current = null;
		return "login";
	}

	
	/* Accessors */

	public boolean isLoggedIn() {
        return current != null;
    }
	
	public boolean isAdmin() {
		System.out.println("##################################################");
		System.out.println("COUCOU");
//		System.out.println(current);
//		System.out.println(current.getRole());
		System.out.println("##################################################");
		if(current!=null && current.getRole().equals("Administrateur")) {
			admin = true;
		} else {
			admin = false;
		}
		System.out.println(admin);
		System.out.println("##################################################");
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
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

