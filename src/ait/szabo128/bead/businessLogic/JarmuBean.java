package ait.szabo128.bead.businessLogic;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

import ait.szabo128.bead.dao.KolcsonzoDAO;
import ait.szabo128.bead.entity.JarmuEntity;

@ManagedBean(name="JarmuBean")
@ApplicationScoped
public class JarmuBean {
	private KolcsonzoDAO kolcsonzoDAO;
	private String tipus;
	private String rendszam;
	@Size(max=45)
	private String ujtipus;
	@Size(max=45)
	private String ujrendszam;
	@Size(max=45)
	private String ujgyarto;
	@Size(max=45)
	private String ujalvazszam;
	private String ujbeszerzesidatum;
	private Integer ujkolcsonzesidij;
	private Integer ujfutottkmdij;
	private Integer ujstatusz;
	
	public JarmuBean() { }
	
	@PostConstruct
	  public void init() {
		 kolcsonzoDAO = new KolcsonzoDAO();
	    }
	
	public ArrayList<JarmuEntity> listJarmu() {
        return kolcsonzoDAO.fetchJarmu();
    }
	
	 public ArrayList<JarmuEntity> searchJarmutipus(String tipus){
		 return kolcsonzoDAO.filterJarmubytipus(tipus);
	 }
	 
	 public ArrayList<JarmuEntity> searchJarmurendszam(String rendszam){
		 return kolcsonzoDAO.filterJarmubyrendszam(rendszam);
	 }
	 
	 public void addJarmu(String ujtipus, String ujrendszam, String ujgyarto, String ujalvazszam, String ujbeszerzesidatum, Integer ujkolcsonzesidij, Integer ujfutottkmdij) {
		 Integer ujstatusz = 0; //Minden felvett jármû kölcsönözhetõ alapból.
		 kolcsonzoDAO.insertJarmu(ujtipus, ujrendszam, ujgyarto, ujalvazszam, ujbeszerzesidatum, ujkolcsonzesidij, ujfutottkmdij, ujstatusz );
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sikeres felvétel!", "Felvett jármû:" +ujgyarto +ujtipus +ujrendszam) );
		 this.ujtipus=null;
		 this.ujrendszam=null;
		 this.ujgyarto=null;
		 this.ujalvazszam=null;
		 this.ujbeszerzesidatum=null;
		 this.ujkolcsonzesidij=null;
		 this.ujfutottkmdij=null; 
		 this.ujstatusz=null;
 }

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getRendszam() {
		return rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}

	public String getUjtipus() {
		return ujtipus;
	}

	public void setUjtipus(String ujtipus) {
		this.ujtipus = ujtipus;
	}

	public String getUjrendszam() {
		return ujrendszam;
	}

	public void setUjrendszam(String ujrendszam) {
		this.ujrendszam = ujrendszam;
	}

	public String getUjgyarto() {
		return ujgyarto;
	}

	public void setUjgyarto(String ujgyarto) {
		this.ujgyarto = ujgyarto;
	}

	public String getUjalvazszam() {
		return ujalvazszam;
	}

	public void setUjalvazszam(String ujalvazszam) {
		this.ujalvazszam = ujalvazszam;
	}

	public String getUjbeszerzesidatum() {
		return ujbeszerzesidatum;
	}

	public void setUjbeszerzesidatum(String ujbeszerzesidatum) {
		this.ujbeszerzesidatum = ujbeszerzesidatum;
	}

	public Integer getUjkolcsonzesidij() {
		return ujkolcsonzesidij;
	}

	public void setUjkolcsonzesidij(Integer ujkolcsonzesidij) {
		this.ujkolcsonzesidij = ujkolcsonzesidij;
	}

	public Integer getUjfutottkmdij() {
		return ujfutottkmdij;
	}

	public void setUjfutottkmdij(Integer ujfutottkmdij) {
		this.ujfutottkmdij = ujfutottkmdij;
	}

	public Integer getUjstatusz() {
		return ujstatusz;
	}

	public void setUjstatusz(Integer ujstatusz) {
		this.ujstatusz = ujstatusz;
	}
	
	
}
