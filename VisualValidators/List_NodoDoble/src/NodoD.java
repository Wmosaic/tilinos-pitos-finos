public class NodoD<T>{
    private T name;
    NodoD<T> next, previous;
    int dato;

    public NodoD(T n){
        this.name = n;
    }

    public NodoD(NodoD<T> x)
    {
        dato = x.getDato();
        next = null;
    }
    public NodoD(NodoD<T> x, NodoD<T> n)
    {
        dato = x.getDato();
        next = n;
    }


    public int getDato()
    {
        return dato;
    }
    public NodoD<T> getEnlace()
    {
        return next;
    }
    public void setEnlace(NodoD<T> enlace)
    {
        this.next = enlace;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}