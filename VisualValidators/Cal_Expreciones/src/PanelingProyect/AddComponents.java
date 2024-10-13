package PanelingProyect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddComponents{

   private JPanel targetPanel;

   public AddComponents(JPanel panel) {
      this.targetPanel = panel;
   }


   /** Método para añadir un JPanel */
   public void addJPanel(JPanel component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, Color backgroundColor) {
      // Crear un JPanel con el color de fondo especificado
      component.setBackground(backgroundColor);
      component.setLayout(new BorderLayout());

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      Dimension fixedSize = new Dimension(260, 420); // Ancho: 200, Alto: 150
      component.setPreferredSize(fixedSize);
      component.setMinimumSize(fixedSize);
      component.setMaximumSize(fixedSize);

      // Agregar el JButton al JFrame
      targetPanel.add(component, gbc);
   }

   /** Método para añadir un JButton */
   public void addJButton(JButton component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JButton al JFrame
      targetPanel.add(component, gbc);
   }

   /** Método para añadir un JLabel + fondo de color */
   public void addLabel(JLabel label, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, Color backgroundColor) {
      // Crear un JPanel con el color de fondo especificado
      JPanel colorPanel = new JPanel();
      colorPanel.setBackground(backgroundColor);
      colorPanel.setLayout(new BorderLayout());

      // Agregar el JLabel al panel de color
      colorPanel.add(label, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el panel de color (que contiene el JLabel) al JFrame
      targetPanel.add(colorPanel, gbc);
   }

   /** Método para añadir un JLabel + fondo con gradiente de color */
   public void addLabel(JLabel label, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Crear el GradientLabel
      GradientLabel gradientLabel = createGradientLabel();

      // Agregar el JLabel al GradientLabel
      gradientLabel.add(label, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el GradientLabel al JFrame
      targetPanel.add(gradientLabel, gbc);
   }

   /** Método para añadir un JLabel + fondo de color + imagen */
   public void addImage(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, String imagePath, int imageWidth, int imageHeight, Color backgroundColor) {
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
      targetPanel.add(colorPanel, gbc);
   }

   /** Método para añadir un JLabel + fondo con gradiente de color + imagen */
   public void addImage(int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, String imagePath, int imageWidth, int imageHeight) {
      // Crear el GradientLabel
      GradientLabel gradientLabel = createGradientLabel();

      // Crear el JLabel con la imagen
      JLabel imageLabel = createImageLabel(imagePath, imageWidth, imageHeight);

      // Agregar el JLabel con la imagen al GradientLabel
      gradientLabel.add(imageLabel, BorderLayout.CENTER);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el GradientLabel al JFrame
      targetPanel.add(gradientLabel, gbc);
   }

   /** Método para añadir un JTable */
   public void addJTable(JTable component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, String[] columnNames) {
      // Crear un modelo de tabla no editable con los encabezados
      DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
         @Override
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };
      component.setModel(model);

      // Configurar la visualización de las rejillas
      component.setShowGrid(true);
      component.setGridColor(new Color(0xDDDDDD));

      // Crear un JScrollPane y agregar el JTable
      JScrollPane scrollPane = new JScrollPane(component);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JScrollPane al JFrame o JPanel
      targetPanel.add(scrollPane, gbc);
   }

   /** Método para añadir un JCombobox */
   public void addJCombobox(JComboBox component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JButton al JFrame
      targetPanel.add(component, gbc);
   }

   /** Método para añadir un JTree */
   public void addJTree(JTree component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor) {
      // Crear un JScrollPane y agregar el JTree
      JScrollPane scrollPane = new JScrollPane(component);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JScrollPane al JFrame o JPanel
      targetPanel.add(scrollPane, gbc);
   }

   /** Método para añadir un JSeparator */
   public void addJSeparator(JSeparator component, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, int anchor, Color color) {
      component.setForeground(color);

      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill, anchor);

      // Agregar el JButton al JFrame
      targetPanel.add(component, gbc);
   }

   /** Método para añadir un JTextField */
   public void addJTextField(JTextField textField, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, boolean edit) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill);

      textField.setEditable(edit);

      // Agregar el JTextField al JFrame
      targetPanel.add(textField, gbc);
   }

   /** Método para añadir un JTextField */
   public void addJTextField(JTextField textField, int gx, int gy, double width, double height, int top, int left, int bottom, int right, int gridwidth, int gridheight, int fill, boolean edit, Color color) {
      // Configurar GridBagConstraints
      GridBagConstraints gbc = configureGridBagConstraints(gx, gy, width, height, top, left, bottom, right, gridwidth, gridheight, fill);

      textField.setEditable(edit);
      textField.setBackground(color);

      // Agregar el JTextField al JFrame
      targetPanel.add(textField, gbc);
   }


//------------------------------------------------SETTINGS-----------------------------------------------------//
//-------------------------------Configuraciones básicas de los componentes------------------------------------//

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
      imageLabel.setVerticalAlignment(SwingConstants.CENTER);

      imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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

   private ImageIcon resizeImage(String imagePath, int width, int height) {
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
}
