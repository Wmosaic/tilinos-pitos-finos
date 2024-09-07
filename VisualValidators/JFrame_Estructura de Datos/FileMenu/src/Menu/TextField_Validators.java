package Menu;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextField_Validators {

//------------------------------------------------VALIDATORS---------------------------------------------------//
//------------------------------------------Validadores generales----------------------------------------------//

   /** Método para validar si no es una cadena vaciá */
   public boolean cap(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      }
      label.setText("");
      return true;
   }

   /** Método para validar y capturar números */
   public boolean capNum(JTextField textField) {
      if (!isStr(textField) || !isNum(textField)) {
         textField.setText("");
         return false;
      }
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNum(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      } else if (!isNum(textField)) {
         setJTextField_Num(textField, label);
         return false;
      }
      label.setText("");
      return true;
   }

   public boolean capNum(JTextField textField, JLabel label, int lim) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      } else if (!isNum(textField)) {
         setJTextField_Null(textField, label);
         return false;
      }
      if (Integer.parseInt(textField.getText()) < lim) {
         setJTextField_Num(textField, label, "(No menor a " + lim + ")");
         return false;
      }
      label.setText("");
      return true;
   }

   public boolean capNum(JTextField textField, JLabel label, int limI, int limS) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      } else if (!isNum(textField)) {
         setJTextField_Num(textField, label);
         return false;
      }
      if (Integer.parseInt(textField.getText()) < limI || Integer.parseInt(textField.getText()) > limS) {
         setJTextField_Num(textField, label, "(Entre " + limI + " y " + limS + ")");
         return false;
      } else {
         label.setText("");
      }
      return true;
   }

   /** Método para validar y capturar números */
   public boolean capNom(JTextField textField) {
      if (!isStr(textField) || !isNom(textField)) {
         textField.setText("");
         return false;
      }
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNom(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      } else if (!isNom(textField)) {
         setJTextField_Nom(textField, label);
         return false;
      }
      label.setText("");
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capNom(JTextField textField, JLabel label, int limC) {
      if (!isStr(textField)) {
         setJTextField_Null(textField, label);
         return false;
      } else if (!isNom(textField)) {
         setJTextField_Nom(textField, label);
         return false;
      }
      if (textField.getText().length() < limC) {
         setJTextField_Nom(textField, label, "(Menor a " + limC + " Caracteres)");
         return false;
      }
      label.setText("");
      return true;
   }

   /** Método para validar y capturar números + Label de advertencia */
   public boolean capFile(JTextField textField, JLabel label) {
      if (!isStr(textField)) {
         setJTextField_File(textField, label);
         return false;
      }
      label.setText("");
      return true;
   }


//-------------Métodos para modificar el JLabel de advertencia en caso de introducir un dato erróneo------------//

   private void setJTextField_Null(JTextField textField, JLabel label){
      textField.setText("");
      label.setText("Error: Entrada Vacía");
      label.setForeground(Color.BLUE);
   }

   private void setJTextField_Num(JTextField textField, JLabel label){
      textField.setText("");
      label.setText("Error: Ingrese un número válido");
      label.setForeground(Color.RED);
   }

   private void setJTextField_Num(JTextField textField, JLabel label, String extraMessage){
      textField.setText("");
      label.setText("Error: Ingrese un número válido " + extraMessage);
      label.setForeground(Color.RED);
   }

   private void setJTextField_Nom(JTextField textField, JLabel label){
      textField.setText("");
      label.setText("Error: Ingrese un texto [sin números]");
      label.setForeground(Color.RED);
   }

   private void setJTextField_Nom(JTextField textField, JLabel label, String extraMessage){
      textField.setText("");
      label.setText("Error: Ingrese un texto " + extraMessage);
      label.setForeground(Color.RED);
   }

   private void setJTextField_File(JTextField textField, JLabel label){
      textField.setText("");
      label.setText("Error: Elige o Crea un nuevo archivo");
      label.setForeground(Color.RED);
   }

//------------------------------------------------VALIDATORS---------------------------------------------------//
//------------------------------------------------JTextField---------------------------------------------------//

   /** Método para validar números */
   private boolean isNum(JTextField textField) {
      String text = textField.getText();
      try {
         Double.parseDouble(text);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   /** Método para validar cadenas de caracteres sin números */
   private boolean isNom(JTextField textField) {
      String text = textField.getText();
      String patron = "^\\D+$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(text);
      return buscador.find();
   }

   /** Método para validar cadenas de texto vacías o nulas */
   private boolean isStr(JTextField textField) {
      return textField.getText() != null && !textField.getText().trim().isEmpty();
   }
}