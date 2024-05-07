public class Mamifero {
    private int patas;
    private String color;
    private String especie;
    
    public Mamifero() {}
    
    public Mamifero(String e, int p, String c) {
      especie = e;
      patas = p;
      color = c;
    }
    
    public boolean setEspecie(String e) {
      if (e.length() != 0) {
        especie = e;
        return true;
      } else return false;
    }
    
    public boolean setPatas(int p) {
      if (p >= 0 && p <= 4) {
        patas = p;
        return true;
      } else return false;    
    }
    
    public boolean setColor (String c) {
      if (c.length() != 0) {
        color = c;
        return true;
      } else return false;
    }
    
    public int getPatas() {  return patas;  }
    public String getColor() {  return color;  }
    public String getEspecie() {  return especie;  }
}