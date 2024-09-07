package PanelingProyect;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanelValidators {

   /** Método para validar y capturar números */
   public boolean capNum(JTextField textField) {
      boolean isValid = true;

      if (!isStr(textField) || !isNum(textField)) {
         textField.setText("");
         isValid = false;
      }
      return isValid;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNum(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         textField.setText("");
         label.setText("Error: Entrada Vacía");
         label.setForeground(Color.BLUE);
         return false;
      } else if (!isNum(textField)) {
         textField.setText("");
         label.setText("Error: Ingrese un número válido");
         label.setForeground(Color.RED);
         return false;
      }
      label.setText("");
      return true;
   }

   public boolean capNum(JTextField textField, JLabel label, int lim) {
      if (!isStr(textField)) {
         textField.setText("");
         label.setText("Error: Entrada Vacía");
         label.setForeground(Color.BLUE);
         return false;
      } else if (!isNum(textField)) {
         textField.setText("");
         label.setText("Error: Ingrese un número válido");
         label.setForeground(Color.RED);
         return false;
      }
      if (Integer.parseInt(textField.getText()) < lim) {
         textField.setText("");
         label.setText("Error: Ingrese un número válido " + "(No menor a " + lim + ")");
         label.setForeground(Color.RED);
         return false;
      }
      label.setText("");
      return true;
   }

   public boolean capNum(JTextField textField, JLabel label, int limI, int limS) {
      if (!isStr(textField)) {
         textField.setText("");
         label.setText("Error: Entrada Vacía");
         label.setForeground(Color.BLUE);
         return false;
      } else if (!isNum(textField)) {
         textField.setText("");
         label.setText("Error: Ingrese un número válido");
         label.setForeground(Color.RED);
         return false;
      }
      if (Integer.parseInt(textField.getText()) < limI || Integer.parseInt(textField.getText()) > limS) {
         textField.setText("");
         label.setText("Error: Ingrese un número válido " + "(Entre " + limI + " y " + limS + ")");
         label.setForeground(Color.RED);
         return false;
      } else {
         label.setText("");
      }
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNom(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         textField.setText("");
         label.setText("Error: Entrada Vacía");
         label.setForeground(Color.BLUE);
         return false;
      } else if (!isNom(textField)) {
         textField.setText("");
         label.setText("Error: Ingrese un texto [sin números]");
         label.setForeground(Color.RED);
         return false;
      }
      label.setText("");
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNom(JTextField textField, JLabel label, int limC) {
      if (!isStr(textField)) {
         textField.setText("");
         label.setText("Error: Entrada Vacía");
         label.setForeground(Color.BLUE);
         return false;
      } else if (!isNom(textField)) {
         textField.setText("");
         label.setText("Error: Ingrese un texto [sin números]");
         label.setForeground(Color.RED);
         return false;
      }
      if (textField.getText().length() < limC) {
         textField.setText("");
         label.setText("Error: Ingrese un texto " + "(Menor a " + limC + " Caracteres)");
         label.setForeground(Color.RED);
         return false;
      }
      label.setText("");
      return true;
   }

   /** Método para validar números */
   public boolean isNum(JTextField textField) {
      String text = textField.getText();
      try {
         Double.parseDouble(text);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   /** Método para validar cadenas de caracteres sin números */
   public boolean isNom(JTextField textField) {
      String text = textField.getText();
      String patron = "^\\D+$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(text);
      return buscador.find();
   }

   /** Método para validar cadenas de texto vacías o nulas */
   public boolean isStr(JTextField textField) {
      return textField.getText() != null && !textField.getText().trim().isEmpty();
   }
}