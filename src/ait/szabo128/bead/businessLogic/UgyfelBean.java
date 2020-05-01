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
	 
	 
	 @PostConstruct
	  public void init() {
		 kolcsonzoDAO = new KolcsonzoDAO();
	    }
	 
	 public ArrayList<UgyfelEntity> getUgyfel() {
	        return kolcsonzoDAO.listUgyfel();
	    }
}
