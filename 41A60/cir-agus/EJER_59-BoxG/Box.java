public class Box <T>{
    private T t;

    public void add (T t){ this.t = t; }
    public T geT() { return this.t; }
    public String toString(){ return String.valueOf(this.t); }
}
