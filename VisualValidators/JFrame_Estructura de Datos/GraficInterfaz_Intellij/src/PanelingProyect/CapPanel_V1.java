package PanelingProyect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CapPanel_V1 extends JFrame {

   private JPanel mainPanel;


   // Declara los JTextField
   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;
   private JTextField textField4;

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

   // Variables para almacenar los datos
   private int data1;
   private int data2;
   private int data3;
   private boolean actionSuccess;


   public CapPanel_V1() {
      //mainPanel = new GradientLabel(new Color(0x6F88E4), new Color(0xDADBE8), 0);
      mainPanel = new JPanel();
      this.setTitle("CapPanel");
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setupKey();

      sizePanel(400, 300);
   }

   public void JPanel(String[] message) {
      label1 = new JLabel(message[0]);
      label2 = new JLabel(message[1]);
      label3 = new JLabel(message[2]);

      label4 = new JLabel("");
      label5 = new JLabel("");
      label6 = new JLabel("");

      textField1 = new JTextField();
      textField2 = new JTextField();
      textField3 = new JTextField();
      textField4 = new JTextField();

      button1 = new JButton("Aceptar");
      button2 = new JButton("Cancelar");


      addImage(0, 0, 1, 0, 0, 0, 0, 0, 1, 10, GridBagConstraints.BOTH, GridBagConstraints.CENTER, "C:\\Users\\EnrickMC\\Desktop\\Imagen.png", 70, 70);

      addLabel(label1, 1, 0, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      addLabel(label2, 1, 3, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      addLabel(label3, 1, 6, 0, 0, 10, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));

      addLabel(label4, 1, 2, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0FFFFFF, true));
      addLabel(label5, 1, 5, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));
      addLabel(label6, 1, 8, 0, 2, 2, 0, 0, 10, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Color(0x0000000, true));

      addJTextField(textField1, 1, 1, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);
      addJTextField(textField2, 1, 4, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);
      addJTextField(textField3, 1, 7, 0, 1, 0, 0, -5, 10, 2, 1, GridBagConstraints.HORIZONTAL);

      //Botón Aceptar
      addButton(button1, 1, 9, 1, 1, 0, 0, 10, 5, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
      //Botón Cancelar
      addButton(button2, 2, 9, 1, 1, 0, 5, 10, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);

      //Calendario
   }

   private void addLabel(JLabel label, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, Color backgroundColor) {
      // Crear un JPanel con el color de fondo especificado
      JPanel colorPanel = new JPanel();
      colorPanel.setBackground(backgroundColor);
      colorPanel.setLayout(new BorderLayout());

      // Agregar el JLabel al panel de color
      colorPanel.add(label, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el panel de color (que contiene el JLabel) al JFrame
      this.add(colorPanel, gbc);
   }

   private void addLabel(JLabel label, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Crear el GradientLabel
      GradientLabel gradientLabel = createGradientLabel();

      // Agregar el JLabel al GradientLabel
      gradientLabel.add(label, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el GradientLabel al JFrame
      this.add(gradientLabel, gbc);
   }

   private void addImage(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, String imagePath, int imageWidth, int imageHeight, Color backgroundColor) {
      // Crear un JPanel con el color de fondo especificado
      JPanel colorPanel = new JPanel();
      colorPanel.setBackground(backgroundColor);
      colorPanel.setLayout(new BorderLayout());

      // Crear el JLabel con la imagen
      JLabel imageLabel = createImageLabel(imagePath, imageWidth, imageHeight);

      // Agregar el JLabel con la imagen al JPanel
      colorPanel.add(imageLabel, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JPanel con la imagen al JFrame
      this.add(colorPanel, gbc);
   }





   private void addImage(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, String imagePath, int imageWidth, int imageHeight) {
      // Crear el GradientLabel
      GradientLabel gradientLabel = createGradientLabel();

      // Crear el JLabel con la imagen
      JLabel imageLabel = createImageLabel(imagePath, imageWidth, imageHeight);

      // Agregar el JLabel con la imagen al GradientLabel
      gradientLabel.add(imageLabel, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el GradientLabel al JFrame
      this.add(gradientLabel, gbc);
   }

   private void addJTextField(JTextField textField, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill);

      // Agregar el JTextField al JFrame
      this.add(textField, gbc);
   }

   public void addButton(JButton component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JButton al JFrame
      this.add(component, gbc);
   }

   private GradientLabel createGradientLabel() {
      Color[] colors = {new Color(0x6F88E4), new Color(0xDADBE8)};
      float[] fractions = {0.0f, 1.0f}; // Transición de color
      GradientLabel gradientLabel = new GradientLabel(colors, fractions, 0, GradientLabel.GradientType.LINEAR);
      gradientLabel.setLayout(new BorderLayout());
      return gradientLabel;
   }

   private JLabel createImageLabel(String imagePath, int imageWidth, int imageHeight) {
      ImageIcon resizedIcon = resizeImage(imagePath, imageWidth, imageHeight);
      JLabel imageLabel = new JLabel(resizedIcon);

      imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
      imageLabel.setVerticalAlignment(SwingConstants.TOP);

      imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
      return imageLabel;
   }

   private GridBagConstraints configureGridBagConstraints(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = fill; // Configura el ajuste de llenado del componente

      gbc.gridx = gx;
      gbc.gridy = gy;

      gbc.gridwidth = gridwidth;
      gbc.gridheight = gridheight;

      gbc.weightx = width;
      gbc.weighty = height;

      gbc.insets = new Insets(top, left, bottom, right);

      return gbc;
   }

   private GridBagConstraints configureGridBagConstraints(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = fill; // Configura el ajuste de llenado del componente
      gbc.anchor = anchor; // Configura el anclaje del componente

      gbc.gridx = gx;
      gbc.gridy = gy;

      gbc.gridwidth = gridwidth;
      gbc.gridheight = gridheight;

      gbc.weightx = width;
      gbc.weighty = height;

      gbc.insets = new Insets(top, left, bottom, right);

      return gbc;
   }


//---------------------------------------------------STYLE------------------------------------------------------//

   public void sizePanel(int width, int height) {
      this.setSize(width, height);
      this.setPreferredSize(new Dimension(width, height));
      this.setMinimumSize(new Dimension(width, height));
      this.setMaximumSize(new Dimension(width, height));
      this.setResizable(false);
      setLocationRelativeTo(null);

   }

   public ImageIcon resizeImage(String imagePath, int width, int height) {
      ImageIcon imageIcon = new ImageIcon(imagePath);
      Image originalImage = imageIcon.getImage();
      Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(scaledImage);
   }

   private void styleLabel(JLabel button) {
      // Establece un borde vacío alrededor del botón
      //button.setBorder(new EmptyBorder(0, 0, 0, 0));

      // Cambiar el color de fondo del botón (esto no se usará directamente)
      button.setBackground(new Color(234, 234, 234));

      // Cambiar el color del texto del botón
      button.setForeground(new Color(7, 7, 7));

      // Cambiar la fuente del texto (tipo de letra, estilo, tamaño)
      button.setFont(new Font("Arial", Font.BOLD, 16));
   }

   private void styleButton(JButton button) {
      // Eliminar el borde de enfoque
      button.setFocusPainted(false);

      // Establece un borde vacío alrededor del botón
      //button.setBorder(new EmptyBorder(0, 0, 0, 0));

      // Cambiar el color de fondo del botón (esto no se usará directamente)
      button.setBackground(new Color(234, 234, 234));

      // Cambiar el color del texto del botón
      button.setForeground(new Color(7, 7, 7));

      // Cambiar la fuente del texto (tipo de letra, estilo, tamaño)
      button.setFont(new Font("Arial", Font.BOLD, 16));
   }

//--------------------------------------------------GETTERS-----------------------------------------------------//

   public int getData1() {
      return data1;
   }

   public int getData2() {
      return data2;
   }

   public int getData3() {
      return data3;
   }

//------------------------------------------------INITIALIZERS--------------------------------------------------//

   /**Método principal para ejecutar la interfaz*/
   public void capPanel() {
      String[] message = {"Introduce un dato:","Introduce un dato:","Introduce un dato:",};
      JPanel(message);
      actionListener();
      this.setVisible(true);
   }


   /**Método para ejecutar las acciones de los elementos en la interfaz*/
   public void actionListener() {
      button1.addActionListener(e -> {
         synchronized (this) {
            if (validateData()) {
               saveData();
               actionSuccess = true;
               notify(); // Notifica que se completó la acción
            }
         }
      });
      button2.addActionListener(e -> {
         synchronized (this) {
            actionSuccess = false;
            notify(); // Notifica que se completó la acción
         }
         this.dispose();
      });
   }

   /**Método para ejecutar las acciones de los elementos en la interfaz por entrada de teclado*/
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
         synchronized (CapPanel_V1.this) {
            if (validateData()) {
               saveData();
               actionSuccess = true;
               notify(); // Notifica que se completó la acción
            }         }
      }
   };

   private final Action escapeAction = new AbstractAction()
   {
      @Override
      public void actionPerformed(ActionEvent e) {
         synchronized (CapPanel_V1.this) {
            CapPanel_V1.this.notify();
         }
         CapPanel_V1.this.dispose();
      }
   };

   /**Método para ciclar la captura de datos*/
   public boolean actionWait(){
      this.actionSuccess = true;
      synchronized (this) {
         try {
            wait(); // Espera hasta que se presione un botón y se llame a notify()
         } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
         }
      }
      return actionSuccess;
   }

   /**Método para validar que todos los JTextField contienen números*/
   private boolean validateData() {
      TextField_Validators validator = new TextField_Validators();
      boolean valid, valid2, valid3;

      valid = validator.capNum(textField1, label4, 0, 5);
      valid2 = validator.capNum(textField2, label5,0,10);
      valid3 = validator.capNum(textField3, label6,0,20);

      return valid && valid2 && valid3;
   }

   /**Método para guardar los datos de los JTextField en las variables*/
   private void saveData() {
      this.data1 = (int) Float.parseFloat(textField1.getText());
      this.data2 = (int) Float.parseFloat(textField2.getText());
      this.data3 = (int) Float.parseFloat(textField3.getText());
   }

}