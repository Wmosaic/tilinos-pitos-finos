public class Nodo <T>{
    private T name;
    Nodo<T> next;
    int dato;

    public Nodo(T n){
        this.name = n;
    }

    public Nodo(Nodo<T> x)
    {
        dato = x.getDato();
        next = null;
    }
    public Nodo(Nodo<T> x, Nodo<T> n)
    {
        dato = x.getDato();
        next = n;
    }


    public int getDato()
    {
        return dato;
    }
    public Nodo<T> getEnlace()
    {
        return next;
    }
    public void setEnlace(Nodo<T> enlace)
    {
        this.next = enlace;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}