package com.lubiasystem.estructurademenu.controller;

import com.lubiasystem.estructurademenu.clases.Pila;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PilaController {
    @FXML private TextField txtEntrada;
    @FXML private TextArea txtResultado;
    //Asegúrate de ponerle este fx:id a tu botón en Scene Builder / FXML
    @FXML private Button btnRegresar;
    private Pila pila = new Pila();

    @FXML
    private void ejecutarPush() {
        pila.push(txtEntrada.getText());
        txtResultado.setText("Insertado.\n" + pila.mostrar());

        //Limpia el cuadro de texto y le devuelve el enfoque
        txtEntrada.setText("");
        txtEntrada.requestFocus();
    }

    @FXML private void ejecutarPop() { String el = pila.pop(); txtResultado.setText("Eliminado: " + el + "\n" + pila.mostrar()); }
    @FXML private void ejecutarPeek() { txtResultado.setText("En el tope: " + pila.peek()); }
    @FXML private void ejecutarMostrar() { txtResultado.setText(pila.mostrar()); }
    @FXML private void ejecutarLimpiar() { pila.limpiar(); txtResultado.setText("Pila vaciada."); }

    @FXML
    private void ejecutarRegresar() {
        try {
            //Buscamos el archivo del menú principal
            java.net.URL url = getClass().getResource("/com/lubiasystem/estructurademenu/menu-view.fxml");

            if (url == null) {
                url = getClass().getResource("menu-view.fxml");
            }

            if (url == null) {
                url = getClass().getResource("/menu-view.fxml");
            }

            if (url == null) {
                System.err.println("ERROR: No se pudo encontrar menu-view.fxml");
                return;
            }

            //Cargamos el FXML en una escena totalmente nueva
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage menuStage = new Stage();
            //Título para la ventana del menú
            menuStage.setTitle("ESTRUCTURAS");
            menuStage.setScene(new Scene(root));
            menuStage.show();

            //CERRAMOS por completo la ventana actual (la de la Pila) para que no se quede flotando
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            System.out.println("Error al regresar al menú principal: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
