class Referencia {  //tomado de Bruce Eckel  
  int x;         // Thinking in java    
    
Referencia incremento() {    
  x++;    
  return this;
}
public static void main(String []args) {   
  Referencia r= new Referencia();
  Referencia alias; // es null

  alias = r.incremento().incremento().incremento();
  alias.incremento().incremento();   
  System.out.println("x="+ r.x);
  System.out.print("alias="+ alias.x);  
 }
}