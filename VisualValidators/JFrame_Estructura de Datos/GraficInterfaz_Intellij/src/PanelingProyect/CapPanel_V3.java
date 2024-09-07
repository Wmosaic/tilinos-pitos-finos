package PanelingProyect;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CapPanel_V3 extends JFrame {

   private ArrayList<String> dataList = new ArrayList<>();

   private JPanel mainPanel;

   // Declara Componentes Miscelaneo
   private JTree tree1;
   private JTable table1;
   private JSeparator separator1;

   // Declara los JTextField
   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;
   private JTextField textFieldAM2;

   // Declara los JLabel
   private JLabel label0;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JLabel label5;
   private JLabel label6;
   private JLabel labelAM1;

   //Declarar los JButtons
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;


   public CapPanel_V3() {
      Color[] colors = {new Color(0x6F88E4), new Color(0xB5C0DD), new Color(0xDADBE8)};
      float[] fractions = {0.0f, 0.2f, 1.0f}; // Transición de color
      mainPanel = new GradientLabel(colors, fractions, 0, GradientLabel.GradientType.LINEAR);
      this.setTitle("CapPanel");
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setupKey();
      sizePanel(520, 420);
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
      label0 = new JLabel("Archivo: ");

      label1 = new JLabel(message[0]);
      label2 = new JLabel(message[1]);
      label3 = new JLabel(message[2]);

      label4 = new JLabel("");
      label5 = new JLabel("");
      label6 = new JLabel("");

      textField1 = new JTextField();
      textField2 = new JTextField();
      textField3 = new JTextField();

      labelAM1 = new JLabel("Crear nuevo archivo:");
      textFieldAM2 = new JTextField();

      tree1 = new JTree();
      table1 = new JTable();
      separator1 = new JSeparator(JSeparator.VERTICAL);

      button1 = new JButton("Aceptar");
      button2 = new JButton("Cerrar");
      button3 = new JButton("Seleccionar");
      button4 = new JButton("Eliminar...");

      addComponents(columnNames);
   }

   private void addComponents(String[] columnNames){
      AddComponents frame = new AddComponents(mainPanel);

      frame.addLabel(label0, 3, 0, 0, 0, 10, 0, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addImage(0, 0, 10, 1, 0, 10, 0, 0, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER, System.getProperty("user.dir") + "/src/MediaFiles/Imagen.png", 60, 60, new Color(0x0000000, true));

      frame.addLabel(label1, 0, 2, 0, 0, 10, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label2, 0, 5, 0, 0, 0, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      frame.addLabel(label3, 0, 8, 0, 0, 0, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));

      frame.addLabel(label4, 0, 4, 0, 2, 2, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label5, 0, 7, 0, 2, 2, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));
      frame.addLabel(label6, 0, 10, 0, 2, 2, 10, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));

      frame.addJTextField(textField1, 0, 3, 0, 1, 0, 10, -5, 0, 2, 1, GridBagConstraints.HORIZONTAL);
      frame.addJTextField(textField2, 0, 6, 0, 1, 0, 10, -5, 0, 2, 1, GridBagConstraints.HORIZONTAL);
      frame.addJTextField(textField3, 0, 9, 0, 1, 0, 10, -5, 0, 2, 1, GridBagConstraints.HORIZONTAL);

      archivoManager();
      dataManager();

      //frame.addJTable(table1, 4, 1, 10, 1, 10, 0, 10, 10, 2, 10, GridBagConstraints.BOTH, GridBagConstraints.CENTER, columnNames);
      frame.addJSeparator(separator1, 2, 0, 1, 1, 10, 10, 10, 10, 1, 12, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, new Color(0x686868));

      //Botón Aceptar
      frame.addJButton(button1, 0, 11, 1, 1, 0, 10, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón Cancelar
      frame.addJButton(button2, 1, 11, 1.5, 1, 0, 5, 10, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      }

   public void archivoManager(){
      AddComponents frame = new AddComponents(mainPanel);

      frame.addJTree(tree1, 4, 1, 10, 1, 10, 0, 10, 10, 2, 7, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      // Cargar archivos en el JTree
      createFilesTree(System.getProperty("user.dir") + "/src/Archivos/");

      frame.addLabel(labelAM1, 4, 8, 0, 0, 0, 0, 0, 0, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      frame.addJTextField(textFieldAM2, 4, 9, 0, 1, 0, 0, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL);


      //Botón
      frame.addJButton(button3, 4, 11, 1, 1, 0, 0, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón
      frame.addJButton(button4, 5, 11, 1.5, 1, 0, 5, 10, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
   }

   public void dataManager(){

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

      boolean valid = validator.capNom(textField1, label4);
      boolean valid2 = validator.capNom(textField2, label5);
      boolean valid3 = validator.capNom(textField3, label6);

      return valid && valid2 && valid3;
   }

   /**Método para guardar los datos de los JTextField en las variables*/
   private void saveData() {
      //int data1 = (int) Float.parseFloat(textField1.getText());
      //int data2 = (int) Float.parseFloat(textField2.getText());
      //int data3 = (int) Float.parseFloat(textField3.getText());
      //String dataString = String.format("%d,%d,%d", data1, data2, data3);

      String data1 = textField1.getText();
      String data2 = textField2.getText();
      String data3 = textField3.getText();
      String dataString = data1 + "," + data2 + "," + data3;

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

   /**Método para guardar y visualizar los datos en un JTable*/
   public void setTable(String data1, String data2, String data3) {
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
         int response = JOptionPane.showConfirmDialog(CapPanel_V3.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
            dispose();
         }
      });

      button3.addActionListener(e -> {

      });

      tree1.addTreeSelectionListener(e -> {
         // Obtener el nodo seleccionado
         DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
         if (selectedNode != null) {
            label0.setText("Archivo: " + selectedNode.toString());

         }
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
         int response = JOptionPane.showConfirmDialog(CapPanel_V3.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
            dispose();
         }
      }
   };

//---------------------------------------------------FILES------------------------------------------------------//

   private void writeInfo(){
      PanelDialog panelDialog = new PanelDialog(this, dataList);
      panelDialog.showDialog(this);
   }

   private void readInfo(){

   }

   private void reset(){
      textField1.setText("");
      textField2.setText("");
      textField3.setText("");
   }

   // Método para agregar archivos del directorio al JTree
   private void createFilesTree(String Path) {
      File dir = new File(Path);
      DefaultMutableTreeNode root = new DefaultMutableTreeNode(dir.getName());
      addFilesTree(root, dir);
      tree1.setModel(new DefaultTreeModel(root));
   }

   // Método auxiliar para añadir archivos a un nodo del JTree
   private void addFilesTree(DefaultMutableTreeNode node, File dir) {
      File[] files = dir.listFiles();
      if (files != null) {
         //Ciclo para tomar el nombre de todos los archivos existente
         for (File file : files) {

            // Obtener el nombre del archivo sin la extensión
            String fileName = file.getName();
            int dotIndex = fileName.lastIndexOf('.');

            if (dotIndex > 0) {
               fileName = fileName.substring(0, dotIndex);
            }
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(fileName);
            node.add(childNode);

         }
      }
   }
}