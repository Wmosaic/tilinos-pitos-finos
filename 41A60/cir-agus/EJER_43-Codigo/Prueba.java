import java.io.File;
import java.util.Scanner;
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

    public int CapturaCSV(){
        String nombre, Fecha, Departamento;
        double Salario, Bono;
        int lim,sex = 1;
        String datos[],datosLinea[];
        int indice = 0;
        
        String miRuta,mens = "Seleccione su archivo: ",ext = ".csv";
        miRuta = CapFile.capDir("Capture su directorio de archivos(CSV): ");
        File archivo = CapFile.capFile(mens,miRuta,ext);
        datos = CapFile.readFile(archivo);
        lim = datos.length - 1 ;

        while (sex <= lim) {
            datosLinea = datos[sex].split(",");
            nombre = datosLinea[1];
            Salario = Double.parseDouble(datosLinea[2]);
            Fecha = datosLinea[3];
                
            if(datosLinea[0].toLowerCase().equals("administrador")){
                Departamento = datosLinea[4];
                Bono = Double.parseDouble(datosLinea[5]);
                Empleados[indice] = new Administrador(nombre,Salario,Fecha,Departamento,Bono);
            }
            else{
                Empleados[indice] = new Empleado(nombre, Salario, Fecha);
            }
            indice++;
            sex++;        
        }
        return indice;
    }

    public double[] Calculos(int numEmpleado){
        double totaliza, suma=0, bono =0 ;
        for(int i = 0; i < numEmpleado; i++){
            suma += Empleados[i].getSalary();
            if (Empleados[i] instanceof Administrador) 
                bono += ((Administrador)Empleados[i]).getBono();
        }
        totaliza = bono +suma;
        double[] misDatos = {totaliza,suma,bono};
        return misDatos;
    }

    public void Salida(int lim, double[] data){
        System.out.println("Lista de empleados los empleados ");
        System.out.println("----------------------------------------");
        for (int i = 0; i < lim; i++) {
            if (Empleados[i] instanceof Administrador){
                System.out.println("Para los adims."); 
                System.out.println(((Administrador)Empleados[i]).toString());
            }
            else{
                System.out.println("Para los normales.");
                System.out.println(Empleados[i].toString());
            }
        }
        System.out.println("Suma nominas: "+data[1]);
        System.out.println("Suma Bonos: "+data[2]);
        System.out.println("Total: "+data[0]);
        System.out.println("----------------------------------------");

    }

    public static void main(String args[]){
        String mens1 = "Seleccione su tipo N.-ormal / A.-dministrador: ";
        char aff;
        int limE = 0;
        Prueba p = new Prueba();
        Scanner sc = new Scanner(System.in);
        
        utilFilesJava.clear();
        p.meta();
        System.out.print("Seleccione su metodo M.-anual / A.-rchivo: ");
        aff = sc.nextLine().toLowerCase().charAt(0);
        
        switch (aff) {
            case 'n': limE = p.capturaManual(mens1);  break;
            case 'a': limE = p.CapturaCSV(); break;
            default:
                System.out.print("Seleccione una opcion valida");
                System.exit(0);
                break;
        }
        double data[] = p.Calculos(limE);
        p.Salida(limE, data);
        sc.close();
    }    
}
