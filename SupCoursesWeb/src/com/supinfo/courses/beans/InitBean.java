package com.supinfo.courses.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.supinfo.courses.interfaces.IDBDAO;

@ManagedBean(name="initBean")
@RequestScoped
public class InitBean {
	@EJB
	IDBDAO dbdao;
	
	public String initDB(){
		dbdao.initDB();
		return "true";
	}
}
