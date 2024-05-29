import cstio.*;

class TestBox {
    Box <String> b= new Box<String>();
    Pizarra p = new Pizarra();
    Dialog d = new Dialog();

    public void inicio(){
        p.out("Para probar clases genericas Box<T>");
        p.setVisible(true);
    }
    public void guardaObjeto(){
        String aux;
        aux = d.readString("Deme un texto:");
        b.add(aux);
    }

    //no hay calculos

    public void resultados(){
        p.out("El contenido de la caja de texto es: " + b.getT());
    }

    public static void main (String args[]){
        TestBox tb = new TestBox();

        tb.inicio();
        tb.guardaObjeto();
        tb.resultados();
    }
}