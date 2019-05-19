package com.tesji.huella.registro;

import java.io.File;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class RegistroModel {
	
	File ruta;

	public File convertir(){
		System.out.println(ruta);
		return ruta;
	}
	
	public Image seleccionarImage() {
		FileChooser imagen = new FileChooser();
		imagen.setTitle("Escojer Imagen Perfil");

		imagen.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

		File imgFile = imagen.showOpenDialog(null);

		if (imgFile != null) {
			Image image = new Image("file:" + imgFile.getAbsolutePath());
			ruta = imgFile;
			return image;
		} else {
			return null;
		}
	}
}
