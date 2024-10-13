package PanelingProyect;
import Calculator.Calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CapPanel_V4 extends JFrame {

   private JPanel mainPanel;

   // Declarar los JSeparators
   private JSeparator separator1;
   private JSeparator separator2;

   // Declarar los JTextField
   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;

   // Declarar los JLabel
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;

   //Declarar los JButtons
   private JButton button1;
   private JButton button2;



   public CapPanel_V4() {
      Color[] colors = {new Color(0xAB95CF), new Color(0xD0C7E1), new Color(0xFFFFFF)};
      float[] fractions = {0.0f, 0.2f, 1.0f}; // Transición de color
      mainPanel = new GradientLabel(colors, fractions, 0, GradientLabel.GradientType.LINEAR);
   }

   /**Método principal para ejecutar la interfaz*/
   public void showDialog() {
      features();
      setupKey();
      newComponents();
      Listeners();
      sizePanel(420, 400);
      this.setVisible(true);
   }

//-------------------------------------------------COMPONENTS-----------------------------------------------------//

   private void features(){
      setTitle("C A L C U L A T O R (swing)");
      mainPanel.setBackground(new Color(218, 219, 232));
      mainPanel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para la disposición
      this.setContentPane(mainPanel);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void newComponents() {
      label1 = new JLabel("Ingresa una expresión a evaluar: ");
      label2 = new JLabel("Expresión PostFija:");
      label3 = new JLabel("Resultado:");

      textField1 = new JTextField();
      textField2 = new JTextField("Ejemplo: ab+c*");
      textField3 = new JTextField("Resultado");

      separator1 = new JSeparator(JSeparator.HORIZONTAL);
      separator2 = new JSeparator(JSeparator.HORIZONTAL);

      button1 = new JButton("Evaluar");
      button2 = new JButton("Limpiar");

      addComponents();
   }

   private void addComponents(){
      AddComponents frame = new AddComponents(mainPanel);
      frame.addImage(0, 0, 1, 1, 0, 10, 0, 0, 1, 3, GridBagConstraints.BOTH, GridBagConstraints.CENTER, System.getProperty("user.dir") + "/src/PanelingProyect/img.png", 100, 100, new Color(0x0000000, true));

      frame.addLabel(label1, 1, 0, 0, 0, 20, 10, 10, 20, 2, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0FFFFFF, true));
      frame.addLabel(label2, 0, 4, 0, 0, 0, 20, 10, 20, 3, 1, GridBagConstraints.NONE, GridBagConstraints.WEST, new Color(0x0000000, true));
      frame.addLabel(label3, 0, 7, 0, 0, 0, 20, 30, 20, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Color(0x0000000, true));

      frame.addJTextField(textField1, 1, 1, 0, 1, 0, 10, 0, 20, 2, 1, GridBagConstraints.HORIZONTAL, true);
      frame.addJTextField(textField2, 0, 5, 0, 1, 0, 20, 0, 20, 3, 1, GridBagConstraints.HORIZONTAL, false, new Color(0xE6E3ED));
      frame.addJTextField(textField3, 1, 7, 0, 1, 0, 0, 30, 20, 2, 1, GridBagConstraints.BOTH, false, new Color(0xE6E3ED));

      frame.addJSeparator(separator1, 0, 3, 1, 1, 0, 20, 0, 20, 3, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Color(0x686868));
      frame.addJSeparator(separator2, 0, 6, 1, 1, 0, 20, 0, 20, 3, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Color(0x686868));

      //Botón Aceptar
      frame.addJButton(button1, 1, 2, 1, 1, 0, 10, 0, 10, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
      frame.addJButton(button2, 2, 2, 1, 1, 0, 0, 0, 20, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
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

//--------------------------------------------------ACTIONS-----------------------------------------------------//

   /**Método para configurar los eventos de los botones*/
   private void Listeners() {
      MouseAdapter mouse = new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            if (!textField1.getText().isEmpty()) {

               Calculadora cal = new Calculadora();
               boolean balanceado = cal.testing(textField1.getText());

               if (balanceado) {
                  String expression = cal.posFija(textField1.getText());
                  textField2.setText(expression);
                  textField3.setText(String.valueOf(cal.assessment(expression)));

               } else {
                  System.out.println("Error: La expresión tiene un fallo");
               }


            } else {
               textField1.setText("");
               textField2.setText("");
               textField3.setText("");
            }
         }
      };
      MouseAdapter clean = new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            textField1.setText("");
         }
      };
      button1.addMouseListener(mouse);

      button2.addMouseListener(clean);
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

      }
   };

   private final Action escapeAction = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
         // Mensaje de confirmación antes de cerrar
         int response = JOptionPane.showConfirmDialog(CapPanel_V4.this, "¿Seguro que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
            dispose();
         }
      }
   };

//---------------------------------------------------FILES------------------------------------------------------//

   private void reset(){
      textField1.setText("");
   }
}
