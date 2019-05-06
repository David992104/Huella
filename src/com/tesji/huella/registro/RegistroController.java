package com.tesji.huella.registro;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegistroController {

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
    private BorderPane idBorderpane;

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

    }

}
