public class Gato extends Mamifero{
    private int numRatones;
    private int numArañasos;

    
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
