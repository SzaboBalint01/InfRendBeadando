package ait.szabo128.bead.businessLogic;

import java.util.ArrayList;
import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

import ait.szabo128.bead.entity.*;

import ait.szabo128.bead.dao.KolcsonzoDAO;

@ManagedBean(name="UgyfelBean")
@ApplicationScoped
public class UgyfelBean {
	 private KolcsonzoDAO kolcsonzoDAO;
	 private String nev;
	 @Size(max=45)
	 private String ujnev;
	 private String ujszemelyiszam;
	 private String ujszulido;
	 @Size(max=45)
	 private String ujszulhely;
	 @Size(max=80)
	 private String ujcim;
	 private String ujtelefon;
	 @Size(max=45)
	 private String ujceg;
	 
	 public UgyfelBean() { }
	 
	 @PostConstruct
	  public void init() {
		 kolcsonzoDAO = new KolcsonzoDAO();
	    }
	 
	 public ArrayList<UgyfelEntity> listUgyfel() {
	        return kolcsonzoDAO.fetchUgyfel();
	    }
	 public ArrayList<UgyfelEntity> searchUgyfelnev(String nev){
		 return kolcsonzoDAO.filterUgyfelbynev(nev);
	 }
	 
	 public void addUgyfel(String ujszemelyiszam, String  ujnev, String ujszulido, String ujszulhely, String ujcim, String ujtelefon, String ujceg ) {
			 kolcsonzoDAO.insertUgyfel(ujszemelyiszam, ujnev, ujszulido, ujszulhely, ujcim, ujtelefon, ujceg);
			 FacesContext context = FacesContext.getCurrentInstance();
			 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sikeres felvétel!", "Felvett ügyfél:" +ujnev) );
			 this.ujnev=null;
			 this.ujszemelyiszam=null;
			 this.ujszulido=null;
			 this.ujszulhely=null;
			 this.ujcim=null;
			 this.ujtelefon=null;
			 this.ujceg=null; 
	 }
	 
	 
	 public void setNev(String nev) {
	        this.nev = nev;
	    }
	 public String getNev() {
	        return nev;
	    }

	public String getUjnev() {
		return ujnev;
	}

	public void setUjnev(String ujnev) {
		this.ujnev = ujnev;
	}

	public String getUjszemelyiszam() {
		return ujszemelyiszam;
	}

	public void setUjszemelyiszam(String ujszemelyiszam) {
		this.ujszemelyiszam = ujszemelyiszam;
	}

	public String getUjszulido() {
		return ujszulido;
	}

	public void setUjszulido(String ujszulido) {
		this.ujszulido = ujszulido;
	}

	public String getUjszulhely() {
		return ujszulhely;
	}

	public void setUjszulhely(String ujszulhely) {
		this.ujszulhely = ujszulhely;
	}

	public String getUjcim() {
		return ujcim;
	}

	public void setUjcim(String ujcim) {
		this.ujcim = ujcim;
	}

	public String getUjtelefon() {
		return ujtelefon;
	}

	public void setUjtelefon(String ujtelefon) {
		this.ujtelefon = ujtelefon;
	}

	public String getUjceg() {
		return ujceg;
	}

	public void setUjceg(String ujceg) {
		this.ujceg = ujceg;
	}
}
