public class Administrador extends Empleado {
    private String depto;
    private double bono;

    public Administrador(String nombreC, double salarioC, String fechaNacC, String deptoC, double bonoC) {
        super(nombreC, salarioC, fechaNacC);
        this.depto = deptoC;
        this.bono = bonoC;
    }

    public boolean setDepto(String dept) {
        if (dept.length() == 0)
            return false;
        this.depto = dept;
        return true;
    }
    
    public boolean setBono(double bono) {
        if (bono < 0)
            return false;
        this.bono = bono;
        return true;
    }


    public String getDepto() {
        return this.depto;
    }

    public double getBono() {
        return this.bono;
    }

    
    public String toString() {
        String concat = (super.toString() + "           " + this.depto + "          " + this.bono);
        return concat;
    }
}