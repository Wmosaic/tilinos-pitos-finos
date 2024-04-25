
public class Perro extends Mamifero{
    private int numLadridos;
    private String tipo;

    public boolean setNumLadridos(int nl){
        if (nl > 0) {
            this.numLadridos = nl;
            return true;
        } else return false;
    }
    
    public boolean setTipo(String tp){
        if(tp.length() > 0){
            this.tipo = tp;
            return true;
        }else return false;
    }

    public int getNumLadridos(){
        return this.numLadridos;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String toString(){
        String res = "Numero de ladridos: "+numLadridos;
        res += "\n El tipo: "+tipo;
        return res;

    }
}
