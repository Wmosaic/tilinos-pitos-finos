import cstio.Pizarra;

public class Runway {
    public static void main(String[] args) {
        Pizarra piz = new Pizarra();
        Airplane air = new Airplane(piz);

        piz.setVisible(true);
        
        air.takeOff();
        air.fly();
        air.land();
 
        
    }
}
