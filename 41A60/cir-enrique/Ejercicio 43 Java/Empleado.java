public class Empleado {
    private String nombre;
    private double Sueldo;
    private String FechaN;

    public Empleado(){}

    public Empleado(String name, double salary, String bd){
        this.nombre = name;
        this.Sueldo = salary;
        this.FechaN = bd; 
    }

    public boolean setName(String n){
        if (n!=null && !n.equals("")) {
          this.nombre = n;
          return true;
        } else return false;
      } 
      
      public boolean setBirthDate(String fecha) {
        
        if (fecha.length() > 0) {  // validacion ingenua
           this.FechaN = fecha;
          return true;
        } else return false;
      }
      
      public boolean setSalary(double s) {
        if (s > 0) {
          this.Sueldo = s;
          return true;
        } else return false;
      }

      public String getName(){ return nombre;      }
      public double getSalary(){ return Sueldo;    }
      public String getBirthDate(){ return FechaN; }
      
      public String toString(){
        String cadString = "Nombre: "+nombre+"\n";
        cadString += "Salario: "+Sueldo+"\n";
        cadString += "Fecha: "+FechaN+"\n";
        return cadString;
    
      } 
    
}
