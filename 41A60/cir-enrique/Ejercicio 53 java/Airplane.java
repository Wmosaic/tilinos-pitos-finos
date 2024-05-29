import cstio.Pizarra;

public class Airplane implements Flyer {
  protected Pizarra air;

  public Airplane() {}
  public Airplane(Pizarra air) {  this.air = air;   }

  public void takeOff() {
    air.out("Despegue\n");
    air.ofoto("airplane_takeoff.jpeg");
    air.out("\n");
  }

  public void land() {
    air.out("\n");
    air.out("aterrizar\n");
    air.ofoto("airplane_land.jpeg");
    air.out("\n");
  }

  public void fly() {
    air.out("\n");
     air.out("volando\n");
     air.ofoto("airplane_fly.jpeg");
     air.out("\n");
  }
}
