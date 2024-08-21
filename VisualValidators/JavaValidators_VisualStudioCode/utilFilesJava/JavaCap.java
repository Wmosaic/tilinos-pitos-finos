package utilFilesJava;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------SCANNER-----------------------------------------------------//
//--------------------------Todos los capturadores de esta clase hacen uso del Scanner--------------------------//

public class JavaCap {
   private JavaVal val;
   Scanner scanner = new Scanner(System.in);

   public JavaCap() {
      this.val = new JavaVal();
   }

   public JavaCap(JavaVal val) {
      this.val = val;
   }

   /**
    * Método para capturar cualquier cadena de caracteres
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de caracteres capturada y validada
    */
   public String cap(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!val.isStr(aux)) {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      }
      return aux.trim();
   }

   /**
    * Método para capturar solamente números enteros
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número entero capturado y validado
    */
   public int capInt(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!val.isNum(aux)) {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      }
      return (int) Float.parseFloat(aux);
   }

   /**
    * Método para capturar solamente números enteros con un límite determinado
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim     Indica el límite inferior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del límite especificado
    */
   public int capInt(String mensaje, int lim) {
      int aux = capInt(mensaje);
      while (aux < lim) {
         aux = capInt(mensaje + "(No menor a " + lim + ")");
      }
      return aux;
   }

   /**
    * Método para capturar solamente números enteros dentro de un rango determinado
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI    Indica el límite inferior de los valores que no se podrán capturar
    * @param limS    Indica el límite superior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del rango especificado
    */
   public int capInt(String mensaje, int limI, int limS) {
      int aux = capInt(mensaje);
      while (aux < limI || aux > limS) {
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**
    * Método para capturar solamente números racionales
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número racional capturado y validado
    */
   public double capReal(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!val.isNum(aux)) {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      }
      return Double.parseDouble(aux);
   }

   /**
    * Método para capturar solamente números racionales con un limite determinado
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim     Indica el límite inferior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del límite especificado
    */
   public double capReal(String mensaje, double lim) {
      double aux = capReal(mensaje);
      while (aux < lim) {
         aux = capReal(mensaje + "(No menor a " + lim + ")");

      }
      return aux;
   }

   /**
    * Método para capturar solamente números racionales dentro de un rango determinado
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI    Indica el límite inferior de los valores que no se podrán capturar
    * @param limS    Indica el límite superior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del rango especificado
    */
   public double capReal(String mensaje, double limI, double limS) {
      double aux = capReal(mensaje);
      while (aux < limI || aux > limS) {
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**
    * Método para capturar una cadena sin caracteres numéricos
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de texto capturada y validada sin caracteres numéricos
    */
   public String capNom(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      } while (!val.isStr(aux) || !val.isNom(aux));
      return aux.trim();
   }

   /**
    * Método para capturar una cadena de texto con un límite de caracteres
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limC    Indica el límite en la cantidad de caracteres capturados
    * @return La cadena de texto capturada y validada sin caracteres numéricos
    */
   public String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while (!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /**
    * Método para capturar una fecha
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La fecha capturada y validada como cadena
    */
   public String capDate(String mensaje) {
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while (!val.isDate(aux)) {
         System.out.println("(Fecha Invalida) " + mensaje);
         aux = scanner.nextLine();
      }
      return aux;
   }

   /**
    * Método para capturar un directorio
    *
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La ruta del directorio capturada y validada como cadena
    */
   public String capDir(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      } while (!val.isStr(aux) || !val.isDir(aux));
      return aux.trim();
   }

   /**
    * Método para capturar todos los archivos de un solo tipo de extension
    *
    * @param extension El tipo de extensión de los archivos que se van a capturar
    * @return Todos los archivos de la extension especificada
    */
   public File[] capFile(String extension) {
      File dir = new File(capDir("Ingresa un Directorio:"));
      //Esta parte filtra los archivos y los añade a un arreglo
      //Para cada "file" en "dir" Si los archivos son de la extension específica
      return dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
   }

   /**
    * Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Extension (responsabilidad del programador)
    *
    * @param mensaje   Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param extension El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado
    */
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

   /**
    * Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Directorio y extension (responsabilidad del programador)
    *
    * @param mensaje    Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param directorio la ruta/dirección donde se buscarán los archivos
    * @param extension  El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado
    */
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

   /**
    * Método para desplegar una lista usando Arreglos
    *
    * @param mensaje  Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param opciones Arreglo de opciones a desplegar
    * @return La opción seleccionada por el usuario como una cadena
    */
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

   /**
    * Método para desplegar una lista usando ArrayList
    *
    * @param mensaje  Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param opciones ArrayList de opciones a desplegar
    * @return La opción seleccionada por el usuario como una cadena
    */
   public String capList(String mensaje, ArrayList<String> opciones) {
      if (!(opciones == null)) {
         for (int i = 0; i < opciones.size(); i++) {
            System.out.println(i + 1 + "- " + opciones.get(i));
         }
         int index = capInt(mensaje, 1, opciones.size());
         return opciones.get(index - 1);
      }
      System.out.println("No hay opciones disponibles");
      return null;
   }



   public String capColor(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();
      } while (!val.isColor(aux));
      return aux;
   }
}