package utilFilesJava;
import javax.swing.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

//------------------------------------------------VALIDATORS---------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------//

class JavaVal {

   /**Método para validar números naturales*/
   public boolean isNum(String cadena) {
      try {
         Double.parseDouble(cadena);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   /**Segundo método para validar números naturales*/
   public boolean isNum2(String cadena) {
      String patron = "^\\d+(\\.\\d+)?$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(cadena);
      return buscador.find();
   }

   /**Método para validar cadenas de caracteres sin números*/
   public boolean isNom(String cadena) {
      String patron = "^\\D+$";
      Pattern patronRegex = Pattern.compile(patron);
      Matcher buscador = patronRegex.matcher(cadena);
      return buscador.find();
   }

   /**Método para validar una fecha en diferentes formatos*/
   public boolean isDate(String cadena) {
      String[] formatos = {"dd.MM.yy", "d-M-yy", "dd.MM.yyyy", "d-M-yyyy", "dd/MM/yy", "d/M/yy", "dd/MM/yyyy", "d/M/yyyy"};
      for (String formato : formatos) {
         if (isDateFormat(cadena, formato)) {
            return true;
         }
      }
      return false;
   }

   /**Método para validar una fecha*/
   public boolean isDateFormat(String cadena, String formato) {
      try {
         SimpleDateFormat sdf = new SimpleDateFormat(formato);
         //(true) Fechas como "febrero 30, 2024" podrían interpretarse como "marzo 1, 2024".
         //(false) Se Generará un ParseException al ser una fecha no válida.
         sdf.setLenient(false);
         //Intenta analizar la cadena como una fecha en un formato válido
         sdf.parse(cadena);
         return true;
      } catch (ParseException e) {
         return false;
      }
   }

   /**Método para validar un Color*/
   public boolean isColor(String cadena) {
      String[] formatos = {
              "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", // rrr.ggg.bbb
              "\\d{1,3}-\\d{1,3}-\\d{1,3}",     // rrr-ggg-bbb
              "\\d{1,3}/\\d{1,3}/\\d{1,3}"      // rrr/ggg/bbb
      };

      for (String formato : formatos) {
         if (cadena.matches(formato)) {
            // Separa los componentes del color [R, G, B]
            String[] partes = cadena.split("[.\\-/]");
            // Verificar que cada componente esté dentro del rango 0-255
            for (String parte : partes) {
               int valor = Integer.parseInt(parte);
               if (valor < 0 || valor > 255) {
                  return false;
               }
            }
            return true; // El formato es válido y los valores están en el rango
         }
      }
      return false; // No coincide con ningún formato
   }

   /**Método para validar cadenas de texto vaciás o nulas*/
   public boolean isStr(String cadena) {
      if (cadena == null || cadena.trim().isEmpty()){
         return false;
      }
      return true;
   }

   /**Método para validar un arreglo de cadenas de texto*/
   public boolean isStr(String[] cadena) {
      if (cadena == null || cadena.length == 0){
         return false;
      }
      return true;
   }

   /**Método para validar un directorio*/
   public boolean isDir(String cadena) {
      File directorio = new File(cadena);
      if (!directorio.exists() || !directorio.isDirectory() || directorio.isFile()) {
         return false;
      }
      return true;
   }

}