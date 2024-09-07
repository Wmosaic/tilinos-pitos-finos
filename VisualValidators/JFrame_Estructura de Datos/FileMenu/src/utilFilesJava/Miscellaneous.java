package utilFilesJava;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Miscellaneous {

   /**Método para leer una línea en un archivo csv/txt
    * Recibe la dirección de un archivo para su funcionamiento
    * @param directorio La ruta/dirección del archivo que se va a leer
    * @param linea Especifica la línea que se quiera leer
    * @return Una línea en específico (en formato String) dentro del archivo*/
   public String readFile(int linea, File directorio) {
      BufferedReader rf = openFile(directorio);
      String lineas = readInfo(rf, linea);
      cerrarArchivo(rf);

      return lineas;
   }

   private String readInfo(BufferedReader archivo, int linea){
      try{
         String lineaCSV;
         int contador = 0;

         while ((lineaCSV = archivo.readLine()) != null) {
            if (contador == linea) {
               return lineaCSV; // Retorna la línea solicitada
            }
            contador++;
         }

         return null;
      } catch (IOException e) {
         System.out.println("Error: No se pudo leer la información");
         throw new RuntimeException(e);
      }
   }

   /**Método para leer archivos csv/txt, adjuntando los datos en líneas de texto
    * Recibe la dirección de un archivo para su funcionamiento
    * @param directorio La ruta/dirección del archivo que se va a leer
    * @return Todas las cadenas (en formato String) dentro del archivo*/
   public String[] readFile(File directorio) {
      BufferedReader rf = openFile(directorio);
      String[] lineas = readInfo(rf);
      cerrarArchivo(rf);

      return lineas;
   }

   private BufferedReader openFile(File directorio){
      try {
         return new BufferedReader(new FileReader(directorio));
      } catch (FileNotFoundException e) {
         System.out.println("Error: No se pudo abrir el archivo");
         throw new RuntimeException(e);
      }
   }

   private String[] readInfo(BufferedReader archivo){
      try{
         ArrayList<String> lineas = new ArrayList<>();
         String lineasFile;

         while ((lineasFile = archivo.readLine()) != null) {
            lineas.add(lineasFile);
         }
         return lineas.toArray(new String[0]);
      } catch (IOException e) {
         System.out.println("Error: No se pudo leer la información");
         throw new RuntimeException(e);
      }
   }

   private void cerrarArchivo(BufferedReader archivo) {
      try {
         archivo.close();
      } catch (IOException e) {
         System.out.println("Error: Imposible cerrar el archivo: ");
      }
   }


   /**Método para escribir sobre archivos csv/txt
    * Recibe la dirección de un archivo nuevo o existente para su funcionamiento
    * Si el archivo no existe, se creará; si existe, se abrirá para agregar texto.
    * @param cadena Es la línea completa (en formato String) que se va a agregar
    * @param directorio La ruta/dirección del archivo en el cual se va a escribir
    * @param append Modo de escritura:
    * True: Cualquier contenido que se escriba se agregará, sin borrar el contenido previo.
    * False: El contenido del archivo se borrará y el nuevo contenido escrito reemplaza al anterior.*/
   public void writeFile(String cadena, File directorio, boolean append) {
      Writer wf = openFile(directorio, append);
      if (wf != null) {
         saveInfo(wf, cadena);
         closeFile(wf);
      }
   }

   /** Método para abrir el archivo. */
   private Writer openFile(File directorio, boolean append){
      try{
         return new FileWriter(directorio, append);
      }catch (IOException e){
         System.out.println("Error: No se pudo abrir el archivo");
         return null;
      }
   }

   /** Método para guardar los datos en el archivo. */
   private void saveInfo(Writer wf, String cadena){
      try {
         wf.append(cadena).append("\n");
      } catch (IOException e) {
         System.out.println("Error: No se pudo guardar la información. " + e.getMessage());
      }
   }

   /** Método para leer el archivo. */
   private void closeFile(Writer wf){
      try {
         wf.flush();
         wf.close();
      } catch (IOException e) {
         System.out.println("Error: No se puede cerrar el archivo. " + e.getMessage());
      }
   }

   /** Método para eliminar un archivo
    * @param directorio La ruta/dirección del archivo que se va a eliminar*/
   public void deleteFile(File directorio) {
      directorio.delete();

   }

   /**Método para convertir la fecha a un formato específico
    * @param date La fecha que se quiera reformatear
    * @return La fecha con el formato establecido*/
   public String convertDate(String date) {
      String[] formatos = {"dd.MM.yy", "d-M-yy", "dd.MM.yyyy", "d-M-yyyy", "dd/MM/yy", "d/M/yy", "dd/MM/yyyy", "d/M/yyyy"};
      for (String formato : formatos) {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            sdf.setLenient(false);
            java.util.Date parsedDate = sdf.parse(date);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            return outputFormat.format(parsedDate);
         } catch (ParseException e) {
            // Continúa con el siguiente formato
         }
      }
      return null;
   }


   public Color convertColor(String aux) {
      String[] formatos = {
              "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", // rrr.ggg.bbb
              "\\d{1,3},\\d{1,3},\\d{1,3}",     // rrr-ggg-bbb
              "\\d{1,3}-\\d{1,3}-\\d{1,3}",     // rrr-ggg-bbb
              "\\d{1,3}/\\d{1,3}/\\d{1,3}"      // rrr/ggg/bbb
      };

      // Verificar si el formato del input coincide con alguno de los formatos especificados
      for (String formato : formatos) {
         if (aux.matches(formato)) {
            // Separar los componentes del color
            String[] partes = aux.split("[.\\-/,]");

            if (partes.length == 3) {
               try {
                  int r = Integer.parseInt(partes[0]);
                  int g = Integer.parseInt(partes[1]);
                  int b = Integer.parseInt(partes[2]);

                  // Crear y retornar el objeto Color
                  return new Color(r, g, b);
               } catch (NumberFormatException e) {
                  return null;
               }
            }
         }
      }
      return null; // Si no coincide con ningún formato
   }

   /**Esto funcionará en terminales que admitan códigos de escape ANSI.
    * No funcionará en Windows CMD, No funcionará en la terminal IDE.*/
   public void clear() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
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
