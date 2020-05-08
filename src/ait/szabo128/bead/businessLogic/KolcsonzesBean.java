package ait.szabo128.bead.businessLogic;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Digits;

import ait.szabo128.bead.dao.KolcsonzoDAO;
import ait.szabo128.bead.entity.KolcsonzesEntity;

@ManagedBean(name="KolcsonzesBean")
@ApplicationScoped
public class KolcsonzesBean {
	
	private KolcsonzoDAO kolcsonzoDAO;
	@Digits(fraction = 0, integer = 3)
	private Integer idvalasztas;
	private String ugyfelvalasztas;
	private String jarmuvalasztas;
	private String kolcsonzesidatum;
	private Boolean serult;
	private Integer futottkmdij;
	private Integer SUM=0;

	public KolcsonzesBean() { }
	
	@PostConstruct
	public void init() {
		kolcsonzoDAO = new KolcsonzoDAO();
	 }
	
	public ArrayList<KolcsonzesEntity> listKolcsonzes() {
        return kolcsonzoDAO.fetchKolcsonzes();
    }
	
	public ArrayList<Integer> searchKolcsonzesID(Integer szam){
		return kolcsonzoDAO.fetchKolcsonzesID();
	}
	
	public ArrayList<String> searchKolcsonzesSzemelyiszam(String szemelyiszam){
		return kolcsonzoDAO.fetchKolcsonzesSzemelyiszam();
	}
	
	public ArrayList<String> searchKolcsonzesJarmu(String rendszam){
		return kolcsonzoDAO.fetchKolcsonzesJarmu();
	}
	
	 public void addKolcsonzes(String kolcsonzesidatum, String ugyfelvalasztas, String jarmuvalasztas) {
		 kolcsonzoDAO.insertKolcsonzes(kolcsonzesidatum,  ugyfelvalasztas, jarmuvalasztas);
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"A kölcsönzés sikeres!", "Kölcsönzött jármû:"+jarmuvalasztas) );
		 this.kolcsonzesidatum=null;
		 this.ugyfelvalasztas=null;
		 this.jarmuvalasztas=null;
 }
	 
	 public void endKolcsonzes(Integer idvalasztas, Boolean serult, Integer futottkmdij) {
		 Integer serultint = serult ? 1 : 0;
		 System.out.println(serultint);
		 this.setSUM(kolcsonzoDAO.befejezesKolcsonzes(idvalasztas, serultint, futottkmdij));
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"A kölcsönzés befejezése sikeres!", "A kölcsönzés azonosítója:"+idvalasztas) );
		 this.serult = false;
		 this.futottkmdij = null;
	 }

	public Integer getIdvalasztas() {
		return idvalasztas;
	}

	public void setIdvalasztas(Integer idvalasztas) {
		this.idvalasztas = idvalasztas;
	}

	public String getUgyfelvalasztas() {
		return ugyfelvalasztas;
	}

	public void setUgyfelvalasztas(String ugyfelvalasztas) {
		this.ugyfelvalasztas = ugyfelvalasztas;
	}

	public String getJarmuvalasztas() {
		return jarmuvalasztas;
	}

	public void setJarmuvalasztas(String jarmuvalasztas) {
		this.jarmuvalasztas = jarmuvalasztas;
	}

	public String getKolcsonzesidatum() {
		return kolcsonzesidatum;
	}

	public void setKolcsonzesidatum(String kolcsonzesidatum) {
		this.kolcsonzesidatum = kolcsonzesidatum;
	}

	public Boolean getSerult() {
		return serult;
	}

	public void setSerult(Boolean serult) {
		this.serult = serult;
	}

	public Integer getFutottkmdij() {
		return futottkmdij;
	}

	public void setFutottkmdij(Integer futottkmdij) {
		this.futottkmdij = futottkmdij;
	}

	public Integer getSUM() {
		return SUM;
	}

	public void setSUM(Integer sUM) {
		SUM = sUM;
	}
}
