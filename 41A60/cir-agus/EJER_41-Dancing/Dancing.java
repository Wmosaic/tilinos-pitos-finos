import cstio.Pizarra;

public class Dancing {
   
    public static void main(String args[]){
        Pizarra varPizarra = new Pizarra();
        Padre obtPadre = new Padre(varPizarra);
        Hija obtHija = new Hija(varPizarra);

        varPizarra.setVisible(true);
        obtPadre.bailar();
        obtHija.bailar();

    }
}
