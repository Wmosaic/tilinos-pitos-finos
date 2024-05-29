import cstio.Pizarra;

public class Runway2 {
    public static void main(String[] args) {
        Pizarra piz = new Pizarra();
        Airplane air = new Airplane(piz);
        Bird bi = new Bird(piz);
        Superman sup = new Superman(piz);

        piz.setVisible(true);
        
        bi.takeOff();
        bi.fly();
        bi.land();
        bi.buildNeat();
        bi.layEggs();  
        

        air.takeOff();
        air.fly();
        air.land();
   
   
        sup.takeOff();
        sup.fly();
        sup.land();
        sup.leapBulding();
        sup.stopBullet();

        
    }
}
