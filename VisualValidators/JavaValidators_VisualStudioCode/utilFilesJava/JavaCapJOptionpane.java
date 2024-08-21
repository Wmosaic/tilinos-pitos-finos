package utilFilesJava;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

//------------------------------------------------JOPTIONPANE---------------------------------------------------//
//------------------------Todos los capturadores de esta clase hacen uso del JOptionPane------------------------//

public class JavaCapJOptionpane {
   private JavaVal val;

   public JavaCapJOptionpane() {
      this.val = new JavaVal();
   }
   JavaCapJOptionpane(JavaVal val) {
      this.val = val;
   }

   /** Método para capturar cualquier cadena de caracteres
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de caracteres capturada y validada*/
   public String cap(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while(!val.isStr(aux)){
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return aux.trim();
   }

   /** Método para capturar solamente números enteros
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número entero capturado y validado*/
   public int capInt(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return (int) Float.parseFloat(aux);
   }

   /** Método para capturar solamente números enteros con un límite determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim Indica el límite inferior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del límite especificado*/
   public int capInt(String mensaje, int lim) {
      int aux = capInt(mensaje);
      while (aux < lim) {
         aux = capInt(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /** Método para capturar solamente números enteros dentro de un rango determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI Indica el límite inferior de los valores que no se podrán capturar
    * @param limS Indica el límite superior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del rango especificado*/
   public int capInt(String mensaje, int limI, int limS) {
      int aux = capInt(mensaje);
      while (aux < limI || aux > limS){
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /** Método para capturar solamente números racionales
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número racional capturado y validado*/
   public double capReal(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isNum(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return Double.parseDouble(aux);
   }

   /** Método para capturar solamente números racionales con un limite determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim Indica el límite inferior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del límite especificado*/
   public double capReal(String mensaje, double lim){
      double aux = capReal(mensaje);
      while (aux < lim){
         aux = capReal(mensaje + "(No menor a " + lim + ") ");

      }
      return aux;
   }

   /** Método para capturar solamente números racionales dentro de un rango determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI Indica el límite inferior de los valores que no se podrán capturar
    * @param limS Indica el límite superior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del rango especificado*/
   public double capReal(String mensaje, double limI, double limS){
      double aux = capReal(mensaje);
      while (aux < limI || aux > limS){
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /** Método para capturar una cadena sin caracteres numéricos
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de texto capturada y validada sin caracteres numéricos*/
   public String capNom(String mensaje) {
      String aux;
         do {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         }while (!val.isStr(aux) || !val.isNom(aux));
      return aux.trim();
   }

   /**Método para capturar una cadena de texto con un límite de caracteres
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limC Indica el límite en la cantidad de caracteres capturados
    * @return La cadena de texto capturada y validada sin caracteres numéricos*/
   public String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while (!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /** Método para capturar una fecha
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La fecha capturada y validada como cadena*/
   public String capDate(String mensaje) {
      String aux = JOptionPane.showInputDialog(null, mensaje);
      pause();

      while (!val.isDate(aux)) {
         aux = JOptionPane.showInputDialog(null, mensaje);
         pause();
      }
      return aux;
   }

   /** Método para capturar un directorio
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La ruta del directorio capturada y validada como cadena*/
   public String capDir(String mensaje) {
      String aux;
         do {
            aux = JOptionPane.showInputDialog(null, mensaje);
            pause();
         } while (!val.isStr(aux) || !val.isDir(aux));
      return aux.trim();
   }

   /** Método para capturar todos los archivos de un solo tipo de extension
    * @param extension El tipo de extensión de los archivos que se van a capturar
    * @return Todos los archivos de la extension especificada*/
   public File[] capFile(String extension){
      File dir = new File(capDir("Ingresa un Directorio:"));
      //Esta parte filtra los archivos y los añade a un arreglo
      //Para cada "file" en "dir" Si los archivos son de la extension específica
      return dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
   }

   /** Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Extension (responsabilidad del programador)
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param extension El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado*/
   public File capFile(String mensaje, String extension) {
      File[] files = null;
      String[] nomFile = null;

      //Este bucle se repetirá hasta que se encuentre al menos un archivo con la extensión específica
      while (!val.isStr(nomFile)) {
         files = capFile(extension);
         nomFile = new String[files.length];

         if (!val.isStr(nomFile)) {
            System.out.println("No se encontraron archivos validos en este directorio");
         }
      }

      assert nomFile != null;
      //Se almacenan los nombres de los archivos en el arreglo declarado
      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      //Se despliega una lista con los archivos almacenados en el arreglo
      String archivoSeleccionado = capList(mensaje, nomFile);

      //Se comprueba si el archivo existe, sino retorna null
      for (File file : files) {
         if (file.getName().equals(archivoSeleccionado)) {
            //Se retorna la dirección completa del archivo seleccionado
            return file;
         }
      }
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /** Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Directorio y extension (responsabilidad del programador)
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param directorio la ruta/dirección donde se buscarán los archivos
    * @param extension El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado*/
   public File capFile(String mensaje, String directorio, String extension) {
      //Esta parte filtra los archivos y los añade a un arreglo
      //Para cada "file" en "dir" Si los archivos son de la extension específica
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      //(Para JAVA) se especifica la longitud de un arreglo para la cantidad de archivos filtrados
      assert files != null;
      String[] nomFile = new String[files.length];

      //Este bucle se repetirá en caso de no encontrar al menos un archivo con la extensión específica
      while (!val.isStr(nomFile)) {
         System.out.println("No se encontraron archivos validos en este directorio");

         files = capFile(extension);
         nomFile = new String[files.length];
      }

      //Se almacenan los nombres de los archivos en el arreglo declarado
      for (int i = 0; i < files.length; i++) {
         nomFile[i] = files[i].getName();
      }

      //Se despliega una lista con los archivos almacenados en el arreglo
      String archivoSeleccionado = capList(mensaje, nomFile);

      //Se comprueba si el archivo existe, sino retorna null
      for (File file : files) {
         if (file.getName().equals(archivoSeleccionado)) {
            //Se retorna la dirección completa del archivo seleccionado
            return file;
         }
      }
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /** Método para capturar un archivo de un tipo de extension (Usando JFileChooser).
    * Extension (responsabilidad del programador)
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param extension El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado*/
   public File capJFile(String mensaje, String extension) {
      // Crea un objeto JFileChooser para permitir la selección de archivos.
      JFileChooser fileChooser = new JFileChooser();
      // Establecer el título del JFileChooser
      fileChooser.setDialogTitle(mensaje);
      // Establecer que solo se pueden seleccionar archivos, NO carpetas.
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      // Configura un filtro de archivos para mostrar solo archivos con la extensión especificada.
      // Elimina el primer carácter (el punto) para que el filtro funcione correctamente (usando substring).
      fileChooser.setFileFilter(new FileNameExtensionFilter("*" + extension.toLowerCase(), extension.substring(1).toLowerCase()));

      File selectedFile = null;
      // Inicia un bucle que continúa hasta que se seleccione un archivo válido.
      while (selectedFile == null) {
         // Muestra el cuadro de diálogo de selección de archivos y captura el resultado
         int result = fileChooser.showOpenDialog(null);
         if (result == JFileChooser.APPROVE_OPTION) {
            // Si se aprueba la selección, obtiene el archivo seleccionado.
            selectedFile = fileChooser.getSelectedFile();
            // Verifica si el archivo seleccionado tiene la extensión correcta.
            if (!selectedFile.getName().toLowerCase().endsWith(extension.toLowerCase())) {
               // Muestra un mensaje de error si la extensión es incorrecta, reiniciando la selección.
               JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo con la extensión: " + extension);
               selectedFile = null; // Reiniciar la selección
               pause();
            }
         } else {
            // Si no se selecciona ningún archivo, muestra un mensaje de advertencia.
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
            fileChooser.setSelectedFile(null);
         }
      }
      // Devuelve el archivo seleccionado con la extensión correcta.
      return selectedFile;
   }

   /** Método para desplegar una lista usando Arreglos
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param opciones Arreglo de opciones a desplegar
    * @return La opción seleccionada por el usuario como una cadena*/
   public String capList(String mensaje, String[] opciones) {
      String aux = null;

      if (!(opciones == null)) {
         while (aux == null) {
         aux = (String) JOptionPane.showInputDialog(
                 null, mensaje,
                 "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
         pause();
         }
      return aux;
      }
      System.out.println("No hay opciones disponibles");
      return null;
   }


   public Color capJColor(String mensaje) {
      // Crear un diálogo de selección de color
      Color aux;
      do {
         aux = JColorChooser.showDialog(null, mensaje, Color.WHITE);
      } while (aux == null);
      return aux;
   }


   /** Método para pausar cada iteración en los capturadores y evitar errores*/
   public void pause() {
      try {
         Thread.sleep(400);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}