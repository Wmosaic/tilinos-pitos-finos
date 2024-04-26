import javax.swing.*;
import java.io.File;

//Todos los capturadores hacen uso del JOptionPane

public class JavaCap {
   private JavaVal val;

   /**Constructores para inicializar los validadores dependiendo el contexto*/
   JavaCap(){
      this.val = new JavaVal();
   }
   JavaCap(JavaVal val){
      this.val = val;
   }


   /**Método para capturar solamente números enteros*/
   int capInt(String mensaje){
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!val.isNum(aux)){
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

      while(!val.isNum(aux)){
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
         while(val.isStr(aux)){
            aux = JOptionPane.showInputDialog(null, mensaje);
         }
      }while (!val.isNom(aux));
      return aux;
   }

   /**Método para capturar una cadena de texto con un límite de caracteres*/
   String capNom(String mensaje, int limC) {
      String aux = capNom(mensaje);

      while(!(aux.length() <= limC)) {
         aux = capNom(mensaje + "(Menor a " + limC + " Caracteres): ");
      }

      return aux;
   }

   /** Método para capturar una fecha*/
   String capDate(String mensaje){
      String aux = JOptionPane.showInputDialog(null, mensaje);

      while(!val.isDate(aux)){
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
      } while (!val.isDir(aux));

      return aux;
   }

   /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lita).
    * -Directorio y extension validados, responsabilidad del programador*/
   File capFile(String mensaje, String directorio, String extension) {
      File dir = new File(directorio);
      File[] files = dir.listFiles((directory, file) -> file.toLowerCase().endsWith(extension));
      String archivoSeleccionado = null;
      assert files != null;

      if (val.isDir(directorio)) {
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
}
