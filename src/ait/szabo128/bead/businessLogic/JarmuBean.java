package ait.szabo128.bead.businessLogic;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ait.szabo128.bead.dao.KolcsonzoDAO;
import ait.szabo128.bead.entity.JarmuEntity;
import ait.szabo128.bead.entity.UgyfelEntity;

@ManagedBean(name="JarmuBean")
@ApplicationScoped
public class JarmuBean {
	private KolcsonzoDAO kolcsonzoDAO;
	
	@PostConstruct
	  public void init() {
		 kolcsonzoDAO = new KolcsonzoDAO();
	    }
	
	public ArrayList<JarmuEntity> listUgyfel() {
        return kolcsonzoDAO.fetchJarmu();
    }
}
