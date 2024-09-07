import Menu.*;

public class Main {
   public static void main(String[] args) {
      boolean repeat;
      do{
         repeat = false;
         // Menú para elegir Archivo (Similar a JFileChooser)
         FileMenu fm = new FileMenu();
         String nameFile = fm.showDialog();

         //Si no se captura el nombre de un archivo (null o vacío)
         //Entonces se termina el ciclo y se cierra el programa
         if (nameFile != null && !(nameFile.trim().isEmpty())){
            //Menu para capturar datos
            CapMenu cm = new CapMenu(nameFile);
            repeat = cm.showDialog();
         }
      } while (repeat);
   }
}

