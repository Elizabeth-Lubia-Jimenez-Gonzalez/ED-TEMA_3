package com.lubiasystem.estructurademenu.controller;

import com.lubiasystem.estructurademenu.clases.Lista;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListaController {
    @FXML private TextField txtEntrada, txtIndice;
    @FXML private TextArea txtResultado;
    //Botón para controlar la ventana y regresar
    @FXML private Button btnRegresar;

    private Lista lista = new Lista();

    @FXML
    private void ejecutarAgregar() {
        lista.agregar(txtEntrada.getText());
        txtResultado.setText("Agregado.\n" + lista.mostrar());

        // --- NUEVO: Limpia las entradas ---
        limpiarCampos();
    }

    @FXML
    private void ejecutarEliminar() {
        try {
            int idx = Integer.parseInt(txtIndice.getText());
            lista.eliminar(idx);
            txtResultado.setText("Índice eliminado.\n" + lista.mostrar());
        } catch (NumberFormatException e) {
            txtResultado.setText("ERROR: Por favor escribe un número válido en el campo 'Índice'.");
        }

        //NUEVO: Limpia las entradas
        limpiarCampos();
    }

    @FXML
    private void ejecutarBuscar() {
        txtResultado.setText("Encontrado en índice: " + lista.buscar(txtEntrada.getText()));

        //Limpia las entradas
        limpiarCampos();
    }

    @FXML private void ejecutarMostrar() { txtResultado.setText(lista.mostrar()); }

    @FXML
    private void ejecutarModificar() {
        try {
            int idx = Integer.parseInt(txtIndice.getText());
            lista.modificar(idx, txtEntrada.getText());
            txtResultado.setText("Modificado.\n" + lista.mostrar());
        } catch (NumberFormatException e) {
            txtResultado.setText("ERROR: Por favor escribe un número válido en el campo 'Índice' para modificar.");
        }

        //Limpia las entradas
        limpiarCampos();
    }

    //Metodo auxiliar para limpiar los cuadros de texto
    private void limpiarCampos() {
        txtEntrada.setText("");
        txtIndice.setText("");
        // Regresa el cursor al campo principal
        txtEntrada.requestFocus();
    }

    //Cierra la lista y abre una ventana de menú limpia y en su tamaño original
    @FXML
    private void ejecutarRegresar() {
        try {
            // Buscamos el archivo del menú principal
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
            //Título oficial del menú principal
            menuStage.setTitle("ESTRUCTURAS");
            menuStage.setScene(new Scene(root));
            menuStage.show();

            //CERRAMOS por completo la ventana actual de Listas para que no se quede atrás
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            System.out.println("Error al regresar al menú principal (Lista): " + e.getMessage());
            e.printStackTrace();
        }
    }
}
