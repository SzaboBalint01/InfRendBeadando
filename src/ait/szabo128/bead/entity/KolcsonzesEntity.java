package ait.szabo128.bead.entity;

import java.util.Date;

public class KolcsonzesEntity{

	private Integer idkolcsonzes;
	private Date kolcsonzesideje;
	private Integer jarmu;
	private Integer ugyfel;
	private String ugyfelnev;
	private String ugyfelszemelyiszam;
	private String jarmugyarto;
	private String jarmutipus;

	public KolcsonzesEntity() {
	}

	public KolcsonzesEntity(Integer id, Integer jarmu, Integer ugyfel) {
		this.idkolcsonzes = id;
		this.jarmu = jarmu;
		this.ugyfel = ugyfel;
	}

	public KolcsonzesEntity(Integer id,Date kolcsonzesideje, Integer jarmu, Integer ugyfel, String ugyfelnev,String ugyfelszemelyiszam, String jarmugyarto, String jarmutipus) {
		this.idkolcsonzes = id;
		this.kolcsonzesideje = kolcsonzesideje;
		this.jarmu = jarmu;
		this.ugyfel = ugyfel;
		this.ugyfelnev = ugyfelnev;
		this.ugyfelszemelyiszam = ugyfelszemelyiszam;
		this.jarmugyarto = jarmugyarto;
		this.jarmutipus = jarmutipus;	
	}

	public Integer getIdkolcsonzes() {
		return this.idkolcsonzes;
	}

	public void setIdkolcsonzes(Integer id) {
		this.idkolcsonzes = id;
	}

	public Integer getJarmu() {
		return this.jarmu;
	}

	public void setJarmu(Integer jarmu) {
		this.jarmu = jarmu;
	}

	public Integer getUgyfel() {
		return this.ugyfel;
	}

	public void setUgyfel(Integer ugyfel) {
		this.ugyfel = ugyfel;
	}

	public Date getKolcsonzesideje() {
		return this.kolcsonzesideje;
	}

	public void setKolcsonzesideje(Date kolcsonzesideje) {
		this.kolcsonzesideje = kolcsonzesideje;
	}

	public String getUgyfelnev() {
		return ugyfelnev;
	}

	public void setUgyfelnev(String ugyfelnev) {
		this.ugyfelnev = ugyfelnev;
	}

	public String getUgyfelszemelyiszam() {
		return ugyfelszemelyiszam;
	}

	public void setUgyfelszemelyiszam(String ugyfelszemelyiszam) {
		this.ugyfelszemelyiszam = ugyfelszemelyiszam;
	}

	public String getJarmugyarto() {
		return jarmugyarto;
	}

	public void setJarmugyarto(String jarmugyarto) {
		this.jarmugyarto = jarmugyarto;
	}

	public String getJarmutipus() {
		return jarmutipus;
	}

	public void setJarmutipus(String jarmutipus) {
		this.jarmutipus = jarmutipus;
	}
	
	@Override public String toString() {
		return "Kolcsonzes [ID=" + idkolcsonzes + "Ideje:" + kolcsonzesideje + "JarmuID:"
							+ jarmu + "UgyfelID:" + ugyfel + "Ugyfel nev:" +ugyfelnev +"Személyi szam:" 
				+ ugyfelszemelyiszam + "Tipus:" +jarmutipus +"Gyarto:" + jarmugyarto+"]";
	}
}
