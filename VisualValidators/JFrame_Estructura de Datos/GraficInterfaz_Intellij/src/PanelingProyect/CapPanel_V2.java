package PanelingProyect;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CapPanel_V2 extends JFrame {

   private ArrayList<String> dataList = new ArrayList<>();

   private JPanel mainPanel;
   private CountDownLatch latch;

   // Declara Componentes Miscelaneo
   private JTable table1;
   private JSeparator separator1;

   // Declara los JTextField
   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;

   // Declara los JLabel
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JLabel label5;
   private JLabel label6;

   //Declarar los JButtons
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;

   // Variables para almacenar los datos
   private int data1;
   private int data2;
   private int data3;

   public CapPanel_V2() {
      //mainPanel = new GradientLabel(new Color(0x6F88E4), new Color(0xDADBE8), 0);
      mainPanel = new JPanel();
      this.setTitle("CapPanel");
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setupKey();
      sizePanel(580, 320);
   }

   /**Método principal para ejecutar la interfaz*/
   public void showDialog() {
      String[] message = {"Introduce un dato:","Introduce un dato:","Introduce un dato:",};
      String[] columnNames = {"Data1", "Data2", "Data3"};
      newComponents(message, columnNames);
      actionListener();
      this.setVisible(true);
   }

//-------------------------------------------------COMPONENTS-----------------------------------------------------//

   public void newComponents(String[] message, String[] columnNames) {
      label1 = new JLabel(message[0]);
      label2 = new JLabel(message[1]);
      label3 = new JLabel(message[2]);

      label4 = new JLabel("");
      label5 = new JLabel("");
      label6 = new JLabel("");

      textField1 = new JTextField();
      textField2 = new JTextField();
      textField3 = new JTextField();

      table1 = new JTable();
      separator1 = new JSeparator(JSeparator.VERTICAL);

      button1 = new JButton("Aceptar");
      button2 = new JButton("Salir");
      button3 = new JButton("Guardar");
      button4 = new JButton("Imprimir");

      addComponents(columnNames);
   }

   private void addComponents(String[] columnNames){
      AddComponents frame = new AddComponents(mainPanel);

      frame.addImage(0, 0, 5, 0, 0, 0, 0, 0, 1, 10, GridBagConstraints.BOTH, GridBagConstraints.CENTER, "C:\\Users\\EnrickMC\\Desktop\\Imagen.png", 70, 70);

      frame.addLabel(label1, 1, 0, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label2, 1, 3, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      frame.addLabel(label3, 1, 6, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));

      frame.addLabel(label4, 1, 2, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label5, 1, 5, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));
      frame.addLabel(label6, 1, 8, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));

      frame.addJTextField(textField1, 1, 1, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);
      frame.addJTextField(textField2, 1, 4, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);
      frame.addJTextField(textField3, 1, 7, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);

      frame.addJTable(table1, 4, 0, 10, 1, 10, 10, 10, 10, 2, 9, GridBagConstraints.BOTH, GridBagConstraints.CENTER, columnNames);
      frame.addJSeparator(separator1, 3, 0, 1, 1, 10, 0, 10, 0, 1, 10, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, new Color(0x686868));

      //Botón Aceptar
      frame.addJButton(button1, 1, 9, 1, 1, 0, 0, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón Cancelar
      frame.addJButton(button2, 2, 9, 4.2, 1, 0, 5, 10, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);

      //Botón Guardar
      frame.addJButton(button3, 4, 9, 1, 1, 0, 10, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón Imprimir
      frame.addJButton(button4, 5, 9, 1, 1, 0, 5, 10, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
   }

//---------------------------------------------------STYLE------------------------------------------------------//

   private void sizePanel(int width, int height) {
      this.setSize(width, height);
      this.setPreferredSize(new Dimension(width, height));
      this.setMinimumSize(new Dimension(width, height));
      this.setMaximumSize(new Dimension(width, height));
      this.setResizable(false);
      setLocationRelativeTo(null);
   }

//------------------------------------------------INITIALIZERS--------------------------------------------------//

   /**Método para validar que todos los JTextField contienen números*/
   private boolean validateData() {
      TextField_Validators validator = new TextField_Validators();

      boolean valid = validator.capNum(textField1, label4, 0, 500);
      boolean valid2 = validator.capNum(textField2, label5,0,100);
      boolean valid3 = validator.capNum(textField3, label6,0,200);

      return valid && valid2 && valid3;
   }

   /**Método para guardar los datos de los JTextField en las variables*/
   private void saveData() {
      this.data1 = (int) Float.parseFloat(textField1.getText());
      this.data2 = (int) Float.parseFloat(textField2.getText());
      this.data3 = (int) Float.parseFloat(textField3.getText());

      String dataString = String.format("%d,%d,%d", data1, data2, data3);
      dataList.add(dataString);

      setTable(data1, data2, data3);
   }

   /**Método para guardar y visualizar los datos en un JTable*/
   public void setTable(int data1, int data2, int data3) {
      // Obtener el modelo actual de la tabla
      DefaultTableModel model = (DefaultTableModel) table1.getModel();

      // Agregar la fila con los datos proporcionados
      model.addRow(new Object[]{data1, data2, data3});
   }

//--------------------------------------------------ACTIONS-----------------------------------------------------//

   /**Método para configurar los eventos de los botones*/
   private void actionListener() {
      button1.addActionListener(e -> {
         if (validateData()) {
            saveData();
         }
      });

      button2.addActionListener(e -> {
         int response = JOptionPane.showConfirmDialog(CapPanel_V2.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
            dispose();
         }
      });

      button3.addActionListener(e -> {
         writeInfo();
      });
   }

   /**Método para configurar las acciones de teclado*/
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
         // Mensaje de confirmación antes de cerrar
         int response = JOptionPane.showConfirmDialog(CapPanel_V2.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
            dispose();
         }
      }
   };

//---------------------------------------------------FILES------------------------------------------------------//

   private void writeInfo(){
      //PanelDialog panelDialog = new PanelDialog(this);
      //panelDialog.showDialog(this);
   }

   private void readInfo(){

   }


   private void reset(){
      textField1.setText("");
      textField2.setText("");
      textField3.setText("");
   }
}