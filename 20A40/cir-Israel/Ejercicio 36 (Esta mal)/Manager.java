

public class Manager extends Employee{
  private String department;
  private double bono;

  public Manager() {}                 // first
  
  public Manager(String name, double salary, String bd, 
                 String dept, double bono) {                       
    super(name, salary, bd);   
    this.department = dept;
    this.bono = bono;           
  }

  public boolean setBono(double b) {
    if (b > 0) {
      bono = b;
      return true;
    } else return false;
  } 

  public boolean setDepto(String d) {
    if (d != null && !d.equals("")) {
      department = d;
      return true;
    } else return false;
  }

  /*public String getDetails() {
    // call parent method
    return super.getDetails() +  "\nDepartment: " + department
                              +  "\nBonus"+ bono;
  }*/

  public String getDepartment() {  return department;  }
  public double getBono() {  return bono;  }  

  public String toString(){
    String toM = super.toString();

    String cadString = toM +"Departamento: "+department+"\n";
    cadString += "Bono "+bono+"\n";
    return cadString;
  }
}









