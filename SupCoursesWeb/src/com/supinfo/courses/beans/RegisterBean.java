package com.supinfo.courses.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.supinfo.courses.entity.User;
import com.supinfo.courses.interfaces.IUserDAO;
import com.supinfo.courses.session.SessionUtils;


@ManagedBean(name="registerBean")
@SessionScoped
public class RegisterBean {
	private User user;
	
	public RegisterBean() {
		this.user = new User();
	}
	
	@EJB
	private IUserDAO userDao;
	
	public void register(){
		userDao.createUser(user);
	}
	
	public String connect(){		//On récupère l'utilisateur en BDD
		User user_connected = userDao.getUser(user.getUsername(), user.getPassword());
		user = user_connected;
		
		if(user_connected != null){		//Si il est déjà présent ont le stocke en session 
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("user", user);
			
			return "homepage";
		}else{
			user = new User(); //Sinon on affiche un message d'erreur
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and/or Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}
	
	public String disconnect(){		//On se déconnecte en supprimant la session
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
