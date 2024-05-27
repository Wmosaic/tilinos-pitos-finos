package utilFilesJava;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

//------------------------------------------------JOPTIONPANE---------------------------------------------------//
//------------------------Todos los capturadores de esta clase hacen uso del JOptionPane------------------------//

public class JavaCapJOptionpane {
   private JavaVal val;

   public JavaCapJOptionpane() {
      this.val = new JavaVal();
   }
   public JavaCapJOptionpane(JavaVal val) {
      this.val = val;
   }


   /**Método para capturar solamente números enteros*/
   public int capInt(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return (int) Float.parseFloat(aux);
   }

   /**Método para capturar solamente números enteros con un limite determinado*/
   public int capInt(String mensaje, int lim) {
      int aux = capInt(mensaje);
      while (aux < lim) {
         aux = capInt(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números enteros dentro de un rango determinado*/
   public int capInt(String mensaje, int limI, int limS) {
      int aux = capInt(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");

      }
      ;
      return aux;
   }

   /**Método para capturar solamente números racionales*/
   public double capReal(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return Double.parseDouble(aux);
   }

   /**Método para capturar solamente números racionales con un limite determinado*/
   public double capReal(String mensaje, double lim) {
      double aux = capReal(mensaje);
      while (aux < lim) {
         aux = capReal(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números racionales dentro de un rango determinado*/
   public double capReal(String mensaje, double limI, double limS) {
      double aux = capReal(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente una cadena de texto*/
   public String capNom(String mensaje) {
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
   public String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while (!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /**Método para capturar una fecha*/
   public String capDate(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isDate(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return aux;
   }

   /**Método para capturar un directorio*/
   public String capDir(String mensaje) {
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
   public File capFile(String mensaje, String extension) {
      String directorio = capDir("Ingresa un Directorio:");

      //Esta parte del código filtra los archivos dependiendo la extensión
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      assert files != null;

      //Se crea un arreglo con la longitud del número de Archivos filtrados
      String[] nomFile = new String[files.length];

      //Se almacenan los nombres de los archivos en el arreglo declarado
      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      //Se despliega una lista con los archivos almacenados en el arreglo
      String archivoSeleccionado = capList(mensaje, nomFile);

      //Se retorna la dirección completa del archivo seleccionado
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
   public File capFile(String mensaje, String directorio, String extension) {
      //Esta parte del código filtra los archivos dependiendo la extensión
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      assert files != null;

      //Se crea un arreglo con la longitud del número de Archivos filtrados
      String[] nomFile = new String[files.length];

      //Se almacenan los nombres de los archivos en el arreglo declarado
      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      //Se despliega una lista con los archivos almacenados en el arreglo
      String archivoSeleccionado = capList(mensaje, nomFile);

      //Se retorna la dirección completa del archivo seleccionado
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
   public File capJFile(String mensaje, String extension) {
      if (!(extension == null)) {
         //JFileChooser es un componente gráfico que proporciona una interfaz para que
         //el usuario navegue por el sistema de archivos y seleccione archivos o directorios.
         JFileChooser fileChooser = new JFileChooser();

         //Declara un mensaje para la interfaz grafica
         fileChooser.setDialogTitle(mensaje);

         //Configuración del JFileChooser para que solo permita la selección de archivos y no de directorios.
         //Esto limita las opciones del usuario a archivos específicos y evita que puedan seleccionar carpetas.
         fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

         //Esto se utiliza para establecer un filtro de archivos en el JFileChooser
         fileChooser.setFileFilter(new FileNameExtensionFilter(extension.toLowerCase(), extension.toLowerCase()));

         File selectedFile = null;

         while (selectedFile == null) {
            // Muestra el cuadro de diálogo para abrir un archivo y guarda el resultado en result
            int result = fileChooser.showOpenDialog(null);

            // Si el usuario selecciona un archivo y hace clic en "Aceptar"
            if (result == JFileChooser.APPROVE_OPTION) {
               selectedFile = fileChooser.getSelectedFile();

               // Verifica si el archivo seleccionado tiene la extensión correcta
               if (!selectedFile.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                  System.out.println("Por favor, selecciona un archivo con la extensión ." + extension);

                  // Reinicia selectedFile a null para mantener el bucle y permitir otra selección
                  selectedFile = null;
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
   public String capList(String mensaje, String[] opciones) {
      String aux = null;

      while (aux == null) {
         aux = (String) JOptionPane.showInputDialog(
                 null, mensaje,
                 "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
         pause();
      }
      return aux;
   }

   /**Método para desplegar una lista utilizando JOptionpane*/
   public String capList(String mensaje, ArrayList<String> opciones) {
      String aux = null;

      while (aux == null) {
         aux = (String) JOptionPane.showInputDialog(
                 null, mensaje,
                 "Elegir", JOptionPane.QUESTION_MESSAGE, null, new ArrayList[]{opciones}, opciones.get(0));
         pause();
      }
      return aux;
   }

   /**Método para pausar cada iteración en los capturadores y evitar errores*/
   public void pause() {
      try {
         Thread.sleep(400);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}