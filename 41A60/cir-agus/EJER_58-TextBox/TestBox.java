import java.util.Scanner;

public class TestBox{
    Box b = new Box();
    Scanner scan = new Scanner(System.in);

    public void Inicio(){
        System.out.println("Manipulacion la de Box");
    }

    public void guardarObjeto(){
        System.out.print("Capture su objeto a la caja: ");
        b.add(scan.nextLine());    
    }

    public void salida(){
        System.out.println("La caja en su objeto es: "+b.getObj());
    }

    public static void main(String args[]){
        TestBox tb = new TestBox();

        tb.Inicio();
        tb.guardarObjeto();
        tb.salida();
    }

}