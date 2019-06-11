package com.tesji.huella;

import javax.swing.JOptionPane;

import com.tesji.huella.conexion.Conexion;
import com.tesji.huella.conexion.ConexionArduino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		byte resp;
		try {
			Conexion con = new Conexion();
			 //new ConexionArduino();
			do {
				resp = 1;
				if (con.prepararBaseDatos()) {
					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("/com/tesji/huella/login/LoginView.fxml"));
					BorderPane root1 = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1, 645, 400));
					stage.setTitle("Inicio 3041");
					stage.centerOnScreen();
					stage.show();
					
				} else {
					JOptionPane.showMessageDialog(null, "No tienes conexion a internet");
					resp = (byte) JOptionPane.showConfirmDialog(null, "Reintentar ?");
				}
			} while (resp == 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
