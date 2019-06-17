package com.tesji.huella.login;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.mysql.cj.result.BinaryStreamValueFactory;
import com.sun.webkit.ThemeClient;
import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

public class LoginModel {
	
	Conexion conu = new Conexion();
	ConexionArduino con = new ConexionArduino();
	ResultSet rs = conu.consulta(con.getIDhuella());
	
	
	private boolean pulso = true;

	public void busqueda() {
		con.busqueda(1);
		boolean cona = true;
		do {
			if (!pulso) {
				System.out.println("Sale de la busqueda");
				break;
			}
			//con.busqueda(1);
			 System.out.println(con.getIDhuella());
			if (con.getIDhuella() != 0) {
				cona = false;
			}
		
		} while (cona);
		System.out.println(con.getIDhuella());
		ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
		
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
	
	public Image getImage() {
		try {
			byte [] img = rs.getBytes("fotografia");
			ByteArrayInputStream bis =  new ByteArrayInputStream(img);
			Iterator readres = ImageIO.getImageReadersByFormatName("jpeg");
			ImageReader reader = (ImageReader) readres.next();
			Object source = bis;
			ImageInputStream iis = ImageIO.createImageInputStream(source);
			reader.setInput(iis, true);
			ImageReadParam param =  reader.getDefaultReadParam();
			
			param.setSourceSubsampling(4, 4, 0, 0);
			
			//return reader.read(0, param);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reader.read(0, param);
	}

	public void cerrarCon() {
		con.CerrarConexion();
	}
	
	/*static AnimationTimer cicloHuella = new AnimationTimer() {
		LoginModel lm = new LoginModel();
		@Override
		public void handle(long now) {
			lm.busqueda();
			
		}
	};
	*/
	
	public boolean isPulso() {
		return pulso;
	}

	public void setPulso(boolean pulso) {
		this.pulso = pulso;
	}


	
}
