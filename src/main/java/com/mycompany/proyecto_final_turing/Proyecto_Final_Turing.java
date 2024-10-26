
package com.mycompany.proyecto_final_turing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cesar
 */

public class Proyecto_Final_Turing {

     private String[] Cinta;           // Cinta
    private int Cabezal;                // Cabezal de lectura/escritura
    private String Estadoactual;     // Estado actual
    private String Estado_aceptacion;     // Estado inicial
    private String acceptState;      // Estado de aceptación
    private Map<String, Transition> transitions; // Transiciones

    // Clase interna para representar una transición
    class Transition {
        String Siguientestado;
        char escribirSimbolo;
        int moverDireccion; // -1 para moverse a la izquierda, 1 para la derecha

        Transition(String nextState, char writeSymbol, int moveDirection) {
            this.Siguientestado = nextState;
            this.escribirSimbolo = writeSymbol;
            this.moverDireccion = moveDirection;
        }
    }

    // Constructor
    public Proyecto_Final_Turing(String startState, String acceptState) {
        this.Cinta = new String[100];  // Tamaño inicial de la cinta
        this.Cabezal = 50;                // El cabezal inicia en el medio de la cinta
        this.Estado_aceptacion = startState; // Guardar el estado inicial
        this.Estadoactual = startState;
        this.acceptState = acceptState;
        this.transitions = new HashMap<>();
    }

    // Método para agregar una transición
    public void addTransition(String state, char readSymbol, String nextState, char writeSymbol, int moveDirection) {
        String key = state + "," + readSymbol;
        transitions.put(key, new Transition(nextState, writeSymbol, moveDirection));
    }

    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
