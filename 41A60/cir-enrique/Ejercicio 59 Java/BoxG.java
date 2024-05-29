import cstio.*;

public class BoxG{
    Box <String> caja = new Box<String>();
    Pizarra p = new Pizarra();
    Dialog d = new Dialog();

    public void Inicio(){
        p.out("Mostrar la clase generica Box<T>" + '\n');
        p.setVisible(true);
    }

    public void GuardarObjeto(){
        String aux;
        aux = d.readString("Deme su texto a agregar: ");
        caja.add(aux);
    }

    public void resultado(){
        p.out(" El contenido de la caja es: "+caja.geT());
    }

    public static void main(String args[]){
        BoxG bg = new BoxG();
        
        bg.Inicio();
        bg.GuardarObjeto();
        bg.resultado();
    }
}