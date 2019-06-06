package com.tesji.huella.login;

import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.tesji.huella.conexion.Conexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private JFXButton btnSalir;

    @FXML
    private JFXButton btnNuevo;
    
    @FXML
    private Button btn;
    
    @FXML
    void btnNuevoOnAction(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tesji/huella/registro/RegistroView.fxml"));
			BorderPane root1 = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1, 645, 400));
			stage.setTitle("Nuevo usuario 3041");
			stage.show();
			stage.centerOnScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnOnAction(ActionEvent event) {
    	
    }

    @FXML
    void btnSalirOnAction(ActionEvent event) throws SQLException {
    	System.exit(0);
    	Conexion con = new Conexion();
    	con.cerrar();
    }

}
