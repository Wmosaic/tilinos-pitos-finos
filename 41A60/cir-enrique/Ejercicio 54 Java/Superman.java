import cstio.Pizarra;

public class Superman implements Flyer {
  protected Pizarra sup;

  public Superman() {}
  public Superman(Pizarra sup) {  this.sup = sup;   }


  public void takeOff() {
    sup.out("despegar\n");
    sup.ofoto("superman_takeoff.jpeg");
    sup.out("\n");
  }

  public void land() {
    sup.out("\n");
    sup.out("aterrizar\n");
    sup.ofoto("superman_land.jpeg");
    sup.out("\n");
  }

  public void fly() {    
    sup.out("\n");
    sup.out("volar\n");
    sup.ofoto("superman_fly.jpeg");
    sup.out("\n");
  }

  public void leapBulding() {    
    sup.out("\n");
    sup.out("saltar edificio\n");
    sup.ofoto("superman_leapbulding.jpeg");
    sup.out("\n");
  }
  
  public void stopBullet() {    
    sup.out("\n");
    sup.out("parar balas\n");
    sup.ofoto("superman_stopbullet.jpeg");
    sup.out("\n");
  }
}

