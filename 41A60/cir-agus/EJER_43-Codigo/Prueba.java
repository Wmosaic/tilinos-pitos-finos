import java.io.File;

import JavaAPI.utilFilesJava;

//utilFilesJava
public class Prueba {
    Empleado[] Empleados = new Empleado[100];
    utilFilesJava CapFile = new utilFilesJava();

 
    public void meta(){
        System.out.println("Capturar, calcular y desplegar las nominas");
        System.out.println("De N empleados y adminstradores");
        System.out.println("Por medio de un archivo CSV o manual.");
        System.out.println("----------------------------------------");
    }

    public int capturaManual(String mensaje){
        String tipo, nom, fecha, department;
        double salario, bono;
        int indice  = 0;
        
        tipo = CapFile.capNom(mensaje, 1);
        while (!(tipo.toLowerCase().equals("f")) && indice < 100){
            nom = CapFile.capNom("Deme el nombre: ", 40);
            salario = CapFile.capReal("Deme el salario: ", 1);
            fecha = CapFile.capDate("Deme la fecha de Nacimiento: ");
            
            if(tipo.toLowerCase().equals("a")) {
                department = CapFile.capNom("Deme el deapartamento: ", 40);
                bono = CapFile.capReal("Deme el bono: ",1);
                Empleados[indice] = new Administrador(nom,salario,fecha,department,bono);
            }else Empleados[indice] = new Empleado(nom, salario, fecha);
            
            indice++;
            tipo = CapFile.capNom(mensaje, 1);
        }
        return indice;
    }

    public void CapturaCSV(){
        String miRuta,mens = "Seleccione su archivo: ",ext = ".csv";
        miRuta = CapFile.capDir("Capture su directorio de archivos(CSV): ");
        File archivo = CapFile.capFile(mens,miRuta,ext);
        if(archivo.isFile()){
            System.out.println("Es una archivo");
        }else System.out.println("no es archivo");

    }

    public void Calculos(){}

    public void Salida(){}

    public static void main(String args[]){
        Prueba p = new Prueba();
        p.CapturaCSV();

    }
    
}
