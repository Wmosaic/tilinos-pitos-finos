package Menu;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class FileMenu extends JFrame {

   TextField_Validators validator = new TextField_Validators();
   private String data;

   // Declara el JPanel
   private JPanel mainPanel;
   private JLabel label_first;
   private JLabel label_Warning;
   private JTextField textField;

   // Declara Componentes Miscelaneo
   private JTree tree;

   //Declarar los JButtons
   private JButton button_OpenFile;
   private JButton button_Close;


   public FileMenu() {
      Color[] colors = {new Color(0x6F88E4), new Color(0xB5C0DD), new Color(0xDADBE8)};
      float[] fractions = {0.0f, 0.2f, 1.0f}; // Transición de color
      mainPanel = new GradientLabel(colors, fractions, 0, GradientLabel.GradientType.LINEAR);
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setTitle("CapPanel");
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      sizePanel(250, 320);
   }

   /**Método principal para ejecutar la interfaz*/
   public String showDialog() {
      String[] message = {"Introduce un dato:","Introduce un dato:","Introduce un dato:",};
      String[] columnNames = {"Data1", "Data2", "Data3"};
      newComponents(message, columnNames);
      this.setVisible(true);

      actionListener();
      setupKey();
      actionWait();
      return data;
   }

//-------------------------------------------------COMPONENTS-----------------------------------------------------//
//----------------------------------Aquí se instancia y agregan los JComponents------------------------------------//

   public void newComponents(String[] message, String[] columnNames) {
      label_first = new JLabel("Crear nuevo archivo:");
      label_Warning = new JLabel("");
      textField = new JTextField();

      tree = new JTree();

      button_OpenFile = new JButton("Abrir archivo");
      button_Close = new JButton("Salir");

      addComponents(columnNames);
   }

   private void addComponents(String[] columnNames){
      AddComponents frame = new AddComponents(mainPanel);

      frame.addJTree(tree, 0, 0, 1, 8, 10, 10, 0, 10, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      // Cargar archivos en el JTree
      createFilesTree(System.getProperty("user.dir") + "/src/Archivos/");

      frame.addLabel(label_first, 0, 1, 1, 1, 0, 10, -10, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      frame.addLabel(label_Warning, 0, 3, 1, 1, -10, 10, 10, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));

      frame.addJTextField(textField, 0, 2, 1, 1, 0, 10, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL);

      //Botón
      frame.addJButton(button_OpenFile, 0, 4, 1, 1, 0, 10, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón
      frame.addJButton(button_Close, 1, 4, 1.7, 1, 0, 5, 10, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
   }

//---------------------------------------------------STYLE------------------------------------------------------//

   /** Método para declarar el tamaño del JFrame*/
   private void sizePanel(int width, int height) {
      this.setSize(width, height);
      this.setPreferredSize(new Dimension(width, height));
      this.setMinimumSize(new Dimension(width, height));
      this.setMaximumSize(new Dimension(width, height));
      this.setResizable(false);
      setLocationRelativeTo(null);
   }

//--------------------------------------------------ACTIONS-----------------------------------------------------//

   /**Método para esperar que se presione un botón*/
   private void actionWait() {
      synchronized (this) {
         try {
            wait();
         } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
         }
      }
   }

   /**Método para configurar los eventos de los botones*/
   private void actionListener() {
      button_OpenFile.addActionListener(e -> {
         if (validator.capFile(textField, label_Warning)){
            synchronized (this) {
               this.data = textField.getText();
               notify();
               dispose();
            }
         }
      });

      button_Close.addActionListener(e -> {int response = JOptionPane.showConfirmDialog(
              FileMenu.this,
              "¿Seguro que deseas salir?",
              "Confirmar salida",
              JOptionPane.YES_NO_OPTION);

         if (response == JOptionPane.YES_OPTION) {
            synchronized (this) {
               notify();
               dispose();
            }
         }
      });

      tree.addTreeSelectionListener(e -> {
         DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)
                 tree.getLastSelectedPathComponent();
         if (selectedNode != null) {
            textField.setText(selectedNode.getUserObject().toString());
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
         if (validator.capFile(textField, label_Warning)){
            synchronized (FileMenu.this) {
               FileMenu.this.data = textField.getText();
               FileMenu.this.notify();
               FileMenu.this.dispose();
            }
         }
      }
   };

   private final Action escapeAction = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
         synchronized (FileMenu.this) {
            int response = JOptionPane.showConfirmDialog(FileMenu.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
               FileMenu.this.dispose();
            }
         }
      }
   };

//---------------------------------------------------FILES------------------------------------------------------//

   /** Método para agregar archivos del directorio al JTree */
   private void createFilesTree(String Path) {
      File dir = new File(Path);
      DefaultMutableTreeNode root = new DefaultMutableTreeNode(dir.getName());
      addFilesTree(root, dir);
      tree.setModel(new DefaultTreeModel(root));
   }

   /** Método auxiliar para añadir archivos a un nodo del JTree */
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