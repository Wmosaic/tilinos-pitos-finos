public class Administrador extends Empleado{
    private String Departamento;
    private double Bono;

    public Administrador(){}
    
    public Administrador(
        String name, double sal, String bd, String dept, double bono
           )
    {
        super(name,sal,bd);
        this.Departamento = dept;
        this.Bono = bono;
    }

    public boolean setDepartamento(String dept){
        if(dept != null && !dept.equals("")){
            this.Departamento = dept;
            return true;
        } else return false;
    }

    public boolean setBono(double bono){
        if(bono > 0){
            this.Bono = bono;
            return true;
        }else return false;
    }

    public String getDepartamento(){return Departamento;}
    public double getBono(){ return Bono; }

    public String toString(){ //Redifinacion del metodo toString()
        String toM = super.toString();
    
        String cadString = toM +"Departamento: "+Departamento+"\n";
        cadString += "Bono "+Bono+"\n";
        return cadString;
      }

    
}
