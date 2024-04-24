import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import javax.swing.JOptionPane;

class utilFilesJava {

   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje){
    String aux = JOptionPane.showInputDialog(null, mensaje);

    while(!isNum(aux)){
       aux = JOptionPane.showInputDialog(null, mensaje);
    }
    return (int) Float.parseFloat(aux);
 }

 /**Método para capturar solamente números enteros con un limite determinado*/
 int capInt(String mensaje, int lim){
    int aux = capInt(mensaje);
    while (aux > lim){
       aux = capInt(mensaje + " (No mayor a " + lim + "):");
    }
    return aux;
 }

 /**Método para capturar solamente números enteros dentro de un rango determinado*/
 int capInt(String mensaje, int limI, int limS){
    int aux = capInt(mensaje);
    while (aux < limI || aux > limS){
       aux = capInt(mensaje + " ( entre " +  limI + " y " + limS + " ):");

    };
    return aux;
 }

 /**Método para capturar solamente números racionales*/
 double capReal(String mensaje){
    String aux = JOptionPane.showInputDialog(null, mensaje);

    while(!isNum(aux)){
       aux = JOptionPane.showInputDialog(null, mensaje);
    }
    return Double.parseDouble(aux);
 }

 /**Método para capturar solamente números racionales con un limite determinado*/
 double capReal(String mensaje, double lim){
    double aux = capReal(mensaje);
    while (aux > lim){
       aux = capReal(mensaje + " (No mayor a " + lim + "):");
    }
    return aux;
 }

 /**Método para capturar solamente números racionales dentro de un rango determinado*/
 double capReal(String mensaje, double limI, double limS){
    double aux = capReal(mensaje);
    while (aux < limI || aux > limS){
       aux = capReal(mensaje + " ( entre " +  limI + " y " + limS + " ):");
    }
    return aux;
 }

 /**Método para capturar solamente una cadena de texto*/
 String capNom(String mensaje) {
    String aux;
    do {
       aux = JOptionPane.showInputDialog(null, mensaje);
       while(isStr(aux)){
          aux = JOptionPane.showInputDialog(null, mensaje);
       }
    }while (!isNom(aux));
    return aux;
 }

 /**Método para capturar una cadena de texto con un límite de caracteres*/
 String capNom(String mensaje, int limC) {
    String aux = capNom(mensaje);

    while(!(aux.length() < limC)) {
       aux = capNom(mensaje + "(Menor a " + limC + " Caracteres): ");
    }

    return aux;
 }

 /** Método para capturar una fecha*/
 String capDate(String mensaje){
    String aux = JOptionPane.showInputDialog(null, mensaje);

    while(!isDate(aux)){
       aux = JOptionPane.showInputDialog(null, mensaje);
    }
    return aux;
 }

 /** Método para capturar un directorio*/
 String capDir(String mensaje) {
    String aux;
    do {
       aux = JOptionPane.showInputDialog(null, mensaje);
    while(aux == null){
       aux = JOptionPane.showInputDialog(null, mensaje);
    }
    } while (!isDir(aux));

    return aux;
 }

 /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lita).
  * -Directorio y extension validados, responsabilidad del programador*/
 File capFile(String mensaje, String directorio, String extension) {
    File dir = new File(directorio);
    File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
    String archivoSeleccionado = null;
    assert files != null;

    if (isDir(directorio)) {
       String[] nomFile = new String[files.length];

       for (int i = 0; i < files.length; i++) {
          nomFile[i] = files[i].getName();
       }

       while (archivoSeleccionado == null) {
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

/**-Método para capturar un dato de una lista en JOptionPane*/
 String capList(String mensaje, String[] opciones){
   String [] Lista = opciones;
   String aux = null;

   while (aux == null){
   aux = (String) JOptionPane.showInputDialog(
                     null, mensaje,
                     "Elegir",JOptionPane.QUESTION_MESSAGE,null, Lista, Lista[0]);
   }
   return aux;
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
      if (cadena == null || cadena.contains(" ") || cadena.isEmpty()){
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
