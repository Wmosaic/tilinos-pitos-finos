package Menu;
import utilFilesJava.Miscellaneous;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;

public class CapMenu extends JFrame {

   Miscellaneous Mis = new Miscellaneous();

   private ArrayList<String> dataList = new ArrayList<>();
   private boolean repeat;

   private JPanel mainPanel;
   private boolean resetPrint;

   // Declara Componentes Extras
   private JTable table;
   private JSeparator separator;
   private JTextField textField;

   //Declarar los JLabels
   private JLabel label_first;
   private JLabel label_Warning;
   private JLabel labelNotify;

   //Declarar los JButtons
   private JButton button_AddData;
   private JButton button_Close;
   private JButton button_SaveData;
   private JButton button_Print;
   private JButton button_Delete;
   private JButton button_Change;

   private String nameFile;


   /** Método para inicializar la interfaz*/
   public CapMenu(String nameFile) {
      Color[] colors = {new Color(0x6F88E4), new Color(0xB5C0DD), new Color(0xDADBE8)};
      float[] fractions = {0.0f, 0.2f, 1.0f}; // Transición de color
      mainPanel = new GradientLabel(colors, fractions, 0, GradientLabel.GradientType.LINEAR);
      mainPanel = new GradientLabel(new Color(0x6F88E4), new Color(0xDADBE8), 0);
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setTitle("Archivo: " + nameFile);
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.nameFile = nameFile;

      sizePanel(480, 380);
   }

   /** Método principal para ejecutar la interfaz */
   public boolean showDialog() {
      // Estos parámetros están como Arreglos, ya que el propósito
      // era agregar más campos de captura e impresión a la interfaz
      String[] message = {"Introduce un dato:"};
      String[] columnNames = {"Datos"};
      newComponents(message, columnNames);
      this.setVisible(true);

      actionListener();
      setupKey();
      actionWait();
      return repeat;
   }

//-------------------------------------------------COMPONENTS-----------------------------------------------------//
//----------------------------------Aquí se instancia y agregan los JComponents------------------------------------//

   public void newComponents(String[] message, String[] columnNames) {
      label_first = new JLabel(message[0]);
      label_Warning = new JLabel("");
      labelNotify = new JLabel("");

      textField = new JTextField();

      table = new JTable();
      separator = new JSeparator(JSeparator.VERTICAL);

      button_AddData = new JButton("Agregar dato");
      button_Close = new JButton("Salir");
      button_SaveData = new JButton("Guardar en archivo");
      button_Print = new JButton("Imprimir");
      button_Delete = new JButton("Eliminar");
      button_Change = new JButton("Cambiar archivo");

      addComponents1(columnNames);
   }

