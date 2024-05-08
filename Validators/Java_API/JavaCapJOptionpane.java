import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

//------------------------------------------------JOPTIONPANE---------------------------------------------------//
//------------------------Todos los capturadores de esta clase hacen uso del JOptionPane------------------------//

public class JavaCapJOptionpane {
   private JavaVal val;

   JavaCapJOptionpane() {
      this.val = new JavaVal();
   }
   JavaCapJOptionpane(JavaVal val) {
      this.val = val;
   }


   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return (int) Float.parseFloat(aux);
   }

   /**Método para capturar solamente números enteros con un limite determinado*/
   int capInt(String mensaje, int lim) {
      int aux = capInt(mensaje);
      while (aux < lim) {
         aux = capInt(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números enteros dentro de un rango determinado*/
   int capInt(String mensaje, int limI, int limS) {
      int aux = capInt(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");

      }
      ;
      return aux;
   }

   /**Método para capturar solamente números racionales*/
   double capReal(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return Double.parseDouble(aux);
   }

   /**Método para capturar solamente números racionales con un limite determinado*/
   double capReal(String mensaje, double lim) {
      double aux = capReal(mensaje);
      while (aux < lim) {
         aux = capReal(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números racionales dentro de un rango determinado*/
   double capReal(String mensaje, double limI, double limS) {
      double aux = capReal(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente una cadena de texto*/
   String capNom(String mensaje) {
      String aux;
      do {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
         while (val.isStr(aux)) {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         }
      } while (!val.isNom(aux));
      return aux.trim();
   }

   /**Método para capturar una cadena de texto con un límite de caracteres*/
   String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while (!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /**Método para capturar una fecha*/
   String capDate(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isDate(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return aux;
   }

   /**Método para capturar un directorio*/
   String capDir(String mensaje) {
      String aux;
      do {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
         while (aux == null) {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         }
      } while (!val.isDir(aux));
      return aux.trim();
   }

   /**Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Extension validados, responsabilidad del programador*/
   File capFile(String mensaje, String extension) {
      String directorio = capDir("Ingresa un Directorio:");
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      assert files != null;

      String[] nomFile = new String[files.length];

      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      String archivoSeleccionado = capList(mensaje, nomFile);

      for (File file : files) {
         if (file.getName().equals(archivoSeleccionado)) {
            return file;
         }
      }
      JOptionPane.showMessageDialog(null, "No se encontró el archivo seleccionado.");
      return null;
   }

   /**Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Directorio y extension validados, responsabilidad del programador*/
   File capFile(String mensaje, String directorio, String extension) {
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      assert files != null;

      String[] nomFile = new String[files.length];

      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      String archivoSeleccionado = capList(mensaje, nomFile);

      for (File file : files) {
         if (file.getName().equals(archivoSeleccionado)) {
            return file;
         }
      }
      JOptionPane.showMessageDialog(null, "No se encontró el archivo seleccionado.");
      return null;
   }

   /**Método para capturar un archivo de un tipo de extension (En un selector de archivos).
    * Extension validados, responsabilidad del programador*/
   File capJFile(String mensaje, String extension) {
      if (!(extension == null)) {
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setDialogTitle(mensaje);
         fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
         fileChooser.setFileFilter(new FileNameExtensionFilter(extension.toLowerCase(), extension.toLowerCase()));

         File selectedFile = null;

         while (selectedFile == null) {
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
               selectedFile = fileChooser.getSelectedFile();
               if (!selectedFile.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                  System.out.println("Por favor, selecciona un archivo con la extensión ." + extension);
                  selectedFile = null; // Reiniciar la selección
                  pause();
               }
            } else {
               System.out.println("No se seleccionó ningún archivo.");
               fileChooser.setSelectedFile(null);
            }
         }
         return selectedFile;
      }
      return null;
   }

   /**Método para desplegar una lista utilizando JOptionpane*/
   String capList(String mensaje, String[] opciones) {
      String aux = null;

      while (aux == null) {
         aux = (String) JOptionPane.showInputDialog(
                 null, mensaje,
                 "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
         pause();
      }
      return aux;
   }

   /**Método para pausar cada iteración en los capturadores y evitar errores*/
   void pause() {
      try {
         Thread.sleep(400);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}