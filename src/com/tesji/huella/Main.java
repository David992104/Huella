package com.tesji.huella;
	
import com.tesji.huella.conexion.Conexion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tesji/huella/login/LoginView.fxml"));
			BorderPane root1 = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1, 645, 400));
			stage.setTitle("Inicio 3041");
			stage.show();
			stage.centerOnScreen();
			Conexion con = new Conexion();
			con.PrepararBaseDatos();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
