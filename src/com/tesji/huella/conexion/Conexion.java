package com.tesji.huella.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {

	Connection conexion;
	Statement sentencia;

	public boolean prepararBaseDatos() {
		boolean conex = false;
		try {
			String contador = "com.mysql.cj.jdbc.Driver";
			Class.forName(contador).newInstance();
			if (conectar() || conectarLocal()) {
				if (sentencia())
					conex = true;
			} else {
				conex = false;
			}
		} catch (Exception e) {
			conex = false;
		}
		return conex;
	}

	public boolean conectar() {
		try {
			//Conexion a BD online
			String DSN = "jdbc:mysql://db4free.net:3306/huella";
			String user = "davidoso";
			String pasword = "qazplm10";
			conexion = DriverManager.getConnection(DSN, user, pasword);
			return true;
		} catch (Exception e) {
			//Si no funciona online se conectara a una DB local
			return conectarLocal();
		}
	}

	public boolean conectarLocal() {
		try {
			JOptionPane.showMessageDialog(null, "Conexion local"); 
			//System.out.println("Conexion local");
			String DNS = "jdbc:mysql://localhost:3306/phpmyadmin/db_structure.php?server=1&db=huella";
			String user = "root";
			String pass = "";
			conexion = DriverManager.getConnection(DNS, user, pass);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problema al cargar");
			//System.out.println("Problema al cargar");
			return false;
		}
	}

	public boolean sentencia() {
		try {
			sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No creada la sentecia");
			//System.out.println("No creada la sentencia");
			return false;
		}
	}

	public void crear(String nombre, String ape1, String ape2, String matricula, File file) throws IOException {
		conectar();
		sentencia();
		String consulta = "insert into usuario (idUsuario, nombre, apellido1, apellido2, matricula, fotografia) values (?, ?, ?, ?, ?, ?)";
		
		FileInputStream fis = new FileInputStream(file);
		try {
			PreparedStatement ps = conexion.prepareStatement(consulta);
			conexion.setAutoCommit(false);
			ps.setString(1, null);
			ps.setString(2, nombre);
			ps.setString(3, ape1);
			ps.setString(4, ape2);
			ps.setString(5, matricula);
			ps.setBinaryStream(6, fis, (int)file.length());
			ps.executeUpdate();
			conexion.commit();
			JOptionPane.showMessageDialog(null, "Registro Exitoso " + nombre);
			fis.close();
			ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo guardar ");
			//System.out.println("No se pudo guardar");
			e.printStackTrace();
		}

	}

	public ResultSet consulta(int idUser) {
		conectar();
		sentencia();
		String consulta = "";
		ResultSet usuario = null;
		try {
			consulta = "select * from usuario where idUsuario=" + idUser + ";";
			usuario = sentencia.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
		
	}

	public String consultaId() {
		conectar();
		sentencia();
		String id = "0";
		String consulta = "select idUsuario from usuario order by idUsuario asc";
		try {
			ResultSet rs = (ResultSet) sentencia.executeQuery(consulta);
			while(rs.next()){
				id = rs.getString("idUsuario");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se hae la consulta");
			//System.err.println("no se hace la consulta");
		}
		return id;
	}

	public void cerrar() throws SQLException {
		conexion.close();
	}
}
