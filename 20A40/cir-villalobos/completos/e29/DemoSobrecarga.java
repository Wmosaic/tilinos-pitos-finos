class Sobrecarga {
    public void prueba(){  System.out.println("Metodo sin argumento.");  }
    
    //Sobrecarga de prueba()con un parametro tipo int
    
    public void prueba(int x){
    	System.out.print("Metodo con 1 argumento.");
    	System.out.println("x = " + x);
    }
    
    public void prueba(int y, int f) {
        System.out.println("El valor del argumento y ="+y);
        System.out.println("el valor de f = "+f);
    }
    //Sobrecarga de prueba()con dos parametros tipo int
    
    public void prueba(int x, boolean y){
    	System.out.print("Metodo con 2 argumentos.");
    	System.out.println("x = " + x +"; y = " + y);
    }
    
    //Sobrecarga de prueba()con tres`parametros
    
    public void prueba(double x, double y, double z){
    	System.out.print("Metodo con 3 argumentos.");
    	System.out.println("x=" +x+" ; y=" +y+ "; z = " +z);
    }
}
    
    //clase con el metodo main()

public class DemoSobrecarga{
   public static void main(String []args){
      Sobrecarga objeto=new Sobrecarga();
         
      //llamada a los metodos sobrecargados
      objeto.prueba();
      objeto.prueba(29);   
      objeto.prueba(45, 30);
      objeto.prueba(21, false);
      objeto.prueba(-2.5, 10.0, 5.1);
   }
}    

