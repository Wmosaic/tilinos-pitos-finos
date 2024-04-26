import cstio.Pizarra;

public class Dancing {
  public static void main(String []args) {
    Pizarra piz = new Pizarra();
    Parent p = new Parent(piz);
    Parent ch = new Child(piz);
    
    piz.setVisible(true);
    p.bailar();      // invocando al metodo 
    ch.bailar();     // polimorfico
  }
}

