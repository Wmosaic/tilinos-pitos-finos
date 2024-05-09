import cstio.Pizarra;
public class Hija extends Padre{
    Hija(Pizarra ini){
        super(ini);
    }


    public void bailar(){
        System.out.println();
        super.p.out("El hijo baila Hip-Hop");
        super.p.ofoto("hip_hop.jpg");
        super.p.out("Tambien de comporta como: ");
        super.bailar();
    }
}