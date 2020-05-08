package ait.szabo128.bead.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ait.szabo128.bead.entity.*;

public class KolcsonzoDAO {
	private Connection myconn = null;
	
	public Connection connect() {
		String jdbcurl = "jdbc:mysql://localhost:3306/bead_db?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		Connection DBconnection;
		try {
			 System.out.println("Csatlakozás:" + jdbcurl);
			 DBconnection = DriverManager.getConnection(jdbcurl, user, pass);
			 System.out.println("Sikeres csatkalozás!");
		
		}catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
		return DBconnection;
	}
	
    public ArrayList<UgyfelEntity> fetchUgyfel() {
        ArrayList<UgyfelEntity> ugyfel = new ArrayList<>();
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from ugyfel");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                ugyfel.add(new UgyfelEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getDate(4), resultset.getString(5), resultset.getString(6), resultset.getString(7),
                		resultset.getString(8)));
                //System.out.println(ugyfel);   
                }
        	} catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        return ugyfel;
    	}
    
    public ArrayList<UgyfelEntity> filterUgyfelbynev(String nev) {
        ArrayList<UgyfelEntity> ugyfel = new ArrayList<>();
        //System.out.println(nev);
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from ugyfel where nev='" + nev+"'");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                ugyfel.add(new UgyfelEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getDate(4), resultset.getString(5), resultset.getString(6), resultset.getString(7),
                		resultset.getString(8)));
               // System.out.println(ugyfel);
                }
        	} catch (SQLException e) {
            System.out.println(e.getMessage());}
        return ugyfel;
    	}
    
    public void insertUgyfel(String szemelyiszam, String nev, String szulido, String szulhely, String cim, String telefon, String ceg){
    	myconn = connect();
    	try {
    		//System.out.println(szulido + szemelyiszam + nev);
    		Date szulidoinmilis = Date.valueOf(szulido);
    		//System.out.println(szulidoinmilis);
    		PreparedStatement preparedstatement = myconn.prepareStatement("insert into ugyfel (szemelyiszam, nev, szulido, szulhely, cim, telefon, ceg ) values (?,?,?,?,?,?,?)");
    		preparedstatement.setString(1, szemelyiszam);
    		preparedstatement.setString(2, nev);
    		preparedstatement.setDate(3,szulidoinmilis);
    		preparedstatement.setString(4,szulhely);
    		preparedstatement.setString(5,cim);
    		preparedstatement.setString(6,telefon);
    		preparedstatement.setString(7,ceg);
    		preparedstatement.execute(); 		
    	}catch (SQLException ex) {
            System.out.println(ex.getMessage());}
    }
    
    public ArrayList<JarmuEntity> fetchJarmu() {
        ArrayList<JarmuEntity> jarmu = new ArrayList<>();
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from jarmu");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                jarmu.add(new JarmuEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getString(4), resultset.getString(5), resultset.getDate(6), resultset.getInt(7),
                		resultset.getInt(8),resultset.getInt(9)));
                //System.out.println(jarmu);   
                }
        	} catch (SQLException e) {
            System.out.println(e.getMessage());}
        return jarmu;}
    
    public ArrayList<JarmuEntity> filterJarmubytipus(String tipus) {
        ArrayList<JarmuEntity> jarmu = new ArrayList<>();
       // System.out.println(tipus);
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from jarmu where tipus='" +tipus+"'");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
            	jarmu.add(new JarmuEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getString(4), resultset.getString(5), resultset.getDate(6), resultset.getInt(7),
                		resultset.getInt(8),resultset.getInt(9)));
                //System.out.println(jarmu);
                }
        	} catch (SQLException e) {
            System.out.println(e.getMessage());}
        return jarmu;
    	}
    
    public ArrayList<JarmuEntity> filterJarmubyrendszam(String rendszam) {
        ArrayList<JarmuEntity> jarmu = new ArrayList<>();
       // System.out.println(rendszam);
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from jarmu where rendszam='" +rendszam+"'");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
            	jarmu.add(new JarmuEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getString(4), resultset.getString(5), resultset.getDate(6), resultset.getInt(7),
                		resultset.getInt(8),resultset.getInt(9)));
               // System.out.println(jarmu);
                }
        	} catch (SQLException e) {
            System.out.println(e.getMessage());}
        return jarmu;
    	}
    
    public void insertJarmu(String tipus, String rendszam, String gyarto, String alvazszam, String beszerzesidatum, Integer kolcsonzesidij, Integer futottkmdij, Integer statusz){
    	myconn = connect();
    	try {
    		Date beszerzesidatuminmilis = Date.valueOf(beszerzesidatum);
    		//System.out.println(tipus+rendszam+gyarto);
    		PreparedStatement preparedstatement = myconn.prepareStatement("insert into jarmu (tipus, rendszam, gyarto, alvazszam, beszerzesidatum, kolcsonzesidij, futottkmdij, statusz ) values (?,?,?,?,?,?,?,?)");
    		preparedstatement.setString(1,tipus);
    		preparedstatement.setString(2,rendszam);
    		preparedstatement.setString(3,gyarto);
    		preparedstatement.setString(4,alvazszam);
    		preparedstatement.setDate(5,beszerzesidatuminmilis);
    		preparedstatement.setInt(6,kolcsonzesidij);
    		preparedstatement.setInt(7,futottkmdij);
    		preparedstatement.setInt(8,statusz);
    		preparedstatement.execute(); 
    	}catch (SQLException ex) {
            System.out.println(ex.getMessage());}
    }
    
    public ArrayList<KolcsonzesEntity> fetchKolcsonzes() {
        ArrayList<KolcsonzesEntity> kolcsonzes = new ArrayList<>();
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select x.idkolcsonzes, x.kolcsonzesideje," 
        +"x.jarmu, x.ugyfel, x.nev, x.szemelyiszam, x.gyarto, x.tipus from (select * from kolcsonzes k inner join jarmu j on k.jarmu = j.idjarmu inner join ugyfel u on k.ugyfel = u.idugyfel) as x;");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                kolcsonzes.add(new KolcsonzesEntity(resultset.getInt(1), resultset.getDate(2), resultset.getInt(3),
                		resultset.getInt(4),resultset.getString(5), resultset.getString(6), resultset.getString(7), resultset.getString(8) ));
                System.out.println(kolcsonzes);   
                }
        	} catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        //System.out.println(kolcsonzes);
        return kolcsonzes;
    	}
    
    public ArrayList<Integer> fetchKolcsonzesID(){
    	ArrayList<Integer> kolcsonzesid = new ArrayList<>();
    	myconn = connect();
    	try {
    	PreparedStatement preparedstatement = myconn.prepareStatement("select idkolcsonzes from kolcsonzes;");
    	ResultSet resultset = preparedstatement.executeQuery();
    	 while (resultset.next()) {kolcsonzesid.add(new Integer(resultset.getInt(1)));}
    	} catch (SQLException ex) {
            System.out.println(ex.getMessage());}
    	return kolcsonzesid;
    }
    
    public ArrayList<String> fetchKolcsonzesSzemelyiszam(){
    	ArrayList<String> kolcsonzesszemelyiszam = new ArrayList<>();
    	myconn = connect();
    	try {
    	PreparedStatement preparedstatement = myconn.prepareStatement("select szemelyiszam from ugyfel;");
    	ResultSet resultset = preparedstatement.executeQuery();
    	 while (resultset.next()) {kolcsonzesszemelyiszam.add(new String(resultset.getString(1)));}
    	} catch (SQLException ex) {
            System.out.println(ex.getMessage());}
    	return kolcsonzesszemelyiszam;
    }
    
    public ArrayList<String> fetchKolcsonzesJarmu(){
    	ArrayList<String> kolcsonzesrendszam = new ArrayList<>();
    	myconn = connect();
    	try {
    	PreparedStatement preparedstatement = myconn.prepareStatement("select rendszam from jarmu where statusz='0' ;");
    	ResultSet resultset = preparedstatement.executeQuery();
    	 while (resultset.next()) {kolcsonzesrendszam.add(new String(resultset.getString(1)));}
    	} catch (SQLException ex) {
            System.out.println(ex.getMessage());}
    	return kolcsonzesrendszam;
    }
    
    public void insertKolcsonzes(String kolcsonzesideje, String szemelyiszam, String rendszam) {
    	myconn = connect();
    	PreparedStatement preparedstatement;
    	ResultSet resultset;
    	Integer ugyfelid;
    	Integer jarmuid;
    	Date kolcsonzesidatuminmilis = Date.valueOf(kolcsonzesideje);
    	try {
    		preparedstatement = myconn.prepareStatement("select idugyfel from ugyfel where szemelyiszam='" + szemelyiszam +"'");
    		resultset = preparedstatement.executeQuery();
    		resultset.next();
    		ugyfelid = new Integer(resultset.getInt(1));
    		preparedstatement = myconn.prepareStatement("select idjarmu from jarmu where rendszam='" + rendszam +"'");
    		resultset = preparedstatement.executeQuery();
    		resultset.next();
    		jarmuid = new Integer(resultset.getInt(1));
    		preparedstatement = myconn.prepareStatement("update jarmu set statusz = '1' where rendszam='" + rendszam +"'");
    		preparedstatement.execute(); 
    		preparedstatement = myconn.prepareStatement("insert into kolcsonzes(kolcsonzesideje,jarmu,ugyfel) values (?,?,?)");
    		preparedstatement.setDate(1,kolcsonzesidatuminmilis);
    		preparedstatement.setInt(2,jarmuid);
    		preparedstatement.setInt(3,ugyfelid);
    		preparedstatement.execute(); 
    }catch (SQLException ex) {
        System.out.println(ex.getMessage());}
    }
    
    public Integer befejezesKolcsonzes(Integer ID, Integer serult, Integer futottkm) {
    	Integer osszeg = 0;
    	myconn = connect();
    	PreparedStatement preparedstatement;
    	ResultSet resultset;
    	Integer idjarmu;
    	Integer kolcsonzesidij = null;
    	Integer futottkmdij = null;
    	
    	try {
    	preparedstatement = myconn.prepareStatement("select x.jarmu from (select * from kolcsonzes where idkolcsonzes = " + ID + ") as x");
    	resultset = preparedstatement.executeQuery();
    	resultset.next();
    	idjarmu = new Integer(resultset.getInt(1));
    	
    	preparedstatement = myconn.prepareStatement("select x.kolcsonzesidij, x.futottkmdij from (select * from jarmu where idjarmu = " + idjarmu + ") as x");
    	resultset = preparedstatement.executeQuery();
    	while (resultset.next()) {
    	kolcsonzesidij = new Integer(resultset.getInt(1));
    	futottkmdij = new Integer(resultset.getInt(2));}
    	
    	if(serult == 1) {
    		osszeg+=20000;
    		preparedstatement = myconn.prepareStatement("update jarmu set statusz = '2' where idjarmu='" + idjarmu +"'");
    		preparedstatement.execute();
    	}
    	else {
    		preparedstatement = myconn.prepareStatement("update jarmu set statusz = '0' where idjarmu='" + idjarmu +"'");
    		preparedstatement.execute();
    	}
    	
    	osszeg += kolcsonzesidij + futottkm*futottkmdij;
    	//System.out.println(osszeg);
    	
    	preparedstatement = myconn.prepareStatement("delete from kolcsonzes where idkolcsonzes='" +ID+"'");
    	preparedstatement.execute();
    	
    	}catch (SQLException ex) {
        System.out.println(ex.getMessage());}
    	
    	return osszeg;
    }
    
    
}
