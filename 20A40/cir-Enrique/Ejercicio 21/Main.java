import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
   Articulo[] articulo = new Articulo[50];
   double[] monto = new double[50];
   double subtotal, total;
   int contador = 0;
   JavaCap Cap = new JavaCap();
   JavaVal Val = new JavaVal();

   public static void main(String[] args)
   {
      
      Main main = new Main();
      main.navegabilidad();

   }

   
   public void meta() {
      System.out.println("Capturar, calcular y desplegar");
      System.out.println("las descripciones y precios de una lista de ");
      System.out.println("n articulos Implementando la captura ");
      System.out.println("de datos centinela y la lectura de archivos CSV");
   }

   public void capturaManual() {
      articulo[contador] = new Articulo();

      for (int i = 0; i < articulo.length; i++) {
          String d_Articulo = Cap.capNom(
            "Captura la descripcion del articulo / fin: ");
          if (d_Articulo.toLowerCase().equals("fin")) {
              break;
          }
          String u_Articulo = Cap.capNom
          ("Captura la unidad del articulo: ");
          double c_Articulo = Cap.capReal
          ("Capture cuantas veces se compro el articulo: ");
          double p_Articulo = Cap.capReal
          ("Capture el precio unitario del articulo: ");
         

          articulo[contador] = new Articulo
          (d_Articulo, u_Articulo, c_Articulo, p_Articulo);
          contador++;
      }

      System.out.println("Se han capturado " + contador + " articulos.");
  }

   public void capturaCSV() {
   articulo[contador] = new Articulo();

   File Archivo = Cap.capFile(
        "Selecciona un Archivo:",
        "C:\\Users\\EnrickMC\\Desktop\\Ejercicios 21-40\\Ejercicio 21",
        ".csv");

   try (BufferedReader archivo = new BufferedReader(new FileReader(Archivo))) {
       archivo.readLine(); // Se lee el encabezado

       String lineaCSV;
       while ((lineaCSV = archivo.readLine()) != null) {
           String[] datos = lineaCSV.split(",");
           String descripcion = datos[0];
           String unidad = datos[1];
           int cantidad = Integer.parseInt(datos[2]);
           double precio = Double.parseDouble(datos[3]);

           articulo[contador] = new Articulo
           (descripcion, unidad, cantidad, precio);
           contador++;
       }
   } catch (IOException e) {
       System.err.println("Error al leer el archivo CSV: " + e.getMessage());
   }

   System.out.println
   ("Se han capturado " + contador + " articulos desde el archivo CSV.");
}

   public void calculos() {
   for (int i = 0; i < contador; i++) {
       monto[i] = articulo[i].getCantidad() * articulo[i].getPrecio();
       subtotal += monto[i];
   }

   total = subtotal + (subtotal * 0.16);
}

   public void salida() {
      System.out.println("\n--------------------------------------------");
      System.out.println("Cuenta de las compras");

      for (int i = 0; i < contador; i++) {
         System.out.println("\n--------------------------------------------");
         System.out.println(articulo[i].toString());
         System.out.println("Monto de la compra: $" + monto[i]);
      }
      System.out.println("\n--------------------------------------------");

      System.out.println("El subtotal es: $" + subtotal);
      System.out.println("El total (IVA 16%): $" + total);
  }

  public void navegabilidad() {
    String AFF = "S";

    while (AFF.toUpperCase().equals("S")) {
        meta();

        String[] opciones = {"Tradicional","Fichero"};
        String opcion = Cap.capList("Seleccione una opcion:", opciones);

        switch (opcion.toLowerCase()) {
            case "tradicional":
                capturaManual();
                break;
            case "fichero":
                capturaCSV();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
                continue;
        }

        calculos();
        salida();
        AFF = Cap.capNom("Desea repetir el proceso[S/N]: ");
    }
}
}
