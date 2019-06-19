package com.tesji.huella.login;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.tesji.huella.conexion.Conexion;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML
	private JFXButton btnSalir;
	@FXML
	private JFXButton btnNuevo;
	@FXML
	private Button btn;

	LoginModel lm = new LoginModel();
	/*AnimationTimer user = new AnimationTimer() {
		@Override
		public void handle(long now) {
			lm.busqueda();
		}
	};*/
	
	@FXML
	void btnNuevoOnAction(ActionEvent event) {
		try {
			lm.setPulso(false);
			//user.stop();
			lm.cerrarCon();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tesji/huella/registro/RegistroView.fxml"));
			BorderPane root1 = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1, 704, 443));
			stage.setTitle("Nuevo usuario 3041");
			stage.show();
			stage.centerOnScreen();
			
			Stage este = (Stage) btnNuevo.getScene().getWindow();
			este.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	void btnOnAction(ActionEvent event) throws IOException {
		lm.busqueda();
	}
	
	@FXML
	void btnSalirOnAction(ActionEvent event) throws SQLException {
		System.exit(0);
		Conexion con = new Conexion();
		con.cerrar();
		this.lm.cerrarCon();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//user.start();
	}

}
