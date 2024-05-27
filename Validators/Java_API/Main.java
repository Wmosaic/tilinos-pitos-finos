import java.io.File;

public class Main
{
   public static void main(String[] args)
   {
      utilFilesJava Cap = new utilFilesJava();

      int aux = 7;

      switch (aux) {
         case 1 -> {
            int n = Cap.capInt("Ingresa un Numero:");
            System.out.println("El numero ingresado es valido: " + n);
         }
         case 2 -> {
            String p = Cap.capNom("Ingresa una Palabra:", 4);
            System.out.println("La palabra ingresada es valida: " + p);
         }
         case 3 -> {
            String fecha = Cap.capDate("Ingrese una fecha en el formato dd/mm/yyyy: ");
            System.out.println("La Fecha es: " + fecha);
         }
         case 4 -> {
            String d = Cap.capDir("Ingresa un Directorio: ");
            System.out.println("El Directorio ingresado es valido: \n" + d);
         }
         case 5 -> {
            File f = Cap.capFile("Selecciona un Archivo:",
                    "C:\\Users\\EnrickMC\\Desktop\\POO\\Lista_Articulo Python",
                    ".csv");
            System.out.println(f);
         }
         case 6 -> {
            File f = Cap.capJFile("Selecciona un Archivo:", "csv");
            System.out.println("El archivo es: " + f);
         }
         case 7 -> {
            String [] opciones ={"Kg (Kilogramos)","Lt (Litros)","Cm (Centimetros)","U (Unidades)","T (Toneladas)"};
            String l = Cap.capList("Selecciona una opción:", opciones);
            System.out.println("La opción seleccionada es: " + l);
         }
      }
   }
}