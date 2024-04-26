public class Main {
    
    Empleado[] nomina = new Empleado[10];
    double totaliza = 0;
    int indice = 0;
    JavaCap Cap = new JavaCap();
    JavaVal Val = new JavaVal();

    public static void main(String[] args)
    {
       Main main = new Main();
       main.meta();
       main.Calculos();
       main.Reportar();
    }
 

    public void meta() {
        System.out.println("Capturar, calcular y desplegar datos de empleados y adminstradores");
        System.out.println("Totalizando los salarios, bonos y el total de ambos");
    }

    public void Datos() {
        

        String AFF = Cap.capNom("¿Qué tipo de Empleado es? ([N] para Normal, [A] para Administrador o [fin] para salir)");

        while (!AFF.toLowerCase().equals("fin") && indice < 10) {
            String nombre = Cap.capNom("Ingrese el nombre:",20);
            double salario = Cap.capReal("Ingrese el salario:",0);
            String nacimiento = Cap.capDate("Ingrese la fecha de nacimiento con formato (dd/mm/aaaa):");

            if (AFF.equals("A")) {
                String depto = Cap.capNom("Ingrese el departamento:",40);
                double bono = Cap.capReal("Ingrese el bono:", 0);
                nomina[indice] = new Administrador(nombre, salario, nacimiento, depto, bono);
            } 
            else if (AFF.equals("N")) {
                nomina[indice] = new Empleado(nombre, salario, nacimiento);
            } else {
                System.out.println("Tipo de empleado no válido.");
                continue;
            }
        }

    }
    public void Calculos() {
        double suma = 0;
        double bono = 0;

        for (int i = 0; i < indice; i++) {
            suma += nomina[i].getSalario();
            if (nomina[i] instanceof Administrador) {
                bono += ((Administrador) nomina[i]).getBono();
            }
        }

        totaliza = bono + suma;
    }

    public void Reportar() {
        double sumaSalarios = 0;
        double bono = 0;
        double totaliza = 0;

        System.out.println("Listado de Empleados:");
        System.out.println("Nombre          Salario         Fecha de Nacimiento         depto.          bono");
        System.out.println("_____________________________________________________________________________________");

        for (int i = 0; i < indice; i++) {
            Empleado empleado = nomina[i];
            System.out.print(empleado.toString());
            
            if (empleado instanceof Administrador) {
                Administrador admin = (Administrador) empleado;
                System.out.print(admin.toString());
                bono += (admin.getBono());
            }
            
            sumaSalarios += empleado.getSalario();
            System.out.println();
        }

        totaliza = sumaSalarios + bono;

        System.out.println("_____________________________________________________________________________________");
        System.out.println("Total salarios: " + sumaSalarios);
        System.out.println("Total bonos: " + bono);
        System.out.println("Total nómina: " + totaliza);
    }
}

