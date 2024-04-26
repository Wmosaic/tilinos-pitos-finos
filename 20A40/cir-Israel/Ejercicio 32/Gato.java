public class Gato extends Mamifero {
  private byte ratonesAtrapados;
  private byte arañados;

  public Gato() {}

  public Gato(String especie) {
      super(especie, 4, "gris");
      ratonesAtrapados = 0;
      arañados = 0;
  }

  public Gato(String especie, int patas, String color, byte ratones, byte arañados) {
    super(especie, patas, color);
    setRatonesAtrapados(ratones);
    setArañados(arañados);
  }

  public boolean setRatonesAtrapados(byte ratones) {
      if (ratones > 0) {
          ratonesAtrapados = ratones;
          return true;
      } else return false;
  }

  public boolean setArañados(byte arañados) {
      if (arañados > 0) {
          this.arañados = arañados;
          return true;
      } else return false;
  }

  public byte getRatonesAtrapados() { return ratonesAtrapados; }
  public byte getArañados() { return arañados; }
}