package Validators.Java_API;
import java.io.File;
import javax.swing.*;



public class Prueba

{
   public static void main(String[] args)
   {
      JavaCap Cap = new JavaCap();

      int n = Cap.capInt("Ingresa un Numero:");
      JOptionPane.showMessageDialog(null, "El numero ingresado es valido: " + n);

      //String p = Cap.capNom("Ingresa una Palabra:");
      //JOptionPane.showMessageDialog(null, "La palabra ingresada es valida: " + p);

      //String fecha = Cap.capDate("Ingrese una fecha en el formato dd/mm/yyyy:");
      //JOptionPane.showMessageDialog(null, "La Fecha es: " + fecha);

      //String d = Cap.capDir("Ingresa un Directorio:");
      //JOptionPane.showMessageDialog(null, "El Directorio ingresado es valido: \n" + d);

      File Archivo = Cap.capFile("Selecciona un Archivo:","C:\\Users\\EnrickMC\\Desktop\\POO\\Lista_Articulo Python",".csv");
      JOptionPane.showMessageDialog(null,Archivo);
   }
}