package com.tesji.huella.datosImp;

import com.tesji.huella.login.LoginModel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class datImpController {
	 LoginModel i= new LoginModel();
    @FXML
    private ImageView imgFoto;
   
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    public ImageView getImgFoto() {
		return imgFoto;
		
	}

	public void setImgFoto(ImageView imgFoto) {
		this.imgFoto = imgFoto;
		//setImgFoto();
	}

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(TextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public TextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(TextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public TextField getTxtMatricula() {
		return txtMatricula;
	}

	public void setTxtMatricula(TextField txtMatricula) {
		this.txtMatricula = txtMatricula;
	}

	@FXML
    private TextField txtMatricula;

}
