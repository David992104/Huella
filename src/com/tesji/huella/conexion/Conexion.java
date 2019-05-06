package com.tesji.huella.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	Connection conexion;
	Statement sentencia;

	public boolean prepararBaseDatos() {
		boolean conex = false;
		try {
			String contador = "com.mysql.cj.jdbc.Driver";
			Class.forName(contador).newInstance();
			conex = true;
			conex = conectar();
			conex = sentencia();
		} catch (Exception e) {
			conex = false;
		}
		return conex;
	}

	public boolean conectar() {
		try {
			String DSN = "jdbc:mysql://db4free.net:3306/huella";
			String user = "davidoso";
			String pasword = "qazplm10";
			conexion = DriverManager.getConnection(DSN, user, pasword);
			System.out.println("Conectado");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean sentencia() {
		try {
			sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Sentencia creada");
			return true;
		} catch (Exception e) {
			System.out.println("No creada la sentencia");
			return false;
		}
	}

	public void crear(String nombre, String ape1, String ape2, String matricula) {
		String consulta = "";
		try {
			consulta = "INSERT INTO usuario VALUES (";
			consulta += "NULL,";
			consulta += "'" + nombre + "',";
			consulta += "'" + ape1 + "',";
			consulta += "'" + ape2 + "',";
			consulta += "'" + matricula + "',";
			consulta += "NULL);";
			System.out.println(consulta);
			sentencia.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cerrar() throws SQLException {
		conexion.close();
	}
}
