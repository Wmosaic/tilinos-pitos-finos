import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Miscelanius {
    private final Scanner tecla = new Scanner(System.in);

    public boolean isNum(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("\nPor favor, ingrese un número válido.");
            return false;
        }
    }

    public double capReal(String prompt) {
        String aux;
        do {
            System.out.print(prompt);
            aux = tecla.nextLine();
        } while (!isNum(aux));
        return Double.parseDouble(aux);
    }

    public void clrScr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String capturarTexto(String mensaje) {
        System.out.print(mensaje);
        return tecla.nextLine();
    }

    public String[] leerArchivoCSV(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            StringBuilder contenido = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            return contenido.toString().split("\n");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return new String[0];
        }
    }
}