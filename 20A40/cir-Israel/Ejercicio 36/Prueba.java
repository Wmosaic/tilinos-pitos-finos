
public class Prueba {
    Employee[] lisEmpleados = new Employee[100];
    JavaCap cap = new JavaCap();
    double total = 0,subtotal = 0,sumaBono = 0;

    public void meta(){
        System.out.println("Capturar, calcular y desplegar las nominas");
        System.out.println("De N empleados y adminstradores");
        System.out.println("----------------------------------------");
    }

    public int datos(String promt){
        String tipo, nom, fecha,department;
        double salario, bono;
        int indice  = 0;

        tipo = cap.capNom(promt, 1);
        while (!(tipo.toLowerCase().equals("f")) && indice < 100){
            nom = cap.capNom("Deme el nombre: ", 40);
            salario = cap.capReal("Deme el salario: ", 1);
            fecha = cap.capDate("Deme la fecha de Nacimiento: ");
            if(tipo.toLowerCase().equals("a")) {
                department = cap.capNom("Deme el deapartamento: ", 40);
                bono = cap.capReal("Deme el bono: ",1);
                lisEmpleados[indice] = new Manager(nom,salario,fecha,department,bono);
            }else {
                lisEmpleados[indice] = new Employee(nom, salario, fecha);
            }
            indice++;
            tipo = cap.capNom(promt, 1);
        }
        return indice;
    }

    public void calculos(int limC){
        
        for (int i = 0; i < limC; i++) {
            subtotal += lisEmpleados[i].getSalary();
            if (lisEmpleados[i] instanceof Manager)
                sumaBono += ((Manager)lisEmpleados[i]).getBono();
        }
        total = subtotal + sumaBono;
    }

    public void salida(int limC){
        System.out.println("Lista de empleados los empleados ");
        System.out.println("----------------------------------------");
        for (int i = 0; i < limC; i++) {
            if (lisEmpleados[i] instanceof Manager){
                System.out.println("Para los adims."); 
                System.out.println(lisEmpleados[i].toString());
            }
            else{
                System.out.println("Para los normales.");
                System.out.println(lisEmpleados[i].toString());
            }
        }
        System.out.println("Suma nominas: "+subtotal);
        System.out.println("Suma Bonos: "+sumaBono);
        System.out.println("Total: "+total);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        int lim = 0;
        Prueba oPrueba = new Prueba();

        oPrueba.meta();
        lim = oPrueba.datos("Usted es: N.-ormal, A.-dministrador o F.-in: ");
        oPrueba.calculos(lim);
        oPrueba.salida(lim);
    }
    
}
