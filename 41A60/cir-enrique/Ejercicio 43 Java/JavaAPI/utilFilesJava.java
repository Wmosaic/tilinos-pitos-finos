package JavaAPI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;
import java.util.Scanner;

public class utilFilesJava {

   //--------------------------------------------------SCANNER-----------------------------------------------------//
   //--------------------------------------------------------------------------------------------------------------//

   Scanner scanner = new Scanner(System.in);

   /**Método para capturar solamente números enteros*/
   public int capInt(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!isNum(aux)) {
         System.out.println(mensaje);
         aux = scanner.nextLine();
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
      while (aux < limI || aux > limS) {
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      ;
      return aux;
   }

   /**Método para capturar solamente números racionales*/
   public double capReal(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!isNum(aux)) {
         System.out.println(mensaje);
         aux = scanner.nextLine();
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
      while (aux < limI || aux > limS) {
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente una cadena de texto*/
   public String capNom(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();

         while (isStr(aux)) {
            System.out.println(mensaje);
            aux = scanner.nextLine();

         }
      } while (!isNom(aux));
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
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!isDate(aux)) {
         System.out.println("(Fecha Invalida) " + mensaje);
         aux = scanner.nextLine();
      }
      return aux;
   }

   /**Método para capturar un directorio*/
   public String capDir(String mensaje) {
      String aux;
      do {
         System.out.print(mensaje);
         aux = scanner.nextLine();

         while (aux == null) {
            System.out.println(mensaje);
            aux = scanner.nextLine();

         }
      } while (!isDir(aux));
      return aux.trim();
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Extension validada, responsabilidad del programador*/
   public File capFile(String mensaje, String extension) {
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
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * -Directorio y extension validados, responsabilidad del programador*/
   public File capFile(String mensaje, String directorio, String extension) {
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
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /**Método para desplegar una lista*/
   public String capList(String mensaje, String[] opciones) {
      if (!(opciones == null)) {
         for (int i = 0; i < opciones.length; i++) {
            System.out.println(i + 1 + "- " + opciones[i]);
         }
         int index = capInt(mensaje, 1, opciones.length);
         return opciones[index - 1];
      }
      System.out.println("No hay opciones disponibles");
      return null;
   }

   //------------------------------------------------JOPTIONPANE---------------------------------------------------//
   //--------------------------------------------------------------------------------------------------------------//

   /** Método para capturar solamente números enteros*/
   public int capJInt(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return (int) Float.parseFloat(aux);
   }

   /**Método para capturar solamente números enteros con un limite determinado*/
   public int capJInt(String mensaje, int lim) {
      int aux = capInt(mensaje);
      while (aux < lim) {
         aux = capInt(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números enteros dentro de un rango determinado*/
   public int capJInt(String mensaje, int limI, int limS) {
      int aux = capInt(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");

      }
      ;
      return aux;
   }

   /**Método para capturar solamente números racionales*/
   public double capJReal(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return Double.parseDouble(aux);
   }

   /**Método para capturar solamente números racionales con un limite determinado*/
   public double capJReal(String mensaje, double lim) {
      double aux = capReal(mensaje);
      while (aux < lim) {
         aux = capReal(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números racionales dentro de un rango determinado*/
   public double capJReal(String mensaje, double limI, double limS) {
      double aux = capReal(mensaje);
      while (aux <= limI || aux >= limS) {
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente una cadena de texto*/
   public String capJNom(String mensaje) {
      String aux;
      do {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
         while (isStr(aux)) {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         }
      } while (!isNom(aux));
      return aux.trim();
   }

   /**Método para capturar una cadena de texto con un límite de caracteres*/
   public String capJKNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while (!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /**Método para capturar una fecha*/
   public String capJDate(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!isDate(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return aux;
   }

   /**Método para capturar un directorio*/
   public String capJDir(String mensaje) {
      String aux;
      do {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
         while (aux == null) {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         }
      } while (!isDir(aux));
      return aux.trim();
   }

   /**Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Extension validados, responsabilidad del programador*/
   public File capJFile(String mensaje, String extension) {
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
   public File capJFile(String mensaje, String directorio, String extension) {
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
   public File capJJFile(String mensaje, String extension) {
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
   public String capJList(String mensaje, String[] opciones) {
      String aux = null;

      while (aux == null) {
         aux = (String) JOptionPane.showInputDialog(
                 null, mensaje,
                 "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
         pause();
      }
      return aux;
   }

   //-------------------------------------------------VALIDATORS---------------------------------------------------//
   //--------------------------------------------------------------------------------------------------------------//

   /**Método para validar números naturales enteros*/
   public boolean isNum(String cadena) {
      try {
         Double.parseDouble(cadena);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   /**Segundo método para validar números naturales enteros*/
   public boolean isNum2(String cadena) {
      String patron = "^\\d+(\\.\\d+)?$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(cadena);
      return buscador.find();
   }

   /**Método para validar cadenas de texto y caracteres*/
   public boolean isNom(String cadena) {
      String patron = "^\\D+$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(cadena);
      return buscador.find();
   }

   /**Método para validar la fecha ingresada*/
   public boolean isDate(String cadena) {
      try {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         sdf.setLenient(false);
         sdf.parse(cadena);
         return true;
      } catch (ParseException e) {
         return false;
      }
   }

   /**Método para validar cadenas vaciás o nulas*/
   public boolean isStr(String cadena) {
      if (cadena == null || cadena.isEmpty()) {
         System.out.println("La cadena de texto esta vaciá");
         return true;
      }
      return false;
   }

   /**Método para validar un directorio*/
   public boolean isDir(String cadena) {
      File directorio = new File(cadena);
      if (!directorio.exists() || !directorio.isDirectory() || directorio.isFile()) {
         System.out.println("El directorio no es valido");
         return false;
      }
      return true;
   }

   //-------------------------------------------------MISCELÁNEO---------------------------------------------------//
   //--------------------------------------------------------------------------------------------------------------//

   /**Método para leer archivos csv/txt, adjuntando los datos en líneas de texto
    * Recibe la dirección de un archivo para su funcionamiento */
   public String[] readFile(File directorio) {
      try (BufferedReader archivo = new BufferedReader(new FileReader(directorio))) {
         String lineaCSV;
         StringBuilder datos = new StringBuilder();
         while ((lineaCSV = archivo.readLine()) != null) {

            datos.append(lineaCSV).append("\n");

         }
         return datos.toString().split("\n");

      } catch (IOException e) {
         System.out.println("Error al leer el archivo: " + e.getMessage());
         return null;
      }
   }

   /**Método para escribir sobre archivos csv/txt
    * Recibe la dirección de un archivo nuevo o existente para su funcionamiento */
   void writeFile(String cadena, File directorio) {
      try {
         FileWriter writer = new FileWriter(directorio, true);

         writer.append(cadena).append("\n");
         
         writer.close();

         System.out.println("El texto se ha guardado correctamente en el archivo CSV.");
      } catch (IOException e) {
         System.out.println("Se produjo un error al intentar guardar el archivo CSV: " + e.getMessage());
      }
   }

   /**Esto funcionará en terminales que admitan códigos de escape ANSI.
    * No funcionará en Windows CMD, No funcionará en la terminal IDE.*/
   public static void clear() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }

   /**Método para pausar cada iteración en los capturadores y evitar errores*/
   void pause() {
      try {
         Thread.sleep(400);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   //--------------------------------------------------------------------------------------------------------------//
   //--------------------------------------------------------------------------------------------------------------//
}
