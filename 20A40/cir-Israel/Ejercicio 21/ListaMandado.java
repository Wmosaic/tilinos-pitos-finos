import java.util.Scanner;

public class ListaMandado {
    private Articulo[] articulos;
    private int cuenta;
    private final int MAX_ARTICULOS = 50;
    private final Scanner teclado;
    private final Miscelanius clr;
    private double subtotal;
    private double iva;
    private final double PORCENTAJE_IVA = 0.16;

    public ListaMandado() {
        teclado = new Scanner(System.in);
        clr = new Miscelanius();
    }

    public void meta() {
        System.out.println("Algoritmo de Lista del Mandado con IVA");
        System.out.println("---------------------------------------");
    }

    public void datosCSV(String nombreArchivo) {
        String[] lineas = clr.leerArchivoCSV(nombreArchivo);
        if (lineas == null) {
            System.out.println("Error al leer el archivo CSV.");
            return;
        }
        articulos = new Articulo[MAX_ARTICULOS];
        cuenta = 0;
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (cuenta < MAX_ARTICULOS && datos.length == 4) {
                Articulo articulo = new Articulo();
                articulo.setDescripcion(datos[0]);
                articulo.setUnidad(datos[1]);
                articulo.setCantidad(Double.parseDouble(datos[2]));
                articulo.setPrecioU(Double.parseDouble(datos[3]));
                articulos[cuenta++] = articulo;
            }
        }
    }

    public void datos() {
        clr.clrScr();
        articulos = new Articulo[MAX_ARTICULOS];
        cuenta = 0;
        System.out.println("Lista del mandado:");
        String desc;
        do {
            System.out.print("Nombre del artículo o \"Fin\": ");
            desc = teclado.nextLine().trim();
            if (!desc.equalsIgnoreCase("Fin") && cuenta < MAX_ARTICULOS && !desc.isEmpty()) {
                Articulo articulo = new Articulo();
                articulo.setDescripcion(desc);
                articulo.setPrecioU(clr.capReal("Precio unitario: "));
                articulo.setCantidad(clr.capReal("Cantidad o piezas: "));
                articulo.setUnidad(clr.capturarTexto("Unidad(kg, litros): "));
                articulos[cuenta++] = articulo;
            }
        } while (!desc.equalsIgnoreCase("Fin") && cuenta < MAX_ARTICULOS);
    }

    public void calculos() {
        subtotal = 0;
        for (int i = 0; i < cuenta; i++) {
            subtotal += articulos[i].getCantidad() * articulos[i].getPrecioU();
        }
        iva = subtotal * PORCENTAJE_IVA;
    }

    public void resultados() {
        clr.clrScr();
        System.out.println("Lista del mandado:");
        System.out.println("Cantidad | Unidad | Descripción  | Precio | Monto");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < cuenta; i++) {
            if (articulos[i].getDescripcion() != null) {
                System.out.printf("%-8.2f | %-6s | %-13s| %-6.2f | %.2f%n",
                        articulos[i].getCantidad(), articulos[i].getUnidad(),
                        articulos[i].getDescripcion(), articulos[i].getPrecioU(),
                        articulos[i].getCantidad() * articulos[i].getPrecioU());
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("IVA:      %.2f%n", iva);
        System.out.printf("Total:    %.2f%n", (subtotal + iva));
    }

    public static void main(String[] args) {
        ListaMandado listaMandado = new ListaMandado();
        String respuesta;
        do {
            listaMandado.clr.clrScr();
            listaMandado.meta();
            System.out.println("¿Cómo desea ingresar los datos?");
            System.out.println("1. Desde archivo CSV");
            System.out.println("2. Captura manual");
            System.out.print("Ingrese su elección (1/2): ");
            respuesta = listaMandado.teclado.nextLine();
            
            if (respuesta.equals("1")) {
                System.out.print("Ingrese el nombre del archivo CSV: ");
                String nombreArchivo = listaMandado.teclado.nextLine();
                listaMandado.datosCSV(nombreArchivo);
            } else if (respuesta.equals("2")) {
                listaMandado.datos();
            } else {
                System.out.println("Opción inválida. Por favor, elija 1 o 2.");
                continue;
            }
            listaMandado.calculos();
            listaMandado.resultados();
            System.out.println("-------------------------------------------");
            System.out.print("¿Desea una nueva lista del mandado? (s/n): ");
            respuesta = listaMandado.teclado.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
        listaMandado.teclado.close();
    }
}