   private void addComponents1(String[] columnNames){
      AddComponents frame = new AddComponents(mainPanel);

      frame.addImage(0, 0, 1, 1, 0, 10, 0, 0, 2, 5, GridBagConstraints.BOTH, GridBagConstraints.CENTER, System.getProperty("user.dir") + "/src/Multimedia/" + "Imagen.png", 70, 70, new Color(0x0000000, true));

      frame.addLabel(label_first, 0, 6, 0, 0, 20, 10, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label_Warning, 0, 8, 0, 2, 2, 10, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0FFFFFF, true));
      frame.addLabel(labelNotify, 3, 11, 1, 1, 0, 10, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0FFFFFF, true));


      frame.addJTextField(textField, 0, 7, 0, 1, 0, 10, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);

      frame.addJTable(table, 3, 0, 1, 1, 10, 10, 10, 10, 2, 9, GridBagConstraints.BOTH, GridBagConstraints.CENTER, columnNames);
      frame.addJSeparator(separator, 2, 0, 1, 1, 10, 0, 10, 0, 1, 12, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, new Color(0x686868));

      //Botón Agregar
      frame.addJButton(button_AddData, 0, 9, 1, 1, 0, 10, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
      //Botón Cambiar Archivo
      frame.addJButton(button_Change, 0, 10, 1, 1, 0, 10, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
      //Botón Salir
      frame.addJButton(button_Close, 0, 11, 4, 1, 0, 10, 10, 10, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

      //Botón Guardar
      frame.addJButton(button_SaveData, 3, 9, 1, 1, 0, 10, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
      //Botón Imprimir
      frame.addJButton(button_Print, 3, 10, 1, 1, 0, 10, 0, 5, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
      //Botón Eliminar
      frame.addJButton(button_Delete, 4, 10, 1, 1, 0, 5, 0, 10, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

   }

//---------------------------------------------------STYLE------------------------------------------------------//

   /** Método para declarar el tamaño del JFrame*/
   private void sizePanel(int width, int height) {
      this.setSize(width, height);
      //  setSizes para configurar un tamaño preferente, mínimo y máximo;
      this.setPreferredSize(new Dimension(width, height));
      this.setMinimumSize(new Dimension(width, height));
      this.setMaximumSize(new Dimension(width, height));
      // setResizable para no dimensionar la ventana
      this.setResizable(false);
      setLocationRelativeTo(null);
   }

//------------------------------------------------INITIALIZERS--------------------------------------------------//

   /** Método para validar que todos los JTextField contienen números*/
   private boolean validateData() {
      TextField_Validators validator = new TextField_Validators();

      //Llama a los validadores del JTextField
      return validator.cap(textField, label_Warning);
   }

   /** Método para guardar los datos de los JTextField en las variables*/
   private void saveData() {
      // Si se imprimió el archivo, entonces esta condicional resetea los
      // valores para que no haya problemas al agregar nuevos datos
      if (resetPrint){
         clearTable();
         dataList.clear();
         resetPrint = false;
      }

      // Se agregan los datos a un ArrayList para el momento en el
      // que el usuario quiera guardarlos en archivo
      String dato = textField.getText();
      textField.setText("");
      dataList.add(dato);

      setTable(dato);
   }

   /** Método para guardar y visualizar los datos en un JTable*/
   public void setTable(String data1) {
      // Obtener el modelo actual de la tabla
      DefaultTableModel model = (DefaultTableModel) table.getModel();

      // Agregar la fila con los datos proporcionados
      model.addRow(new Object[]{data1});
   }

   /** Método para limpiar los datos del JTable */
   public void clearTable() {
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      // Limpiar todas las filas del modelo
      model.setRowCount(0);
   }

//--------------------------------------------------ACTIONS-----------------------------------------------------//

   /** Método para esperar que se presione un botón*/
   private void actionWait() {
      synchronized (this) {
         try {
            wait();
         } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
         }
      }
   }

   /** Método para configurar los eventos de los botones*/
   private void actionListener() {
      button_AddData.addActionListener(e -> {
         synchronized (this) {
            if (validateData()) {
               saveData();
            }
         }
      });

      button_Close.addActionListener(e -> {
         synchronized (this) {
            // Si el usuario cierra la interfaz, el showInput retornará false
            // y el ciclo del Main se terminará para cerrar el programa de forma correcta
            int response = JOptionPane.showConfirmDialog(
                    CapMenu.this, "¿Seguro que deseas salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
               this.repeat = false;
               notify();
               dispose();
            }
         }
      });

      button_SaveData.addActionListener(e -> {
         if (!resetPrint){
            fileWriter();
         }
         dataList.clear();
      });

      button_Print.addActionListener(e -> {
         readInfo();
      });

      button_Delete.addActionListener(e -> {
         fileDelete();
      });

      button_Change.addActionListener(e -> {
         synchronized (this) {
            // Importante: si se decea cambia el archivo por otro
            // Entonces: el showInput retornará "true"
            // y el ciclo del main seguirá ejecutándose
            // para eso la variable "repeat";
         this.repeat = true;
            notify();
            dispose();
         }
      });
   }

   /** Método para configurar las acciones de teclado*/
   private void setupKey() {
      InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getRootPane().getActionMap();

      // Asocia Enter a la acción definida
      inputMap.put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
      actionMap.put("enterAction", enterAction);

      // Asocia Escape a la acción definida
      inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "escapeAction");
      actionMap.put("escapeAction", escapeAction);
   }

   private final Action enterAction = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (validateData()) {
            saveData();
         }
      }
   };

   private final Action escapeAction = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
         synchronized (CapMenu.this) {
            // Mensaje de confirmación antes de cerrar
            int response = JOptionPane.showConfirmDialog(
                    CapMenu.this,
                    "¿Seguro que deseas salir?",
                    "Confirmar salida", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
               CapMenu.this.notify();
               CapMenu.this.dispose();
            }
         }
      }
   };

//---------------------------------------------------FILES------------------------------------------------------//

   /** Método para agregar datos a un archivo */
   public void fileWriter() {
      if(dataList.isEmpty()){
         labelNotify.setText("Error: No hay datos para guardar");
         labelNotify.setForeground(Color.RED);
         repaint();
      } else{
         labelNotify.setText("Datos guardados con Exito");
         labelNotify.setForeground(Color.BLUE);
         repaint();
      }

      File file = new File(System.getProperty("user.dir") + "/src/Archivos/" + nameFile + ".csv");

      // agregar las líneas con append = true
      for (int i = 0; i < dataList.size(); i++) {
         Mis.writeFile(dataList.get(i), file, true);
      }
   }

   /** Método para leer datos de un archivo */
   private void readInfo(){
      resetPrint = true;
      ArrayList<String> list = new ArrayList<>();

      // Limpiar la interfaz y los datos internos en la lista
      reset(dataList);
      File file = new File(System.getProperty("user.dir") + "/src/Archivos/" + nameFile + ".csv");

      if (file.exists()) {
         // Capturar y almacenar los datos dentro un arreglo usando readFile
         String[] datos = Mis.readFile(file);

         // Pasar los datos a un ArrayList y ordenarlos usando Collections.sort
         list.addAll(Arrays.asList(datos));
         Collections.sort(list);

         //Limpiar la tabla e imprimir los datos dentro del archivo
         for(String dato : list) {
            setTable(dato);
         }
      }
   }

   /** Método para eliminar un archivo */
   private void fileDelete(){
      reset(dataList);
      File file = new File(System.getProperty("user.dir") + "/src/Archivos/" + nameFile + ".csv");
      if (file.exists()){
         file.delete();

         labelNotify.setText("Archivo: " + nameFile + " Eliminado");
         labelNotify.setForeground(Color.BLUE);
         repaint();
      } else {
         labelNotify.setText("Error: El archivo no existe");
         labelNotify.setForeground(Color.RED);
         repaint();
      }

   }

   /** Método para resetear/Limpiar la interfaz */
   private void reset(ArrayList<String> list){
      clearTable();
      list.clear();
      textField.setText("");
   }
}
