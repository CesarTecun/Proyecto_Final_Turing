package com.mycompany.proyecto_final_turing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maquina_Turning {
//Cesar
    private String[] Cinta;  // cinta
    private int Cabezal;
    private String EstadoActual;
    private String EstadoInicial;
    private String EstadoAceptado;
    private Map<String, Transicion> Transicion;

    class Transicion {

        String EstadoSiguiente; //Definir los primeros estados
        char SimboloEscrito;    //Posiciona el simbolo escrito
        int Direccion_Movimiento; //indica si va er 1 =Derecha o -1 Izquierda
//Cesar
        
        //Determina las transiciones para realizar en la maquina
        Transicion(String Estadosiguiente, char Simboloescrito, int Direccion_movimiento) {
            this.EstadoSiguiente = Estadosiguiente;
            this.SimboloEscrito = Simboloescrito;
            this.Direccion_Movimiento = Direccion_movimiento;
        }
    }
    
    //Utilizamos las partes en formato de constructor para ser utilizada en mis otros metos
    //Incluso en la interfaz

    public Maquina_Turning(String Estadoinicial, String Estadoaceptado) {
        this.Cinta = new String[100];
        this.Cabezal = 50;  // posición inicial del cabezal
        this.EstadoInicial = Estadoinicial;
        this.EstadoActual = Estadoinicial;
        this.EstadoAceptado = Estadoaceptado;
        this.Transicion = new HashMap<>(); //Hasea cada transicion en un mapa
    }

    
    //Añadimos la transicion dependiendo lo que realice
    public void addTransition(String Estado, char Simbolo_leido, String Estadosiguiente, char Simboloescrito, int Direccion_movimiento) {
        String llave = Estado + "," + Simbolo_leido;
        Transicion.put(llave, new Transicion(Estadosiguiente, Simboloescrito, Direccion_movimiento));
    }

    
    //Ponerlo en la Cinta para realizar un proceso
    public void setInput(String input) {
        this.Cinta = new String[100]; // reinicia la cinta
        this.Cabezal = 50; // reinicia la posición del cabezal
        for (int i = 0; i < input.length(); i++) {
            Cinta[Cabezal + i] = String.valueOf(input.charAt(i));
        }
        this.EstadoActual = this.EstadoInicial; // reinicia el estado actual
    }

    
    //Metodo Run  realiza un recorrido en la cinta para poder mostrarse en mi JtextField
    //ademas simula una cinta con _ para ser rellenada para cada proceso realizado
    public boolean run(StringBuilder registroPasos, List<String> estadosList) {
        while (!EstadoActual.equals(EstadoAceptado)) {
            char Simbolo_leido = Cinta[Cabezal] != null ? Cinta[Cabezal].charAt(0) : '_';
            String llave = EstadoActual + "," + Simbolo_leido;

            // Registrar el contenido de la cinta (sin el estado actual)
            StringBuilder cintaActual = new StringBuilder();
            cintaActual.append("Cinta: ");
            for (int i = 0; i < Cinta.length; i++) {
                if (i == Cabezal) {
                    cintaActual.append("[ ").append(Cinta[i] != null ? Cinta[i] : "_").append(" ] "); // Cabezal marcado
                } else {
                    cintaActual.append(Cinta[i] != null ? Cinta[i] : "_").append(" ");
                }
            }
            cintaActual.append("\n");

            // Registrar el estado actual solo para el JTextField
            registroPasos.append(" Estado actual: ").append(EstadoActual).append("\n");

            if (!Transicion.containsKey(llave)) {
                registroPasos.append(cintaActual).append(" No hay otra transicion: cadena RECHAZADA.\n");
                return false;
            }

            Transicion transicion = Transicion.get(llave);
            Cinta[Cabezal] = String.valueOf(transicion.SimboloEscrito);

            // Registrar la transición
            String movimiento = transicion.Direccion_Movimiento == 1 ? " Derecha →" : " Izquierda ←";
            cintaActual.append(" Escribiendo: ").append(transicion.SimboloEscrito).append(", Movimiento: ").append(movimiento).append("\n");

            // Agregar a registro de pasos
            registroPasos.append(cintaActual);

            Cabezal += transicion.Direccion_Movimiento;
            EstadoActual = transicion.EstadoSiguiente;
        }

        // Registrar el estado final (solo para el JTextField)
        registroPasos.append(" Estado actual: ").append(EstadoActual).append("\n");

        // Registrar el contenido final de la cinta
        StringBuilder cintaFinal = new StringBuilder();
        cintaFinal.append("Cinta: ");
        for (int i = 0; i < Cinta.length; i++) {
            if (i == Cabezal) {
                cintaFinal.append("[ ").append(Cinta[i] != null ? Cinta[i] : "_").append(" ] ");
            } else {
                cintaFinal.append(Cinta[i] != null ? Cinta[i] : "_").append(" ");
            }
        }
        registroPasos.append(cintaFinal).append("\n");

        // Verificar si se alcanzó el estado de aceptación y agregar el mensaje "CADENA ACEPTADA"
        if (EstadoActual.equals(EstadoAceptado)) {
            registroPasos.append("CADENA ACEPTADA.\n");
        }

        return EstadoActual.equals(EstadoAceptado);
    //Devolvemos El estado actual solo si es igual al estadoAceptado
        //Es decir el estado final
    }

}
