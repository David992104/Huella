package com.tesji.huella.registro;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	void btnCancelarOnAction(ActionEvent event) {
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnGuardarOnAction(ActionEvent event) {
		try {
			Conexion crear = new Conexion();
			crear.crear(txtNombre.getText().trim(), txtApUno.getText(), txtApDos.getText().trim(),
					txtMatricula.getText().trim(), registroM.convertir());
			Stage stage = (Stage) btnGuardar.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			System.out.println("No se pudo hacer el registro");
		}
	}
	
	  @FXML
	    void btnRegistroOnAction(ActionEvent event) {
			con.registroHuella();
	    }
	
	@FXML
	void imgHuellaOnmouseClicked(ActionEvent event) {
		
	}

	@FXML
	void btnSelectImageOnAction(ActionEvent event) {
		imgPerfil.setImage(registroM.seleccionarImage());
	}

}
