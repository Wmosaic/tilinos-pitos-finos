import cstio.*
;
public class Padre{
    protected Pizarra p;
    
    Padre(){}
    Padre(Pizarra obtPizarra){this.p = obtPizarra;}

    public void bailar(){
        p.out("El padre Baila Tango");
        p.ofoto("tango.jpg");        
    }
}