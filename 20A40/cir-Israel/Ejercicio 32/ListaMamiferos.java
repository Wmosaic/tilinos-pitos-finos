import java.util.Scanner;

public class ListaMamiferos {
    Scanner tecla = new Scanner(System.in);
    Mamifero[] M = new Mamifero[15];
    int cuenta;

    void meta() {
        System.out.println("Para presentar una lista de mamiferos,");
        System.out.println("perros, gatos y otros");
    }

    boolean isNum(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("No se haga el gracioso y teclee un numero");
            return false;
        }
    }

    byte capNum(String prompt) {
        String aux;

        do {
            System.out.print(prompt);
            aux = tecla.nextLine();
        } while (!isNum(aux));
        return Byte.parseByte(aux);
    }

    char menuMamifero() {
        char ch;

        do {
            System.out.print("Es P)erro, G)ato u O)tro:");
            ch = Character.toUpperCase(tecla.nextLine().charAt(0));
        } while (ch != 'P' && ch != 'G' && ch != 'O');
        return ch;
    }

    void data() {
      String especie = "", c = "", t = "";
      int p = 0;
      byte r = 0;
      byte nm = 0;
  
      cuenta = 0;
      System.out.print("Especie del mamifero o \"fin\" para salir:");
      especie = tecla.nextLine();
      while (!especie.toLowerCase().equals("fin") && cuenta < M.length) {
          p = capNum("# de patas del mamifero:");
          System.out.print("Deme color del mamifero:");
          c = tecla.nextLine();
          char opcion = menuMamifero();
          if (opcion == 'P') {
              System.out.print("Tipo de Perro:");
              t = tecla.nextLine();
              nm = capNum("# de mordidos:");
              M[cuenta] = new Perro(especie, p, c, t, nm);
          } else if (opcion == 'G') {
              r = capNum("# ratones que ha cazado:");
              byte arañados = capNum("# de arañados:");
              M[cuenta] = new Gato(especie, p, c, r, arañados);
          } else {
              M[cuenta] = new Mamifero(especie, p, c);
          }
          cuenta++;
          System.out.print("\nEspecie mamifero o \"fin\" para salir:");
          especie = tecla.nextLine();
      }
  }  

    void sale() {
        System.out.println("Lista de mamiferos");
        System.out.println("___________________________________________________");
        System.out.println("Especie    patas   Color    Mordidos/Ratones   Tipo");
        System.out.println("___________________________________________________");
        for (int i = 0; i < cuenta; i++) {
            System.out.print(M[i].getEspecie() + "\t\t");
            System.out.print(M[i].getPatas() + "\t");
            System.out.print(M[i].getColor() + "\t\t");
            if (M[i] instanceof Perro) {
                Perro p = (Perro) M[i];
                System.out.print(p.getMordidas() + "\t");
                System.out.println(p.getRaza());
            }
            if (M[i] instanceof Gato) {
                Gato g = (Gato) M[i];
                System.out.println(g.getRatonesAtrapados());
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ListaMamiferos lm = new ListaMamiferos();

        lm.meta();
        lm.data();
        lm.sale();
    }
}