package com.lubiasystem.estructurademenu.clases;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<String> queue = new LinkedList<>();

    //Enqueue (Insertar)
    public void enqueue(String elemento) {
        queue.add(elemento);
    }
    //Dequeue (Eliminar)
    public String dequeue() {
        return queue.isEmpty() ? "Cola Vacía" : queue.poll();
    }
    //Peek (Ver frente)
    public String peek() {
        return queue.isEmpty() ? "Cola Vacía" : queue.peek();
    }
    //Mostrar todo
    public String mostrar() {
        return queue.toString();
    }
    //Tamaño
    public int tamaño() {
        return queue.size();
    }
}
