package cstio;

import cstio.Pizarra;

import java.awt.Color;

class PruebaPizarra {
  public static void main(String[] args) {
//    SwingUtilities.invokeLater(new Runnable() {
//      public void run() {
        Pizarra p = new Pizarra();
        
        p.out("Por omision las letras son romanas de 20\n");
        p.changeStyle("Helvetica", 20, Color.YELLOW, Color.magenta);
        p.out("Letrero");
        p.changeStyle("eufm10", 16, Color.RED, Color.black);
        p.out("esta es una prueba\n");
        p.ofoto("cat.jpg");
        p.cls();
        p.changeStyle("Comic Sans MS",25,Color.CYAN, Color.GRAY);
        p.out("\nEn perseguirme mundo \n que interesas");
        p.setVisible(true);
//      }
//    });
  }
}

