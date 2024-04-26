public class Articulo {
    private String Descripcion;
    private String Unidad;
    private double PrecioU;
    private double Cantidad;
    
    public boolean setDescripcion(String Des) {
        if (Des.length() > 0) {
            Descripcion = Des;
            return true;
        } else 
            return false;
    }

    public boolean setUnidad(String Uni) {
        if (Uni.length() > 0) {
            Unidad = Uni;
            return true;
        } else 
            return false;
    }

    public boolean setPrecioU(double PU) {
        if (PU > 0) {
            PrecioU = PU;
            return true;
        } else 
            return false;
    }

    public boolean setCantidad(double Cant) {
        if (Cant > 0) {
            Cantidad = Cant;
            return true;
        } else 
            return false;
    }

    public String getDescripcion() { return Descripcion; }
    public String getUnidad() { return Unidad; }
    public double getPrecioU() { return PrecioU; }
    public double getCantidad() { return Cantidad; }

    public String toString() {
        String resultado = "Datos";
        resultado += " Descripcion: " + Descripcion;
        resultado += ", Unidad: " + Unidad;
        resultado += ", PrecioU: " + PrecioU;
        resultado += ", Cantidad: " + Cantidad;
        return resultado;
    }
}