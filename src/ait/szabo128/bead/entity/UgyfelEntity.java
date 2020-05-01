package ait.szabo128.bead.entity;

import java.util.Date;

public class UgyfelEntity{

	private Integer idugyfel;
	private String szemelyiszam;
	private String nev;
	private Date szulido;
	private String szulhely;
	private String cim;
	private String telefon;
	
	private String ceg;

	public UgyfelEntity() {
	}

	public UgyfelEntity(Integer idugyfel, String szemelyiszam, String nev, Date szulido, String szulhely, String cim, String telefon) {
		this.idugyfel = idugyfel;
		this.szemelyiszam = szemelyiszam;
		this.nev = nev;
		this.szulido = szulido;
		this.szulhely = szulhely;
		this.cim = cim;
		this.telefon = telefon;
	}

	public UgyfelEntity(Integer idugyfel, String szemelyiszam, String nev, Date szulido, String szulhely, String cim, String telefon,
			String ceg) {
		this.idugyfel = idugyfel;
		this.szemelyiszam = szemelyiszam;
		this.nev = nev;
		this.szulido = szulido;
		this.szulhely = szulhely;
		this.cim = cim;
		this.telefon = telefon;
		this.ceg = ceg;
	}

	public Integer getIdugyfel() {
		return this.idugyfel;
	}

	public void setIdugyfel(Integer idugyfel) {
		this.idugyfel = idugyfel;
	}

	public String getSzemelyiszam() {
		return this.szemelyiszam;
	}

	public void setSzemelyiszam(String szemelyiszam) {
		this.szemelyiszam = szemelyiszam;
	}

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public Date getSzulido() {
		return this.szulido;
	}

	public void setSzulido(Date szulido) {
		this.szulido = szulido;
	}

	public String getSzulhely() {
		return this.szulhely;
	}

	public void setSzulhely(String szulhely) {
		this.szulhely = szulhely;
	}

	public String getCim() {
		return this.cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getCeg() {
		return this.ceg;
	}

	public void setCeg(String ceg) {
		this.ceg = ceg;
	}
	
	@Override public String toString() {
		return " Ugyfel [ID: " + idugyfel + " Szemelyiszam: " + szemelyiszam + " Nev: "
							+ nev + " Szuletesi ido: " + szulido + " Szuletesi hely: " + szulhely + " Cim: " + cim 
							+ " Telefon: " + telefon + " Ceg: " + ceg + "]";
	}
	
}
