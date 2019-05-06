package com.tesji.huella.registro;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.tesji.huella.conexion.Conexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void btnBorrarOnAction(ActionEvent event) {
    	txtNombre.setText("");
    	txtApUno.setText("");
    	txtApDos.setText("");
    	txtMatricula.setText("");
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
    	Stage stage =(Stage) btnCancelar.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnGuardarOnAction(ActionEvent event) {
    	try {
    	Conexion crear = new Conexion();
    	crear.conectar();
    	crear.sentencia();
    	
    	//Convertir imagen a blob
    	
    	crear.crear(txtNombre.getText(), txtApUno.getText(), txtApDos.getText().trim(), txtMatricula.getText().trim());
    	JOptionPane.showMessageDialog(null, "Registro Exitoso " + txtNombre.getText());
      	Stage stage =(Stage) btnGuardar.getScene().getWindow();
    	stage.close();
    	}catch(Exception e) {
    		System.out.println("No se pudo hacer el registro");
    	}
    }

    @FXML
    void btnSelectImageOnAction(ActionEvent event) {

    }

}
