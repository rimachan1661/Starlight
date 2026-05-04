package com.Starlight;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	System.out.println("CONECTANDO A BD...");
        String url = "jdbc:mysql://localhost:3306/Starlight";
        String user = "root";
        String password = "Tori_ropi6";

        return DriverManager.getConnection(url, user, password);
    }
}