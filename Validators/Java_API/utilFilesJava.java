import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;

class utilFilesJava {
   Scanner scanner = new Scanner(System.in);

   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje){
      System.out.println(mensaje);
      String aux = scanner.nextLine();

      while(!isNum(aux)){
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

      while(!isNum(aux)){
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

         while(isStr(aux)){
            System.out.println(mensaje);
            aux = scanner.nextLine();

         }
      }while (!isNom(aux));
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

      while(!isDate(aux)){
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
      } while (!isDir(aux));
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

   public void clear() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }
 
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
         @SuppressWarnings("unused")
         Date fecha = sdf.parse(cadena);
         return true;
      } catch (ParseException e) {
         return false;
      }
   }

   /**Método para validar cadenas de texto vaciás o nulas*/
   public boolean isStr(String cadena) {
      if (cadena == null || cadena.isEmpty()){
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
}
