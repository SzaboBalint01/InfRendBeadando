package ait.szabo128.bead.businessLogic;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Named;

import ait.szabo128.bead.entity.*;

import ait.szabo128.bead.dao.KolcsonzoDAO;

@ManagedBean(name="UgyfelBean")
@ApplicationScoped
public class UgyfelBean {
	 private KolcsonzoDAO kolcsonzoDAO;
	 private String nev;
	 
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
	 
	 public void setNev(String nev) {
	        this.nev = nev;
	    }
	 public String getNev() {
	        return nev;
	    }
}
