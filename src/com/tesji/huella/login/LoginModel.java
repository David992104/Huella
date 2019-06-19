package com.tesji.huella.login;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator;
//import java.awt.Image;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

public class LoginModel {

	Conexion conu = new Conexion();
	ConexionArduino con = new ConexionArduino();
	ResultSet rs;

	private String nombre;
	private String apellidos;
	private String matricula;
	private Image img;	
	private ImageIcon imgico;
	private boolean pulso = true;

	public void busqueda() throws IOException {
		con.busqueda(1);
		boolean cona = true;
		do {
			if (!pulso) {
				System.out.println("Sale de la busqueda");
				break;
			}
			System.out.println(con.getIDhuella());
			if (con.getIDhuella() != 0) {
				cona = false;
			}
		} while (cona);
		con.CerrarConexion();
		System.out.println(con.getIDhuella());
		rs = conu.consulta(con.getIDhuella());
		try {
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellido1") + " " + ((rs.getString("apellido2") != null) ?  rs.getString("apellido2") : " ");
				matricula = rs.getString("matricula");

				System.out.println(nombre);
			}
			sacarImagen();
			
			new UserInformation().information();
			
			//JOptionPane.showMessageDialog(null, "Hola" + nombre + apellidos + "\nMatricula " + matricula,
				//	"Bienvenido", JOptionPane.INFORMATION_MESSAGE, (Icon) imgico);
			
			//con.manterActivo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void sacarImagen() throws SQLException, IOException {
		/*byte[] imagen = null;
		try {
			if(rs.next()) {
				imagen = rs.getBytes("fotografia");
				ImageIcon image = new ImageIcon(imagen);
				img = image.getImage();
				imgico = new ImageIcon(img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		/*byte[] imagen = rs.getBytes("fotografia");
		ByteArrayInputStream bis = new ByteArrayInputStream(imagen);
		Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
		ImageReader reader =(ImageReader)readers.next();
		Object source = bis;
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		//param.setSourceSubsampling(4,4, 0, 0 );
		return reader.read(0, param);*/
		
		InputStream is = rs.getBinaryStream("fotografia");
		OutputStream os = new FileOutputStream(new File("photo.jpg"));
		byte[] content = new byte[1024];
		int size=0;
		while((size = is.read(content)) != 1)
				os.write(content, 0, size);
		os.close();
		is.close();
		img = new Image("file:photo.jpg", 250, 250, true, true);
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	

}
