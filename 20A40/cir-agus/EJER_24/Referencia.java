class Referencia{
    int x = 0;

    Referencia incremento(){
        x++;
        return this;
    }
    
    public void meta(){
        System.out.print("\nEscribir y copilar el codigo de ");
        System.out.println("la presentacion 2.3");
        System.out.println("------------------------------");
    }

    public Referencia[] calculos(){

        Referencia r = new Referencia();
        Referencia alias;
        alias = r.incremento().incremento().incremento();
        alias.incremento().incremento();
        
        Referencia res[] = {r,alias};
        return res; 
    }

    public void salida(Referencia[] answ){
        System.out.println("r = "+answ[0].x);
        System.out.println("alias = "+answ[1].x);
    }

    public static void main(String args[]){
        Referencia cRefe =  new Referencia();

        cRefe.meta();
        cRefe.salida(cRefe.calculos());
    }
}