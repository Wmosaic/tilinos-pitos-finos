import cstio.*;

class TestBoxpizarra{
    Boxg <String> b = new Boxg <String>();
    Pizarra p = new Pizarra();
    Dialog d = new Dialog();

    public void inicio(){
        p.out("Para probar clases genericas Box<T>\n");
        p.setVisible(true);
    }

    public void guardaObjeto(){
        String aux;

        aux= d.readString("Deme un texto: ");
        b.add(aux);
    }

    public void resultados(){
        p.out("El contenido de la caja de texto es: "+b.getT());
    }

    public static void main (String args[]) {
        TestBoxpizarra tb = new TestBoxpizarra();

        tb.inicio();
        tb.guardaObjeto();
        tb.resultados();
    }

}