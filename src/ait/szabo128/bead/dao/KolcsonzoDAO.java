package ait.szabo128.bead.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
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
			 System.out.println("Csatlakoz�s:" + jdbcurl);
			 DBconnection = DriverManager.getConnection(jdbcurl, user, pass);
			 System.out.println("Success!");
		
		}catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
		return DBconnection;
	}
	
    public ArrayList<UgyfelEntity> listUgyfel() {
        ArrayList<UgyfelEntity> ugyfel = new ArrayList<>();
        myconn = connect();
        try {
        PreparedStatement preparedstatement = myconn.prepareStatement("select * from ugyfel");
        ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                ugyfel.add(new UgyfelEntity(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
                		resultset.getDate(4), resultset.getString(5), resultset.getString(6), resultset.getString(7),
                		resultset.getString(8)));
                System.out.println(ugyfel);
                
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ugyfel;
    }
	
}