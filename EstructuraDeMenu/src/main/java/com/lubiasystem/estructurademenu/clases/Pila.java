package com.lubiasystem.estructurademenu.clases;

import java.util.Stack;

public class Pila {
    private Stack<String> stack = new Stack<>();

    //Push (Insertar)
    public void push(String elemento) {
        stack.push(elemento);
    }
    //Pop (Eliminar)
    public String pop() {
        return stack.isEmpty() ? "Pila Vacía" : stack.pop();
    }
    //Peek (Ver tope)
    public String peek() { return stack.isEmpty() ? "Pila Vacía" : stack.peek(); }
    //Mostrar
    public String mostrar() { return stack.toString(); }
    //Limpiar
    public void limpiar() { stack.clear(); }
}