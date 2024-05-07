public class Perro extends Mamifero {
  private String raza;
  private byte mordidas;

  public Perro() {}
  
  public Perro(String especie) {        
      super(especie, 4,"negro");
      mordidas = 0;
  }

  public Perro(String especie, int patas, String color, String raza, byte mordidas) {
    super(especie, patas, color);
    setRaza(raza);
    setMordidas(mordidas);
  }

  public boolean setMordidas(byte m) {
    if (m > 0) {
      mordidas = m;
      return true;
    } else return false;
  }

  public boolean setRaza(String raza) {
    if (raza.length() != 0) {
      this.raza = raza;
      return true;
    } else return false;
  }    
  public byte getMordidas() { return mordidas; }
  public String getRaza() { return raza; }
}