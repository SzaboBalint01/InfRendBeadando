package ait.szabo128.bead.entity;

import java.util.Date;

public class JarmuEntity {

	
	private Integer idjarmu;
	private String tipus;
	private String rendszam;
	private String gyarto;
	private String alvazszam;
	private Date beszerzesidatum;
	private int kolcsonzesidij;
	private int futottkmdij;
	private int statusz;

	public JarmuEntity() {
	}

	public JarmuEntity(String tipus, String rendszam, String gyarto, String alvazszam, Date beszerzesidatum,
			int kolcsonzesidij, int futottkmdij, int statusz) {
		this.tipus = tipus;
		this.rendszam = rendszam;
		this.gyarto = gyarto;
		this.alvazszam = alvazszam;
		this.beszerzesidatum = beszerzesidatum;
		this.kolcsonzesidij = kolcsonzesidij;
		this.futottkmdij = futottkmdij;
		this.statusz = statusz;
	}

	public Integer getIdjarmu() {
		return this.idjarmu;
	}

	public void setIdjarmu(Integer idjarmu) {
		this.idjarmu = idjarmu;
	}

	public String getTipus() {
		return this.tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getRendszam() {
		return this.rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}

	public String getGyarto() {
		return this.gyarto;
	}

	public void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	public String getAlvazszam() {
		return this.alvazszam;
	}

	public void setAlvazszam(String alvazszam) {
		this.alvazszam = alvazszam;
	}

	public Date getBeszerzesidatum() {
		return this.beszerzesidatum;
	}

	public void setBeszerzesidatum(Date beszerzesidatum) {
		this.beszerzesidatum = beszerzesidatum;
	}

	public int getKolcsonzesidij() {
		return this.kolcsonzesidij;
	}

	public void setKolcsonzesidij(int kolcsonzesidij) {
		this.kolcsonzesidij = kolcsonzesidij;
	}

	public int getFutottkmdij() {
		return this.futottkmdij;
	}

	public void setFutottkmdij(int futottkmdij) {
		this.futottkmdij = futottkmdij;
	}

	public int getStatusz() {
		return this.statusz;
	}

	public void setStatusz(int statusz) {
		this.statusz = statusz;
	}
	
	@Override public String toString() {
		return "Jármu [ID=" + idjarmu + "Tipus:" + tipus + "Rendszam:"
							+ rendszam + "Alvaz szam:" + alvazszam + "Beszerzesi datum:" + beszerzesidatum + "Kolcsonzesi dij:" + kolcsonzesidij 
							+ "Futott km dij:" + futottkmdij + "Statusz:" + statusz + "]";
	}

}
