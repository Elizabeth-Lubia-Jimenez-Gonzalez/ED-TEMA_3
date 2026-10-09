package com.lubiasystem.estructurademenu.controller;

import com.lubiasystem.estructurademenu.clases.Cola;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ColaController {
    @FXML private TextField txtEntrada;
    @FXML private TextArea txtResultado;
    // Botón para interactuar con la ventana y regresar
    @FXML private Button btnRegresar;


    private Cola cola = new Cola();

    @FXML
    private void ejecutarEnqueue() {
        cola.enqueue(txtEntrada.getText());
        txtResultado.setText("Encolado.\n" + cola.mostrar());

        //Limpia el cuadro de texto y recupera el cursor
        txtEntrada.setText("");
        txtEntrada.requestFocus();
    }

    @FXML
    private void ejecutarDequeue() {
        String el = cola.dequeue();
        if (el == null || el.isEmpty()) {
            txtResultado.setText("La cola ya está vacía.\n" + cola.mostrar());
        } else {
            txtResultado.setText("Desencolado: " + el + "\n" + cola.mostrar());
        }
    }

    @FXML private void ejecutarPeek() { txtResultado.setText("Al frente: " + cola.peek()); }
    @FXML private void ejecutarMostrar() { txtResultado.setText(cola.mostrar()); }
    @FXML private void ejecutarTamaño() { txtResultado.setText("Tamaño de la cola: " + cola.tamaño()); }

    //Cierra la cola y abre una ventana de menú limpia y en su tamaño original
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

            //Cargamos el FXML en una ventana totalmente nueva
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage menuStage = new Stage();
            // Título oficial del menú principal
            menuStage.setTitle("ESTRUCTURAS");
            menuStage.setScene(new Scene(root));
            menuStage.show();

            //CERRAMOS por completo la ventana actual de Colas para evitar duplicados
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            System.out.println("Error al regresar al menú principal (Cola): " + e.getMessage());
            e.printStackTrace();
        }
    }
}
