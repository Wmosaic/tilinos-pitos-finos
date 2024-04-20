package Validators.Java_API;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

class JavaVal {

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
   @SuppressWarnings("unused")
   public boolean isDate(String cadena) {
      try {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         sdf.setLenient(false);
         Date fecha = sdf.parse(cadena);
         return true;
      } catch (ParseException e) {
         return false;
      }
   }

   /**Método para validar cadenas de texto vaciás o nulas*/
   public boolean isStr(String cadena) {
      if (cadena == null) {
         return false;
      }
      return !cadena.isEmpty();
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

   /** Método para validar si existen archivos dentro de un directorio*/
   public boolean isFile(File[] cadena) {
      if (cadena != null && cadena.length > 0) {
         return false;
         }
      System.out.println("No hay archivos en este directorio");
      return true;
   }

}
