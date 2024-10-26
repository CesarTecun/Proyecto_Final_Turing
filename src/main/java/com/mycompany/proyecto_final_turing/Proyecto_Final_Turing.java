
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

    // Método para configurar la cinta inicial
    public void setInput(String input) {
        // Limpiar la cinta antes de introducir una nueva cadena
        this.Cinta = new String[100];
        this.Cabezal = 50;
        for (int i = 0; i < input.length(); i++) {
            // Reemplazar el símbolo de espacio vacío con el carácter correspondiente
            Cinta[Cabezal + i] = String.valueOf(input.charAt(i));
        }
        // Reiniciar el estado actual al inicial
        this.Estadoactual = this.Estado_aceptacion;
    }

    // Método para ejecutar la máquina de Turing
    public boolean run() {
        while (!Estadoactual.equals(acceptState)) {
            char readSymbol = Cinta[Cabezal] != null ? Cinta[Cabezal].charAt(0) : '_'; // Leer símbolo, _ como vacío
            String key = Estadoactual + "," + readSymbol;

            if (!transitions.containsKey(key)) {
                // Si no hay transiciones válidas, la cadena es rechazada
                return false;
            }

            Transition transition = transitions.get(key);
            // Escribir símbolo en la cinta
            Cinta[Cabezal] = String.valueOf(transition.escribirSimbolo);
            // Mover el cabezal
            Cabezal += transition.moverDireccion;
            // Cambiar de estado
            Estadoactual = transition.Siguientestado;
        }

        return Estadoactual.equals(acceptState); // Solo aceptamos si llegamos al estado de aceptación
    }
    
    //Version Jesda 
    // Mostrar el contenido de la cinta con la posición del cabezal
    public void printTape() {
        for (int i = 0; i < Cinta.length; i++) {
            // Mostrar el símbolo actual o '_' para espacios vacíos
            System.out.print(Cinta[i] != null ? Cinta[i] : "_");
        }
        System.out.println();

        // Mostrar la posición del cabezal
        for (int i = 0; i < Cinta.length; i++) {
            // Mostrar un marcador '^' en la posición del cabezal
            if (i == Cabezal) {
                System.out.print("^");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
