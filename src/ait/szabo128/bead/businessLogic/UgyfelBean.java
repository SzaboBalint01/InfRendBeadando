package ait.szabo128.bead.businessLogic;

import java.util.ArrayList;
import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ait.szabo128.bead.entity.*;

import ait.szabo128.bead.dao.KolcsonzoDAO;

@ManagedBean(name="UgyfelBean")
@ApplicationScoped
public class UgyfelBean {
	 private KolcsonzoDAO kolcsonzoDAO;
	 private String nev;
	 private String ujnev;
	 private String ujszemelyiszam;
	 private String ujszulido;
	 private String ujszulhely;
	 private String ujcim;
	 private String ujtelefon;
	 private String ujceg;
	 
	 
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
	 public void addUgyfel() {
		 kolcsonzoDAO.insertUgyfel(ujszemelyiszam, ujnev, ujszulido, ujszulhely, ujcim, ujtelefon,ujceg);
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
