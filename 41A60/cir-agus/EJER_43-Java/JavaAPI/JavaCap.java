package JavaAPI;


import java.io.File;
import java.util.Scanner;

//--------------------------------------------------SCANNER-----------------------------------------------------//
//--------------------------Todos los capturadores de esta clase hacen uso del Scanner--------------------------//

public class JavaCap {
   private JavaVal val;
   Scanner scanner = new Scanner(System.in);

   public JavaCap(){
      this.val = new JavaVal();
   }
   public JavaCap(JavaVal val){
      this.val = val;
   }


   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje){
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while(!val.isNum(aux)){
         System.out.println(mensaje);
         aux = scanner.nextLine();
      }
      return (int) Float.parseFloat(aux);
   }

   /**Método para capturar solamente números enteros con un limite determinado*/
   int capInt(String mensaje, int lim){
      int aux = capInt(mensaje);
      while (aux < lim){
         aux = capInt(mensaje + "(No menor a " + lim + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente números enteros dentro de un rango determinado*/
   int capInt(String mensaje, int limI, int limS){
      int aux = capInt(mensaje);
      while (aux < limI || aux > limS){
         aux = capInt(mensaje + "(Entre " + limI + " y " + limS + ") ");
      };
      return aux;
   }

   /**Método para capturar solamente números racionales*/
   double capReal(String mensaje){
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while(!val.isNum(aux)){
         System.out.println(mensaje);
         aux = scanner.nextLine();
      }
      return Double.parseDouble(aux);
   }

   /**Método para capturar solamente números racionales con un limite determinado*/
   double capReal(String mensaje, double lim){
      double aux = capReal(mensaje);
      while (aux < lim){
         aux = capReal(mensaje + "(No menor a " + lim + ") ");

      }
      return aux;
   }

   /**Método para capturar solamente números racionales dentro de un rango determinado*/
   double capReal(String mensaje, double limI, double limS){
      double aux = capReal(mensaje);
      while (aux < limI || aux > limS){
         aux = capReal(mensaje + "(Entre " + limI + " y " + limS + ") ");
      }
      return aux;
   }

   /**Método para capturar solamente una cadena de texto*/
   String capNom(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();

         while(val.isStr(aux)){
            System.out.println(mensaje);
            aux = scanner.nextLine();

         }
      }while (!val.isNom(aux));
      return aux.trim();
   }

   /**Método para capturar una cadena de texto con un límite de caracteres*/
   String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while(!(aux.length() < limC)) {
         aux = capNom(mensaje + " (Menor a " + limC + " Caracteres)");
      }
      return aux;
   }

   /** Método para capturar una fecha*/
   String capDate(String mensaje){
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while(!val.isDate(aux)){
         System.out.println("(Fecha Invalida) " + mensaje);
         aux = scanner.nextLine();
      }
      return aux;
   }

   /** Método para capturar un directorio*/
   String capDir(String mensaje) {
      String aux;
      do {
         System.out.println(mensaje);
         aux = scanner.nextLine();

         while(aux == null){
            System.out.println(mensaje);
            aux = scanner.nextLine();

         }
      } while (!val.isDir(aux));
      return aux.trim();
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    *Extension validada, responsabilidad del programador*/
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
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * -Directorio y extension validados, responsabilidad del programador*/
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
      System.out.println("No se encontró el archivo seleccionado.");
      return null;
   }

   /** Método para desplegar una lista*/
   String capList(String mensaje, String[] opciones){
      if (!(opciones == null)) {
         for (int i = 0; i < opciones.length; i++) {
            System.out.println(i + 1 + "- " + opciones[i]);
         }
         int index = capInt(mensaje, 1, opciones.length);
         return opciones[index-1];
      }
      System.out.println("No hay opciones disponibles");
      return null;
   }
}