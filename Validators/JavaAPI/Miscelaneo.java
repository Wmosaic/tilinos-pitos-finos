package utilFilesJava;

import java.io.*;

public class Miscelaneo {

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
   public void writeFile(String cadena, File directorio) {
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