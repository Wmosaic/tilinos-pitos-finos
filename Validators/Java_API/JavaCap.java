package Validators.Java_API;
import javax.swing.*;
import java.io.File;

class JavaCap{
   private JavaVal validator;

   /**Constructores para inicializar los validadores dependiendo el contexto*/
   JavaCap(){
      this.validator = new JavaVal();
   }
   JavaCap(JavaVal val){
      this.validator = val;
   }


   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje){
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isNum(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return (int) Float.parseFloat(aux);
   }

   /**Método para capturar solamente números enteros con un limite determinado*/
   int capInt(String mensaje, int lim){
      double num;
      do {
         String aux = "";
         while (!validator.isNum(aux)) {
            aux = JOptionPane.showInputDialog(null,
                    mensaje + " (No mayor a " + lim + "):");
         }
         num = Double.parseDouble(aux);
      } while (num > lim);
      return (int) num;
   }

   /**Método para capturar solamente números enteros dentro de un rango determinado*/
   int capInt(String mensaje, int limI, int limS){
      double num;
      do {
         String aux = "";
         while (!validator.isNum(aux)) {
            aux = JOptionPane.showInputDialog(null,
                    mensaje + " ( entre " +  limI + " y " + limS + " ):");
         }
         num = Double.parseDouble(aux);
      } while (num < limI || num > limS);
      return (int) num;
   }

   /**Método para capturar solamente números racionales*/
   double capReal(String mensaje){
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isNum(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return Double.parseDouble(aux);
   }

   /**Método para capturar solamente números racionales con un limite determinado*/
   double capReal(String mensaje, double lim){
      double num;
      do {
         String aux = "";
         while (!validator.isNum(aux)) {
            aux = JOptionPane.showInputDialog(null,
                    mensaje + " (No mayor a " + lim + "):");
         }
         num = Double.parseDouble(aux);
      } while (num > lim);
      return num;
   }

   /**Método para capturar solamente números racionales dentro de un rango determinado*/
   double capInt(String mensaje, double limI, double limS){
      double num;
      do {
         String aux = "";
         while (!validator.isNum(aux)) {
            aux = JOptionPane.showInputDialog(null,
                    mensaje + " ( entre " +  limI + " y " + limS + " ):");
         }
         num = Double.parseDouble(aux);
      } while (num < limI || num > limS);
      return num;
   }

   /**Método para capturar solamente una cadena de texto*/
   String capNom(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isNom(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return aux;
   }

   /**Método para capturar una cadena de texto con un límite de caracteres*/
   String capNom(String mensaje, int LimC) {
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isNom(aux) || !(aux.length() <= LimC)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return aux;
   }

   /** Método para capturar una fecha*/
   String capDate(String mensaje){
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isDate(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return aux;
   }

   /** Método para capturar un directorio*/
   String capDir(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!validator.isDir(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
      }
      return aux;
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lita).
    * -Directorio y extension validados, responsabilidad del programador*/
   File capFile(String mensaje, String directorio, String extension) {
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      String archivoSeleccionado = null;
      assert files != null;

      if (validator.isDir(directorio)) {
         String[] nomFile = new String[files.length];

         for (int i = 0; i < files.length; i++) {
            nomFile[i] = files[i].getName();
         }

         while (!validator.isFile(files) && !validator.isStr(archivoSeleccionado)) {
            archivoSeleccionado = (String) JOptionPane.showInputDialog(null,
                    mensaje, "Archivos (" + extension + ")",
                    JOptionPane.PLAIN_MESSAGE, null, nomFile, nomFile[0]);
         }

         for (File file : files) {
            if (file.getName().equals(archivoSeleccionado)) {
               return file;
            }
         }
         return new File("No hay archivos con la extensión especificada en el directorio dado.");
      } else {
         return new File("El directorio no es valido");
      }
   }
}
