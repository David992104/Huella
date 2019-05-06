package com.tesji.huella.conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Conexion {
	
	 Connection conexion;
	 Statement sentencia;
	    
	 public void PrepararBaseDatos() {
	        try {
	            String contador = "com.mysql.cj.jdbc.Driver";
	            Class.forName(contador).newInstance();
	            System.out.println("Cargado");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al cargar el controlador");
	        }
	        try {
	            String DSN = "jdbc:mysql://db4free.net:3306/huella";
	            String user = "davidoso";
	            String pasword = "qazplm10";
	            conexion = DriverManager.getConnection(DSN, user, pasword);
	            System.out.println("Conectado");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al realizar la conexión");
	        }
	        try {
	            sentencia = conexion.createStatement(
	                    ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al crear el objeto");
	        }
	    }
}
