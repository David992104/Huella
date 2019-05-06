package com.tesji.huella.registro;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    void btnBorrarOnAction(ActionEvent event) {
    	txtNombre.setText("");
    	txtApUno.setText("");
    	txtApDos.setText("");
    	txtMatricula.setText("");
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btnGuardarOnAction(ActionEvent event) {

    }

}
