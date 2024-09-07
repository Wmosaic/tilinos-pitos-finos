package PanelingProyect;

import utilFilesJava.Miscellaneous;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.*;

public class PanelDialog extends JDialog {

   private ArrayList<String> dataList; // Lista para almacenar los datos recibidos

   Miscellaneous Mis = new Miscellaneous();
   private PanelDialog instance; // Instancia única de la ventana
   private JPanel mainPanel;

   private JTextField textField1;
   private JLabel label1;
   private JButton button1;
   private JTree tree1;

   public PanelDialog(Frame owner, ArrayList<String> dataList) {
      super(owner, "Ventana Secundaria", true); // 'true' hace el diálogo modal
      mainPanel = new GradientLabel(new Color(0xA5ABBD), new Color(0xF8F8F8), 0);
      this.setTitle("Abrir Archivo:");
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setContentPane(mainPanel);
      this.dataList = dataList; // Almacenar la lista de cadenas

      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e) {
            instance = null; // Restablece la instancia cuando la ventana se cierra
         }
      });

      sizePanel(250, 320); // Configura el tamaño de la ventana
   }

   /**Método principal para ejecutar la interfaz*/
   public void showDialog(Frame owner) {
      if (instance == null) { // Solo crear la instancia si no existe
         instance = new PanelDialog(owner, dataList); // Pasar info al constructor
         instance.newComponents();
         instance.setVisible(true); // Mostrar la ventana (bloquea la interacción con la principal)
      }
   }

//---------------------------------------------------STYLE------------------------------------------------------//

   private void sizePanel(int width, int height) {
      this.setSize(width, height);
      this.setPreferredSize(new Dimension(width, height));
      this.setMinimumSize(new Dimension(width, height));
      this.setMaximumSize(new Dimension(width, height));
      this.setResizable(false);
      setLocationRelativeTo(getOwner()); // Centrar en pantalla respecto a la ventana principal
   }

//-------------------------------------------------COMPONENTS-----------------------------------------------------//

   private void newComponents() {
      label1 = new JLabel("Crear nuevo Archivo:");
      button1 = new JButton("Abrir archivo");
      textField1 = new JTextField();
      tree1 = new JTree();

      // Añadir los componentes al panel
      addComponents();
      actionListener();
   }

   public void addComponents() {
      AddComponents frame = new AddComponents(mainPanel);

      // Añadir componentes al panel utilizando el método AddComponents
      frame.addLabel(label1, 0, 1, 1, 1, 0, 10, 0, 10, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addJTextField(textField1, 0, 2, 1, 0, 0, 10, 10, 10, 1, 1, GridBagConstraints.HORIZONTAL);
      frame.addJButton(button1, 0, 3, 1, 1, 0, 10, 0, 10, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER);

      // Asumiendo que AddComponents tiene un método para agregar JTree
      frame.addJTree(tree1, 0, 0, 1, 5, 10, 10, 0, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);

      // Cargar archivos en el JTree
      createFilesTree(System.getProperty("user.dir") + "/src/Archivos/");
   }

//--------------------------------------------------ACTIONS-----------------------------------------------------//

   /**Método para configurar los eventos de los botones*/
   private void actionListener() {
      button1.addActionListener(e -> {
         fileWriter(textField1.getText());
         this.dispose();
      });


      tree1.addTreeSelectionListener(e -> {
         DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
         if (selectedNode != null) {
            // Actualizar el JTextField con el texto del nodo seleccionado
            textField1.setText(selectedNode.toString());
         }
      });
   }

//---------------------------------------------------FILES------------------------------------------------------//


   public void fileWriter(String nameFile) {
      File file = new File(System.getProperty("user.dir") + "/src/Archivos/" + nameFile + ".csv");

      // Abrir con append = false solo una vez, para limpiar el archivo
      if (!dataList.isEmpty()) {
         Mis.writeFile(dataList.getFirst(), file, false);
      }

      // Luego, agregar el resto de las líneas con append = true
      for (int i = 1; i < dataList.size(); i++) {
         Mis.writeFile(dataList.get(i), file, true);
      }
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