package com.tesji.huella.login;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

public class LoginModel {
	
	ConexionArduino con = new ConexionArduino();
	
	private boolean pulso = true;

	public void busqueda() {
		con.busqueda(1);
		boolean cona = true;
		do {
			 System.out.println(con.getIDhuella());
			if (con.getIDhuella() != 0) {
				cona = false;
			}
			if (!pulso) {
				System.out.println("Sale de la busqueda");
				break;
			}
		} while (cona);
		System.out.println(con.getIDhuella());
		Conexion conu = new Conexion();
		try {
		ResultSet rs = conu.consulta(con.getIDhuella());
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()) {
			for (int i = 1; i <=rsmd.getColumnCount() - 1; i++) {
				System.out.println(rs.getString(i));
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cerrarCon() {
		con.CerrarConexion();
	}
	
	
	
	
	public boolean isPulso() {
		return pulso;
	}

	public void setPulso(boolean pulso) {
		this.pulso = pulso;
	}


	
}
