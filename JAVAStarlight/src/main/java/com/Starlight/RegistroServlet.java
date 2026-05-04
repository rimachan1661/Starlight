package com.Starlight;
import java.time.LocalDate;
import java.sql.Date;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
    	try
    	{
    	
    	Connection conn = DBConnection.getConnection();
    	
    	

    	String sql = "INSERT INTO USUARIO (NOMBRE, EMAIL, CONTRASENYA, ESPREMIUM, ROL, FECHANACIMIENTO, FECHAREGISTRO, TELEFONO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    	PreparedStatement ps = conn.prepareStatement(sql);
    	
    	  String nombre = request.getParameter("nombre");
          String genero = request.getParameter("genero");
          String email = request.getParameter("email");
          String telefono = request.getParameter("telefono");
          String fechanacimiento = request.getParameter("fechanacimiento");
          String contrasenya = request.getParameter("contrasenya");
          String rol = request.getParameter("rol");

    	ps.setString(1, nombre);
    	ps.setString(2, email);
    	ps.setString(3, contrasenya);
    	ps.setBoolean(4, false); // ESPREMIUM
    	ps.setString(5, rol);
    	ps.setString(6, fechanacimiento);
    	ps.setDate(7, java.sql.Date.valueOf(LocalDate.now()));
    	ps.setString(8, telefono);

    	ps.executeUpdate();

    	conn.close();


        response.getWriter().println("Recibido ?");
    	}
    	catch (Exception e){e.printStackTrace(); }
    }
}

