package ait.szabo128.bead;


import java.util.ArrayList;
import ait.szabo128.bead.entity.UgyfelEntity; 
import ait.szabo128.bead.businessLogic.*;
import ait.szabo128.bead.dao.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connectiontest {

	public static void main(String[] args) {
		KolcsonzoDAO kolcsonzoDAO= new KolcsonzoDAO();;
		ArrayList<UgyfelEntity> ugyfel = new ArrayList<>();
		String datum = "1000-12-11";
		Date date = Date.valueOf(datum);
		System.out.println(datum);
		
		
		try {
			kolcsonzoDAO.fetchUgyfel();
			kolcsonzoDAO.insertUgyfel("ZZZZZZZZ", "FERENC JÓSKA",datum, "HOLD", "NAGYKRÁTER 2.", "06703236", "doom kft-");
		}
			
		catch(Exception exc) {	
			exc.printStackTrace();
		}
		
	}
}	

