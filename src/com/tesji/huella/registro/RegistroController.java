package com.tesji.huella.registro;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegistroController {

	@FXML
	private BorderPane idBorderpane;
	@FXML
	private JFXTextField txtNombre;
	@FXML
	private JFXTextField txtApUno;
	@FXML
	private JFXTextField txtApDos;
	@FXML
	private JFXTextField txtMatricula;
	@FXML
	private JFXButton btnBorrar;
	@FXML
	private JFXButton btnGuardar;
	@FXML
	private JFXButton btnCancelar;
	@FXML
	private JFXButton btnSelectImage;
	@FXML
	private ImageView imgPerfil;
	@FXML
	private ImageView imgHuella;
	@FXML
	private JFXButton btnRegistro;

	RegistroModel registroM = new RegistroModel();
	 ConexionArduino con = new ConexionArduino();	

	@FXML
	void btnBorrarOnAction(ActionEvent event) {
		txtNombre.setText("");
		txtApUno.setText("");
		txtApDos.setText("");
		txtMatricula.setText("");
	}

	@FXML
<<<<<<< HEAD
	void btnCancelarOnAction(ActionEvent event) {
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
		
=======
	void btnCancelarOnAction(ActionEvent event) throws IOException {
		con.CerrarConexion();
		Stage st = (Stage) btnCancelar.getScene().getWindow();
		st.close();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tesji/huella/login/LoginView.fxml"));
		BorderPane root1 = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1, 704, 443));
		stage.setTitle("Nuevo usuario 3041");
		stage.show();
		stage.centerOnScreen();
>>>>>>> 29f183f8dd6927e7e4b7f942100711ba9427877d
	}

	@FXML
	void btnGuardarOnAction(ActionEvent event) {
		try {
			Conexion crear = new Conexion();

			if (txtNombre.getText().trim().length()!=0) {
				if (txtApUno.getText().trim().length()!=0) {
					if (txtApDos.getText().trim().length()!=0) {
						if (txtMatricula.getText().trim().length()!=0) {
							if (txtMatricula.getText().trim().length()<=10) {
								crear.crear(txtNombre.getText().trim(), txtApUno.getText().trim(), txtApDos.getText().trim(),
										txtMatricula.getText().trim(), registroM.convertir());
								Stage stage = (Stage) btnGuardar.getScene().getWindow();
								stage.close();
								con.CerrarConexion();
							}else 
								JOptionPane.showMessageDialog(null, "Coloca una matricula menor igual de 10 digitos", "Matricula", JOptionPane.ERROR_MESSAGE);
						}else 
							JOptionPane.showMessageDialog(null, "Coloca una matricula menor igual de 10 digitos", "Matricula", JOptionPane.ERROR_MESSAGE);
					}else 
						JOptionPane.showMessageDialog(null, "Solo admite letras", "Apellido 2", JOptionPane.ERROR_MESSAGE);
				}else 
					JOptionPane.showMessageDialog(null, "Solo admite letras", "Apellido 1", JOptionPane.ERROR_MESSAGE);
			}else 
				JOptionPane.showMessageDialog(null, "Solo admite letras", "Nombre", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("No se pudo hacer el registro");
		}
	}
<<<<<<< HEAD

	@FXML
	void btnRegistroOnAction(ActionEvent event) {
		con.registroHuella();
	}

=======
	
	  @FXML
	    void btnRegistroOnAction(ActionEvent event) {
		 
			con.registroHuella();
	  
	    }
	
>>>>>>> 29f183f8dd6927e7e4b7f942100711ba9427877d
	@FXML
	void imgHuellaOnmouseClicked(ActionEvent event) {

	}

	@FXML
	void btnSelectImageOnAction(ActionEvent event) {
		imgPerfil.setImage(registroM.seleccionarImage());
	}

}
