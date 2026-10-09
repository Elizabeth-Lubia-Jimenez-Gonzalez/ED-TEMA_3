package com.lubiasystem.estructurademenu.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.net.URL;

public class MenuController {
    @FXML private Button btnPila, btnCola, btnLista;

    @FXML
    private void abrirPila() {
        cambiarVentana("/com/lubiasystem/estructurademenu/pila-view.fxml", "clases Pila");
    }

    @FXML
    private void abrirCola() {
        cambiarVentana("/com/lubiasystem/estructurademenu/cola-view.fxml", "clases Cola");
    }

    @FXML
    private void abrirLista() {
        cambiarVentana("/com/lubiasystem/estructurademenu/lista-view.fxml", "clases Lista");
    }

    private void cambiarVentana(String fxmlPath, String titulo) {
        try {
            URL fxmlUrl = Thread.currentThread().getContextClassLoader().getResource(fxmlPath.substring(1));

            if (fxmlUrl == null) {
                fxmlUrl = getClass().getResource(fxmlPath);
            }

            if (fxmlUrl == null) {
                System.err.println("ERROR CRÍTICO: El archivo FXML no existe físicamente en la ruta: src/main/resources" + fxmlPath);
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));

            //Obtenemos la ventana actual del Menú y la ocultamos
            Stage menuStage = (Stage) btnPila.getScene().getWindow();
            menuStage.hide();

            //Cuando el usuario cierre la ventana del módulo con la "X", volvemos a mostrar el menú
            stage.setOnCloseRequest(e -> menuStage.show());

            stage.show();
        } catch (Exception e) {
            System.err.println("Ocurrió un problema interno al procesar el archivo: " + fxmlPath);
            e.printStackTrace();
        }
    }
}
