import java.util.Scanner;

class testBox {
    Box b= new Box();
    Scanner t = new Scanner(System.in);
    
    void meta(){
        System.out.println("manipula box");
    }

    void guardaO (){
        System.out.println("Nombre: ");
        b.add (t.nextLine());
    }

    void revisaBox (){
        System.out.println("En la caja: "+b.get());
    }
    
    public static void main (String args[]){
        testBox tb= new testBox();
        tb.meta(); 
        tb.guardaO();
        tb.revisaBox();
    }
}