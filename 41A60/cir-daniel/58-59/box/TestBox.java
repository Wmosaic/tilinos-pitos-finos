//clase de prueba
import java.util.Scanner;

class TestBox {
    Box b = new Box();
    java.util.Scanner t = new java.util.Scanner(System.in);
    
    void inicio(){   System.out.println("Manipular Box");}

    void guardaObjeto(){
        System.out.print("Nombre del objeto: ");
        b.add(t.nextLine());
    }

    void repo(){ System.out.println("En la caja: "+ b.get());}

    public static void main(String args[]){
        TestBox tb = new TestBox();
        tb.inicio(); 
        tb.guardaObjeto(); 
        tb.repo();
    }
}