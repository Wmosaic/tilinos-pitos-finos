import cstio.*;

public class Parent {
  protected Pizarra p;
  
  public Parent() {}
  public Parent(Pizarra p) {  this.p = p;  }

  public void bailar() {
    p.out("El padre baila tango.\n");
    p.ofoto("tango.jpg");
  }
}

