public class Employee {              // mutable 
  private String name;   
  private double salary;
  private String birthDate;
  //private String place;           // puesto laboral

  public Employee() {}             // constructor por defecto
  
  public Employee(String name, double salary, String bd) {
    this.name = name;
    this.salary = salary;
    this.birthDate = bd;
  }

  public String getDetails() {
    return "Name: " + name + "\nSalary: " + salary;
  }
  
  public String getName() {  return name;  }
  public double getSalary() {  return salary;  }
  public String getBirthDate() {  return birthDate;  } 
  //public String getPlace() {  return place;  }
  
  public boolean setName(String n){
    if (n!=null && !n.equals("")) {
      name = n;
      return true;
    } else return false;
  } 
  
  public boolean setBirthDate(String fecha) {
    
    if (fecha.length() > 0) {  // validacion ingenua
       this.birthDate = fecha;
      return true;
    } else return false;
  }
  
  public boolean setSalary(double s) {
    if (s > 0) {
      salary = s;
      return true;
    }
    return false;
  }

  public String toString(){
    String cadString = "Nombre: "+name+"\n";
    cadString += "Salario: "+salary+"\n";
    cadString += "Fecha: "+birthDate+"\n";
    return cadString;

  } 
}
