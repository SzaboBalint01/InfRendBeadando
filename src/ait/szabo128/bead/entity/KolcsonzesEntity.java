package ait.szabo128.bead.entity;

import java.util.Date;

public class KolcsonzesEntity{

	private Integer idkolcsonzes;
	private Date kolcsonzesideje;
	private Integer jarmu;
	private Integer ugyfel;

	public KolcsonzesEntity() {
	}

	public KolcsonzesEntity(Integer id, Integer jarmu, Integer ugyfel) {
		this.idkolcsonzes = id;
		this.jarmu = jarmu;
		this.ugyfel = ugyfel;
	}

	public KolcsonzesEntity(Integer id, Integer jarmu, Integer ugyfel, Date kolcsonzesideje) {
		this.idkolcsonzes = id;
		this.jarmu = jarmu;
		this.ugyfel = ugyfel;
		this.kolcsonzesideje = kolcsonzesideje;
	}

	public Integer getId() {
		return this.idkolcsonzes;
	}

	public void setId(Integer id) {
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
	@Override public String toString() {
		return "Kolcsonzes [ID=" + idkolcsonzes + "Ideje:" + kolcsonzesideje + "JarmuID:"
							+ jarmu + "UgyfelID:" + ugyfel + "]";
	}
}
