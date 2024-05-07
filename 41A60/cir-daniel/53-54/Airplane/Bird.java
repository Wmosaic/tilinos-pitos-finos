import cstio.Pizarra;

public class Bird implements Flyer {
  protected Pizarra bi;

  public Bird() {}
  public Bird(Pizarra bi) {  this.bi = bi;   }

  public void takeOff() {
      bi.out("\naccelerate until lift-off.\n");
      bi.out("raise landing gear. \n\n");
      bi.ofoto("pajara_takeoff.jpeg");
      bi.out("\n\n");
  }
  public void fly() {
    bi.out("\n");
    bi.out("el pajaro vuela. \n\n");
    bi.ofoto("pajara_fly.jpeg");
    bi.out("\n\n");
  }
  public void land() {
    bi.out("\n");
      bi.out("lower landing gear\n");
      bi.out("decelerate and lower flaps until touch-down.\n");
      bi.out("apply breaks.\n\n");
      bi.ofoto("pajara_land.jpeg");
      bi.out("\n\n");
  }
  public void buildNeat() {
    bi.out("\n\n");
    bi.out("junta ramas para construir nido \n\n");
    bi.ofoto("pajara_neat.jpeg");
    bi.out("\n\n");

  }
  public void layEggs() {
    bi.out("\n");
    bi.out("pone huevos\n\n");
    bi.ofoto("pajara_eggs.jpeg");
    bi.out("\n\n");
  }
}

