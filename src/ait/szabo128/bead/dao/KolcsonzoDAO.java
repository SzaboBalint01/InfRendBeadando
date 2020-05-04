package ait.szabo128.bead.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
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
			 System.out.println("Success!");
		
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
    		Date szulidoinmilis = Date.valueOf(szulido);
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
        return jarmu;
    	}
    
    
	
}
