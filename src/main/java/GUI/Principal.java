package GUI;

import com.mycompany.proyecto_final_turing.Maquina_Turning;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Principal extends javax.swing.JFrame {

    private Maquina_Turning maquina_Turning;
    private int Indice_Transicion = 0; // Índice de la transición actual
    private Maquina_Turning maquina; // Instancia de la máquina de Turing
    private String[] pasos; // Arreglo para almacenar los pasos
    private int pasoActual; // Índice del paso actual
    private boolean primerClick = true;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Proyecto_Final");
        // Desactiva el arrastre de columnas
        Tabla.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Estado_Final = new javax.swing.JTextField();
        Estado_Inicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        JValidar = new javax.swing.JButton();
        cadenaEntrada = new javax.swing.JTextField();
        btnEliminarTransicion = new javax.swing.JButton();
        btnAgregarTransicion1 = new javax.swing.JButton();
        JExportar = new javax.swing.JButton();
        JImportar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Siguiente = new javax.swing.JButton();
        EstadoActualField = new javax.swing.JTextField();
        Cinta = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Estado Inicial:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, -1));

        Estado_Final.setBorder(null);
        jPanel1.add(Estado_Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 40, 20));

        Estado_Inicial.setBorder(null);
        jPanel1.add(Estado_Inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 40, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Actual:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 50, -1));

        Tabla.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tabla.setForeground(new java.awt.Color(0, 0, 0));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Estado actual", "Símbolo leído", "Nuevo estado", "Símbolo a escribir:", "Movimiento (1=D, -1 =I)"
            }
        ));
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 690, 200));

        JValidar.setText("Validar");
        JValidar.setBorder(null);
        JValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JValidarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JValidarMouseExited(evt);
            }
        });
        JValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JValidarActionPerformed(evt);
            }
        });
        jPanel1.add(JValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 90, 30));

        cadenaEntrada.setForeground(new java.awt.Color(102, 102, 102));
        cadenaEntrada.setText("Ingrese una cadena");
        cadenaEntrada.setBorder(null);
        cadenaEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cadenaEntradaMousePressed(evt);
            }
        });
        cadenaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadenaEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(cadenaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 190, 20));

        btnEliminarTransicion.setText("Eliminar Transicion");
        btnEliminarTransicion.setBorder(null);
        btnEliminarTransicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarTransicionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarTransicionMouseExited(evt);
            }
        });
        btnEliminarTransicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTransicionActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTransicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 130, 30));

        btnAgregarTransicion1.setText("Agregar Transicion");
        btnAgregarTransicion1.setBorder(null);
        btnAgregarTransicion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarTransicion1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarTransicion1MouseExited(evt);
            }
        });
        btnAgregarTransicion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTransicion1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarTransicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 130, 30));

        JExportar.setText("Exportar");
        JExportar.setBorder(null);
        JExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JExportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JExportarMouseExited(evt);
            }
        });
        JExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JExportarActionPerformed(evt);
            }
        });
        jPanel1.add(JExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 90, 30));

        JImportar.setText("Importar");
        JImportar.setBorder(null);
        JImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JImportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JImportarMouseExited(evt);
            }
        });
        JImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JImportarActionPerformed(evt);
            }
        });
        jPanel1.add(JImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 100, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 880, -1));

        Siguiente.setText("Siguiente");
        Siguiente.setBorder(null);
        Siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiguienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiguienteMouseExited(evt);
            }
        });
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 80, 30));

        EstadoActualField.setEditable(false);
        EstadoActualField.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        EstadoActualField.setBorder(null);
        EstadoActualField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EstadoActualField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstadoActualFieldMouseClicked(evt);
            }
        });
        jPanel1.add(EstadoActualField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 30, 20));

        Cinta.setBackground(new java.awt.Color(230, 230, 230));
        Cinta.setForeground(new java.awt.Color(0, 0, 0));
        Cinta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Cinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 620, 70));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 190, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 40, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 40, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 30, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estado Final:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JImportarActionPerformed
        // Crear un JFileChooser para seleccionar el archivo CSV a importar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar desde");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv")); // Filtrar solo archivos CSV

        // Abrir el diálogo para seleccionar el archivo
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileToOpen))) {
                String line;
                boolean isFirstLine = true;

                // Limpiar la tabla antes de importar
                DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                model.setRowCount(0); // Limpia las filas existentes

                // Leer el estado inicial y final
                if ((line = reader.readLine()) != null) {
                    Estado_Inicial.setText(line); // Asignar estado inicial
                }
                if ((line = reader.readLine()) != null) {
                    Estado_Final.setText(line); // Asignar estado final
                }

                // Leer las filas de la tabla
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(","); // Dividir la línea en partes
                    if (data.length == 5) {
                        model.addRow(data); // Añadir la fila a la tabla
                    }
                }

                JOptionPane.showMessageDialog(this, "Datos exportados correctamente de:  " + fileToOpen.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Tuvimos un error al cargar :  " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_JImportarActionPerformed

    private void JExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JExportarActionPerformed
        // Crear un JFileChooser para seleccionar la ubicación y nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv")); // Filtrar solo archivos CSV

        // Abrir el diálogo para seleccionar el archivo
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Asegurarse de que el archivo tenga la extensión .csv
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".csv")) {
                filePath += ".csv"; // Añadir extensión si no está presente
            }

            // Comprobar si el archivo ya existe
            File file = new File(filePath);
            if (file.exists()) {
                // Preguntar si se desea sobrescribir
                int overwrite = JOptionPane.showConfirmDialog(this,
                        "El archivo ya existe. ¿Quieres sobrescribirlo?", "Confirmar sobrescritura",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                // Si el usuario no confirma, salir del método
                if (overwrite != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Si el archivo no existe o se confirmó la sobrescritura, continuar guardando
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Escribir solo los datos (sin encabezados)
                writer.write(Estado_Inicial.getText());
                writer.newLine();
                writer.write(Estado_Final.getText());
                writer.newLine();

                // Obtener el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) Tabla.getModel();

                // Recorrer las filas de la tabla y escribir cada una en el archivo
                for (int i = 0; i < model.getRowCount(); i++) {
                    String estadoActual = (String) model.getValueAt(i, 0);
                    String simboloLeido = (String) model.getValueAt(i, 1);
                    String nuevoEstado = (String) model.getValueAt(i, 2);
                    String simboloEscribir = (String) model.getValueAt(i, 3);
                    String movimiento = (String) model.getValueAt(i, 4);

                    // Escribir los datos de la fila
                    writer.write(estadoActual + "," + simboloLeido + "," + nuevoEstado + "," + simboloEscribir + "," + movimiento);
                    writer.newLine(); // Nueva línea después de cada fila
                }

                JOptionPane.showMessageDialog(this, "Datos exportados correctamente a " + filePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_JExportarActionPerformed

    private void btnAgregarTransicion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTransicion1ActionPerformed
        // Validar la última fila antes de agregar una nueva
        int ultimaFila = Tabla.getRowCount() - 1;

        // Obtener los valores de la última fila
        String estadoActual = (String) Tabla.getValueAt(ultimaFila, 0);
        String simboloLeidoStr = (String) Tabla.getValueAt(ultimaFila, 1);
        String nuevoEstado = (String) Tabla.getValueAt(ultimaFila, 2);
        String simboloEscribirStr = (String) Tabla.getValueAt(ultimaFila, 3);
        String movimientoStr = (String) Tabla.getValueAt(ultimaFila, 4);

        // Verificar si todos los campos de la última fila están completos
        if (estadoActual == null || simboloLeidoStr == null || nuevoEstado == null || simboloEscribirStr == null || movimientoStr == null) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de la fila actual antes de agregar una nueva.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar una nueva fila vacía
        DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
        model.addRow(new Object[]{null, null, null, null, null});
    }//GEN-LAST:event_btnAgregarTransicion1ActionPerformed

    private void btnEliminarTransicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTransicionActionPerformed
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) Tabla.getModel();

        // Verificar si hay filas en la tabla
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay transiciones para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir si no hay filas
        }

        // Obtener la fila seleccionada
        int filaSeleccionada = Tabla.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir si no se seleccionó ninguna fila
        }

        // Preguntar para evitar algun tipo de problema doble verificacion
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta transición?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar la fila seleccionada
            model.removeRow(filaSeleccionada);
        }
    }//GEN-LAST:event_btnEliminarTransicionActionPerformed

    private void JValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JValidarActionPerformed
        // Obtener el estado inicial y final desde los campos de texto
        String estadoInicial = Estado_Inicial.getText();
        String estadoFinal = Estado_Final.getText();

        // Crear una instancia de la máquina de Turing
        Maquina_Turning maquina = new Maquina_Turning(estadoInicial, estadoFinal);

        // Obtener las transiciones desde la tabla
        for (int i = 0; i < Tabla.getRowCount(); i++) {
            String estadoActual = (String) Tabla.getValueAt(i, 0);
            String simboloLeidoStr = (String) Tabla.getValueAt(i, 1);
            String nuevoEstado = (String) Tabla.getValueAt(i, 2);
            String simboloEscribirStr = (String) Tabla.getValueAt(i, 3);
            String movimientoStr = (String) Tabla.getValueAt(i, 4);

            if (estadoActual == null || simboloLeidoStr == null || nuevoEstado == null || simboloEscribirStr == null || movimientoStr == null) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todas las transiciones en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            char simboloLeido = simboloLeidoStr.charAt(0);
            char simboloEscribir = simboloEscribirStr.charAt(0);
            int movimiento = Integer.parseInt(movimientoStr);

            maquina.addTransition(estadoActual, simboloLeido, nuevoEstado, simboloEscribir, movimiento);
        }

        String cadenaEntradaTexto = cadenaEntrada.getText();

        if (cadenaEntradaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cadena para validar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        maquina.setInput(cadenaEntradaTexto);

        // Inicializar el StringBuilder para registrar pasos
        StringBuilder registroPasos = new StringBuilder();

        // Inicializar la lista para almacenar los estados
        List<String> estadosList = new ArrayList<>();

        // Vaciar el JTextArea antes de comenzar
        Cinta.setText("");

        // Ejecutar la máquina de Turing y pasar el registro de pasos y la lista de estados
        boolean esAceptada = maquina.run(registroPasos, estadosList); // Asegúrate de pasar los dos parámetros

        // Almacenar los pasos en el arreglo
        pasos = registroPasos.toString().split("\n");
        pasoActual = 0; // Reiniciar el índice de paso actual

        if (esAceptada) {
            JOptionPane.showMessageDialog(this, "La cadena ha sido aceptada.");
        } else {
            JOptionPane.showMessageDialog(this, "La cadena ha sido rechazada.");
        }
    }//GEN-LAST:event_JValidarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        if (pasos != null && pasoActual < pasos.length) {
            // Mostrar el siguiente paso de la cinta en el JTextArea
            Cinta.setText(pasos[pasoActual]);

            // Extraer y actualizar el estado actual
            // Asumimos que " Estado actual: X" es parte del registro
            String[] lineasPaso = pasos[pasoActual].split("\n");
            for (String linea : lineasPaso) {
                if (linea.startsWith(" Estado actual:")) {
                    // Extraemos el estado y lo mostramos en el JTextField
                    String estadoActual = linea.replace(" Estado actual: ", "").trim();
                    EstadoActualField.setText(estadoActual); // Mostrar el estado actual en el JTextField
                    break;
                }
            }

            pasoActual++; // Incrementar el índice para el siguiente paso
        } else {
            JOptionPane.showMessageDialog(this, "No hay mas pasos para mostarte", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SiguienteActionPerformed

    private void cadenaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadenaEntradaActionPerformed

    }//GEN-LAST:event_cadenaEntradaActionPerformed

    private void EstadoActualFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstadoActualFieldMouseClicked

    }//GEN-LAST:event_EstadoActualFieldMouseClicked

    private void cadenaEntradaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadenaEntradaMousePressed
        // Si es la primera vez que se hace clic, borrar el texto predefinido
        if (primerClick) {
            cadenaEntrada.setText(""); // Borrar el texto predefinido
            cadenaEntrada.setForeground(Color.black); // Cambiar el color del texto
            primerClick = false; // Cambiar el estado para que no se borre el contenido nuevo
        }
    }//GEN-LAST:event_cadenaEntradaMousePressed

    private void btnAgregarTransicion1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarTransicion1MouseEntered
        btnAgregarTransicion1.setBackground(Color.white);
    }//GEN-LAST:event_btnAgregarTransicion1MouseEntered

    private void SiguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteMouseEntered
        Siguiente.setBackground(Color.white);
    }//GEN-LAST:event_SiguienteMouseEntered

    private void SiguienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteMouseExited
        Siguiente.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_SiguienteMouseExited

    private void JValidarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JValidarMouseEntered
        JValidar.setBackground(Color.white);
    }//GEN-LAST:event_JValidarMouseEntered

    private void JValidarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JValidarMouseExited
        JValidar.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_JValidarMouseExited

    private void JExportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JExportarMouseEntered
        JExportar.setBackground(Color.white);
    }//GEN-LAST:event_JExportarMouseEntered

    private void JExportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JExportarMouseExited
        JExportar.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_JExportarMouseExited

    private void JImportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JImportarMouseEntered
        JImportar.setBackground(Color.white);
    }//GEN-LAST:event_JImportarMouseEntered

    private void JImportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JImportarMouseExited
        JImportar.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_JImportarMouseExited

    private void btnEliminarTransicionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTransicionMouseEntered
        btnEliminarTransicion.setBackground(Color.white);
    }//GEN-LAST:event_btnEliminarTransicionMouseEntered

    private void btnEliminarTransicionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTransicionMouseExited
        btnEliminarTransicion.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_btnEliminarTransicionMouseExited

    private void btnAgregarTransicion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarTransicion1MouseExited
        btnAgregarTransicion1.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_btnAgregarTransicion1MouseExited

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cinta;
    private javax.swing.JTextField EstadoActualField;
    private javax.swing.JTextField Estado_Final;
    private javax.swing.JTextField Estado_Inicial;
    private javax.swing.JButton JExportar;
    private javax.swing.JButton JImportar;
    private javax.swing.JButton JValidar;
    private javax.swing.JButton Siguiente;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnAgregarTransicion1;
    private javax.swing.JButton btnEliminarTransicion;
    private javax.swing.JTextField cadenaEntrada;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
