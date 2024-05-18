public class Moneda{
    private String Divisa;
    private double Valor;
    private String Pais;
    private int Año;
    private String Escudo;

    public Moneda(){}
    
    public Moneda(String div,double val, String pai, int año,String esc){
        this.Divisa = div;
        this.Valor = val;
        this.Pais = pai;
        this.Año = año;
        this.Escudo = esc;
    
    }

    public boolean setDivisa(String div){
        if(div.length() > 0){
            this.Divisa = div;
            return true;
        }else return false;
    }

    public boolean setValor(double val){
        if(val > 0){
            this.Valor = val;
            return true;
        } else return false;
    }

    public boolean setPais(String pai){
        if(pai.length() > 0){
            this.Pais = pai;
            return true;
        } else return false;
    }

    public boolean setAño(int año){
        if( año > 0){
            this.Año = año;
            return true;
        }else return false;
    }

    public boolean setEscudo(String esc){
        if(esc.length() > 0){
            this.Escudo = esc;
            return true;
        }else return false;
    }

    public String getDivisa(){ return this.Divisa; }
    public double getValor(){ return this.Valor; }
    public String getPais(){ return this.Pais; }
    public int getAño(){ return this.Año; }
    public String getEscudo(){ return this.Escudo; }

    public String toString(){
        String valor = String.valueOf(this.Valor);
        String year = String.valueOf(this.Año);
        
        String cadena = "----------------------------\n";
        cadena += "La divisa: "+this.Divisa+"\n";
        cadena += " El valor: "+valor+"\n";
        cadena += " El pais: "+this.Pais+"\n";
        cadena += " El año: "+year+" \n";
        cadena += " El escudo: "+this.Escudo+"\n";
        cadena += "----------------------------\n";
        return cadena;
    }
}