import java.lang.reflect.*;
import java.lang.Object;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

//El verdadero capCenti

public class capCenti{
    private Map<Method, String> diccionario = new HashMap<>();
    private JavaCap capturador = new JavaCap();

    //Se usa arraylist porque no se puede saber cual es la cantidad de 
    //metodos que va a tener el objeto encapsulado.

    //El hashMap guarda en pares: funcion, nombre de la funcion
    //lo que permite acceder a cualquiera de sus datos, e incluso
    //los nombres y tipos de los atributos correspondientes a 
    //cada uno de sus setters.

    private List<Class<?>> tiposM = new ArrayList<>(); 
    private List<Class<?>> tiposA = new ArrayList<>();
    private List<String> nombres = new ArrayList<>();

    private void conseguirTiposMetodos(Method[] metodos){
        for (Method m : metodos)
            tiposM.add(m.getReturnType());
    }

    private void conseguirAtributos(Field[] atributos){
        for (Field a : atributos){
            tiposA.add(a.getType());
            nombres.add(a.getName());
        }
    }

    private void llenarDiccionario(Method[] metodos){          
        int contador = 0;
        Pattern patron;
        Matcher emparejador;
        while (contador < tiposM.size()){
            patron = Pattern.compile("set"+nombres.get(contador));
            for (int i = 0; i < tiposM.size(); i++) {
                emparejador = patron.matcher(metodos[i].getName());
                if (emparejador.find()) {
                    diccionario.put(metodos[i], nombres.get(contador));
                    contador++;
                }
            }
        }
    }

    //Funcion incompleta, por el momento se queda asi
    //probablemente hay mejores maneras de poder controlar el ciclo

    //TODO: Generar un ciclo while donde asignamos el capInt, capReal, o capNom
    ///     dependiendo del atributo y su tipo de retorno.

    public <T> T llenarAtributos(T objeto){
        for (Map.Entry<Method, String> foo: diccionario.entrySet()) {
            switch (foo.getKey().getReturnType().getTypeName()) {
                case "int":
                    while (!) {
                        
                    }
                    break;
                case "double":

                    break;
                case "String":

                    break;
                default:
                System.out.println("Tipo de dato no aceptado.");
                    break;
            }
        }

        return objeto;
    }



    public <T> T centinela (T objeto){
        Class<?> clase = objeto.getClass();
        Method[] metodos = clase.getDeclaredMethods();
        Field[] atributos = clase.getDeclaredFields();

        conseguirTiposMetodos(metodos);
        conseguirAtributos(atributos);
        llenarDiccionario(metodos);

        objeto = llenarAtributos(objeto);



        System.out.println("\n\n\n"+metodos[0].getName());
        System.out.println(atributos[0].getName() + "\n" +atributos[1].getName());

        return objeto;
    }

    //Una vez este terminada la funcion centinela, esta funcion main se 
    //puede ir yendo al carajo.
    public static void main(String[] args) {
        capCenti centi = new capCenti();
        cajas caja = new cajas();
        centi.centinela(caja);
    }

}
//Clase de prueba
class cajas {
    int x = 3;
    int y = 4;
    String eso = "hola";
    void decirHola(){    System.out.println(eso);    }

    boolean setX(int p_x){
        if(p_x<2){
            this.x = p_x;
            return true;
        } else return false;
    }

    boolean setY(int p_y){
        if(p_y<2){
            this.y = p_y;
            return true;
        } else return false;
    }

    boolean setEso(String p_eso){
        if (p_eso.length() != 0 && !p_eso.equals("")) {
            this.eso = p_eso;
            return true;
        } else return false;
    }
}
