public class Mamifero{
    private int numPatas;
    private String color;
    private String especie;
    private String nombre;

    public boolean setPatas(int np){
        if (np >= 2){
            this.numPatas = np;
            return true;
        }
        else return false;
    }

    public boolean setColor(String col){
        if(col.length() > 0){
            this.color = col;
            return true;
        } else return false;
    }

    public boolean setEspecie(String e){
        if (e.length() > 0){
            this.especie = e;
            return true;
        }else return false;
    }

    public boolean setNombre(String nom){
        if(nom.length() > 0){
            this.nombre = nom;
            return true;
        }
        else return false;
    }

    public int getPatas(){
        return this.numPatas;
    }

    public String getColor(){return this.color;}
    public String getEspecie(){return this.especie;}
    public String getNombre(){return this.nombre;}

    public String toString(){
        String rs = "Numero de patas: "+numPatas;
        rs += "\nColor: "+color;
        rs += "\nEspecie: "+especie;
        rs += "\nNombre: "+nombre;
        return rs;
    }
}