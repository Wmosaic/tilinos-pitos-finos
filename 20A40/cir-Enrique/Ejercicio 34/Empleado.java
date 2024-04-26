public class Empleado {
    private String nombre;
    private double salario;
    private String fechaNac;
 
    Empleado(){}
    Empleado(String nombreC, double salarioC, String fechaNacC){
 
       this.nombre = nombreC;
       this.salario = salarioC;
       this.fechaNac = fechaNacC;
    }

    public boolean setNombre(String n){
       if (!n.isEmpty())
       {
          this.nombre = n;
          return false;
       } else {
          return true;
       }
    }

    public boolean setSalario(double s){
        if (s > 0)
            {
               this.salario = s;
               return true;
            } else {
               return false;
            }
    }

    public boolean setFechaNac(String f){
       try {
        this.fechaNac = f;
        return true;
       } catch (Exception e) {
        return false;
       }
    }


    public String getNombre(){
       return nombre;
    }
    
    public double getSalario(){
        return salario;
    }

    public String getFechaNac(){
        return fechaNac;
    }

    
    public String toString()
    {
        String concat = (this.nombre + "        " + this.salario + "       " + this.fechaNac);
       return concat;
    }
}
 