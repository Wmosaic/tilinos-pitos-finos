import cstio.Pizarra;
import cstio.Dialog;
import java.awt.Color;

class PruebaPizarra {
  public static void main(String[] args) {
//    SwingUtilities.invokeLater(new Runnable() {
//      public void run() {
        Pizarra p = new Pizarra("Otro Letrero a peticion del usuario");
        Dialog d = new Dialog();
        String aux;
                
        p.setVisible(true);
        p.out("Por omision las letras son romanas de 20\n");
        aux = d.readString("De cualquier tecla para continuar");
        p.changeStyle("Helvetica", 20, Color.YELLOW, Color.magenta);
        p.out("Letrero");
        aux = d.readString("De cualquier tecla para continuar");
        p.changeStyle("eufm10", 16, Color.RED, Color.black);
        p.out("esta es una prueba\n");
        p.ofoto("cat.jpg");
        aux = d.readString("Despues del teclaso se limpia la pizarra");
        p.cls();
        p.changeStyle("Comic Sans MS",25,Color.CYAN, Color.GRAY);
        p.out("\nEn perseguirme mundo \n que interesas");        
//      }
//    });
  }
}

