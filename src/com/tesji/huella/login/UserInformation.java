package com.tesji.huella.login;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

public class UserInformation {
	
	LoginModel lm = new LoginModel();
	
	public void information() {
		String nombre = lm.getNombre();
		String apellidos = lm.getApellidos();
		String matricula = lm.getMatricula();
		javafx.scene.image.Image img = lm.getImg();
		
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Informacion de usuario");
		dialog.setHeaderText("Bienvenido \n"
				+ nombre + apellidos + "\n"
				+ "Matricula " + matricula);
		dialog.setGraphic(new ImageView(img));
		ButtonType bt = new ButtonType("Aceptar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(bt);
		dialog.showAndWait();

	}
	


}
