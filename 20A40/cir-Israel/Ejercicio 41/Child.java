import cstio.Pizarra;

public class Child extends Parent {
  public Child () {}
  public Child (Pizarra p) { super.p = p ; }

  public void bailar() {
    p.out("El hijo baila Hip-Hop.\n");
    p.ofoto("hip_hop.jpg");
    p.out("el hijo ademas se comporta tambien como:\n");
    super.bailar();
  }
}
// ojo hay que flexibilisar la regla de "es un"
