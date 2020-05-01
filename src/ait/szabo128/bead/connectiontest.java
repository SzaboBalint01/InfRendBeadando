package ait.szabo128.bead;


import java.util.ArrayList;
import ait.szabo128.bead.entity.UgyfelEntity; 
import ait.szabo128.bead.businessLogic.*;
import ait.szabo128.bead.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connectiontest {

	public static void main(String[] args) {
		KolcsonzoDAO kolcsonzoDAO= new KolcsonzoDAO();;
		ArrayList<UgyfelEntity> ugyfel = new ArrayList<>();
		
		
		try {
			kolcsonzoDAO.listUgyfel();
			
                
		}
			
		catch(Exception exc) {	
			exc.printStackTrace();
		}
		
	}
}	

