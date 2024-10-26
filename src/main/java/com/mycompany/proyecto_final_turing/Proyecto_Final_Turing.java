
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

    
    public class Turning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear la máquina de Turing
        System.out.print("Introduce el estado inicial: ");
        String startState = scanner.nextLine();
        System.out.print("Introduce el estado de aceptación: ");
        String acceptState = scanner.nextLine();

        Proyecto_Final_Turing tm = new Proyecto_Final_Turing(startState, acceptState);

        // Pedir al usuario las transiciones con encabezados
        System.out.println("\n--- Definir transiciones ---");
        System.out.println("Introduce los datos para cada transición:");
        System.out.println("Escribe 'fin' como estado actual cuando termines de agregar transiciones.");

        while (true) {
            System.out.println("\n-- Nueva Transición --");
            System.out.print("Estado actual: ");
            String currentState = scanner.nextLine();
            if (currentState.equalsIgnoreCase("fin")) {
                break;
            }
            System.out.print("Símbolo leído: ");
            char readSymbol = scanner.nextLine().charAt(0);
            System.out.print("Nuevo estado: ");
            String nextState = scanner.nextLine();
            System.out.print("Símbolo a escribir: ");
            char writeSymbol = scanner.nextLine().charAt(0);
            System.out.print("Movimiento (1 para derecha, -1 para izquierda): ");
            int moveDirection = Integer.parseInt(scanner.nextLine());

            // Agregar la transición
            tm.addTransition(currentState, readSymbol, nextState, writeSymbol, moveDirection);
        }

        String opcion;
        do {
            // Pedir la cinta de entrada al usuario
            System.out.print("\nIntroduce la cadena a validar (usa '_' para espacios vacíos): ");
            String input = scanner.nextLine();

            // Definir la cinta de entrada
            tm.setInput(input);

            // Ejecutar la máquina
            boolean result = tm.run();

            // Mostrar el resultado
            if (result) {
                System.out.println("Cadena aceptada.");
            } else {
                System.out.println("Cadena rechazada.");
            }

            // Mostrar la cinta final
            tm.printTape();

            // Preguntar si desea validar otra cadena
            System.out.print("¿Quieres validar otra cadena? (s/n): ");
            opcion = scanner.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("Programa terminado.");
        scanner.close();
    }
}
}
