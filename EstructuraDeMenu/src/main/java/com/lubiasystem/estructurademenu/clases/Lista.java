package com.lubiasystem.estructurademenu.clases;

import java.util.ArrayList;

public class Lista {
    private ArrayList<String> lista = new ArrayList<>();

    //Agregar al final
    public void agregar(String elemento) {
        lista.add(elemento);
    }
    //Eliminar por índice
    public boolean eliminar(int indice) {
        if(indice >= 0 && indice < lista.size()) {
            lista.remove(indice); return true;
        }
        return false;
    }
    //Buscar elemento
    public int buscar(String elemento) {
        return lista.indexOf(elemento);
    }
    //Mostrar
    public String mostrar() {
        return lista.toString();
    }
    //Modificar elemento
    public void modificar(int indice, String nuevo) {
        if(indice >= 0 && indice < lista.size()) lista.set(indice, nuevo);
    }
}