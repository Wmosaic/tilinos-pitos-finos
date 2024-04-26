public class Gato extends Mamifero{
    private int numRatones;
    private int numArañasos;
    
    public Gato(){}
    
    public Gato(int numArañasos, int numRatones){
        this.numArañasos = numArañasos;
        this.numRatones = numRatones;
    }

    public Gato(String nombre,String color,String especie,
                int numPatas,int numAra, int numRat){
        super(nombre,color,especie,numPatas);
        this.numArañasos = numAra;
        this.numRatones = numRat;
    }

   public boolean setNumRatones(int nR){
        if (nR > 0) {
            this.numRatones = nR;
            return true;
        } else return false;
    }

    public boolean setNumArañasos(int nA){
        if (nA > 0){
            this.numArañasos = nA;
            return true;
        } else return false;
    }

    public int getNumRatones(){return this.numRatones;}
    public int getNumArañasos(){return this.numArañasos;}
    
    public String toString(){
        String res = "Numero de ratones: "+numRatones;
        res += "\nNumero de arañasos: "+numArañasos;
        return res;

    }
}
