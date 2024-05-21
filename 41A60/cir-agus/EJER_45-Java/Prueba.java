import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import JavaAPI.*;


public class Prueba {
    private utilFilesJava cap = new utilFilesJava();
    private int repeticionMoneda[] = new int[100];


    public void Meta(){
        System.out.println("----------------------------");
        String  meta = "Capturar, desplegar y calcular las monedas";
        meta += " dentro de un monedero y el valor de cada divisas";
        meta += " permitiendo la captura de datos por fichero y guardar";
        meta += " ademas de guardar los datos capturados y el reporte";
        meta += " generado";
        System.out.println(meta);
        System.out.println("----------------------------");
    }

    public ArrayList<Moneda> capturaManual(){
        ArrayList<Moneda> monedas = new ArrayList<Moneda>();
        String div,pai,esc;
        int año,rep,cuenta = 0;
        double val;
        
        System.out.println("Capture los datos de la moneda.");
        div = cap.capNom("Capture el nombre de la divisa: ",40);
        do{
            val = cap.capReal("Capture el valor de la divisa: ",1.0);
            pai = cap.capNom("Deme el pais: ");             
            año = cap.capInt("Deme el año de la moneda: ", 1);
            esc = cap.capNom("Deme el nombre del escudo: ",40);
            rep = cap.capInt("¿Cuantas monedas son?: ", 1);
            monedas.add(new Moneda(div, val, pai, año, esc));
            repeticionMoneda[cuenta] = rep;
            cuenta++;
            div = cap.capNom("Capture el nombre de la divisa: ",40);
        }while(!(div.toLowerCase().equals("fin")) && cuenta <100);

        return monedas;
    }

    public ArrayList<Moneda> capturaFicheros(){
        ArrayList<Moneda> monedas = new ArrayList<Moneda>();
        File myFile;
        String miRuta,div,pai,esc,misData[],Linea[];
        double val;
        int año,rep;

        miRuta = cap.capDir("Deme su directorio de archivos: ");
        myFile = cap.capFile("Seleccione su archivo: ", miRuta,".csv");
        if(!myFile.exists()){System.exit(0);}
        misData = cap.readFile(myFile);

        for(int i = 1; i <= misData.length-1; i++){
            try{
               Linea = misData[i].split(",");
               div = Linea[0];
               val = Double.parseDouble(Linea[1]);
               pai = Linea[2];
               año = Integer.parseInt(Linea[3]);
               esc = Linea[4];
               rep = Integer.parseInt(Linea[5]);
               monedas.add(new Moneda(div, val, pai, año, esc));
               repeticionMoneda[i-1] = rep;
           }catch(NumberFormatException e){ 
            System.out.println("Hubo un error en la lectura"); 
            System.exit(0);
           }
        }

        return monedas;
    }

    public ArrayList<String> filtrarDivisa(ArrayList<Moneda> MiMonedero){
        HashSet<String> DivisaUni = new HashSet<String>();
        
        for(Moneda misDiv: MiMonedero)
            DivisaUni.add(misDiv.getDivisa()); 

            ArrayList<String> nueDiv = new ArrayList<String>(DivisaUni);
    
        return nueDiv;
    } 

    public double[][] calculosDeValores(
                      ArrayList<Moneda> monedas,
                      ArrayList<String> nueDivisas
                      ){   
        int rangoNuevo = nueDivisas.size();
        int rangoViejo = monedas.size();
        double dineros = 0, valor,miSub;
        double valorPorCadaDivisa[] = new double[rangoNuevo];
        double subTotal[] = new double[rangoViejo];
        boolean comp;
        String lower;
    
        for(int j = 0; j < rangoNuevo; j++){
            dineros = 0;
            for(int i = 0; i < rangoViejo; i++){
                lower = nueDivisas.get(i).toLowerCase();
                comp = lower.equals(monedas.get(i).getDivisa());
                if(comp){
                    valor = repeticionMoneda[i] * monedas.get(i).getValor();
                    dineros += valor;
                }
            }
                valorPorCadaDivisa[j] = dineros;
        }

        for(int k = 0; k < rangoViejo; k++){
            miSub = repeticionMoneda[k] * monedas.get(k).getValor();
            subTotal[k] = miSub;
        }
        double misResultados[][] = {valorPorCadaDivisa,subTotal};
        return misResultados;
    } 

    public void guardarReporte(
        ArrayList<Moneda> monedas,
        ArrayList<String> nueDivisa,
        double[][] misCalculos
    ){
        System.out.println("Guardar reporte generado");
        String fileName,sub,mensaje;
        int limOld = monedas.size(), limNew = nueDivisa.size();
        fileName = cap.capNom("Deme el nombre del : ", 40);
        
        try{
            FileWriter fileOut = new FileWriter(fileName);
            for(int i = 0; i < limOld; i++){
                fileOut.write(monedas.get(i).toString()+" ");
                sub = String.valueOf(misCalculos[1][i]);
                fileOut.write("Con un subtotal: "+sub+'\n');
            }

            for(int k = 0; k < limNew; k++){
                sub = String.valueOf(misCalculos[0][k]);
                mensaje = "La divisa: "+nueDivisa.get(k);
                mensaje += " suma un total de: "+sub;
                fileOut.write(mensaje+'\n');
            }
            
            fileOut.close();
        }catch(IOException e){
            System.out.println("Hubo un error inesperado");
        }
    }

    public void guardarDatos(ArrayList<Moneda> monedas){
        String fileName,div,pai,esc,linea;
        int año,rep,repIter = 0;
        double val;
        System.out.println("Guardar datos Capturados");
        fileName = cap.capNom("Deme el nombre del archivo: ",40);
        
        try{
            FileWriter fileOut = new FileWriter(fileName);
            fileOut.write("Divisa,Valor,Pais,Año,Escu,Repeticiones"+'\n');
            
            for(Moneda moneda: monedas){
                div = moneda.getDivisa();
                val = moneda.getValor();
                esc = moneda.getEscudo();
                año = moneda.getAño();
                pai = moneda.getPais();
                rep = repeticionMoneda[repIter];
                linea = div+','+val+','+pai+','+año+','+esc+','+rep;
                fileOut.write(linea+'\n');
            }
            fileOut.close();
        }catch(IOException e){
            System.out.println("Hubo un error inesperado");
        }
    }

    public void impDePantalla(
        ArrayList<Moneda> monedas,
        ArrayList<String> nueDiv,
        double[][] calculos
    ){
        int limO = monedas.size(), limN = nueDiv.size();
        double rep;
        for(int i = 0; i < limO; i++){
            System.out.print(monedas.get(i).toString());
            rep = calculos[1][i];
            System.out.println("Total Monedas: "+repeticionMoneda[i]);
            System.out.println("El subtotal: "+rep);
        }

        for(int j = 0; j < limN; j++){
            System.out.println("---------------------");
            String mens = "La divisa: "+nueDiv.get(j);
            mens += " suma un total de: "+calculos[0][j];
            System.out.println(mens);
        }
    }

    public static void main(String args[]){
        String mens = "Seleccione la letra en mayuscula,";
        mens += " [A]rchivo o [M]anual ";
        mens += "o [S]alir: ";
        String mesn2 = "Desea Repetir el programa[S/N]?: ";
        ArrayList<Moneda> mon;
        ArrayList<String> nueDiv;
        Prueba pb = new Prueba();
        char cicl = 'S',opc;
        
        while(cicl == 'S' || cicl == 's'){
            utilFilesJava.clear();
            pb.Meta();
            opc = pb.cap.capNom(mens,2 ).toLowerCase().charAt(0);
            switch(opc){
                case 'a': mon = pb.capturaFicheros(); break;
                case 'm': mon = pb.capturaManual(); break;
                case 's': System.exit(0);
                default: continue;  
            }
            nueDiv = pb.filtrarDivisa(mon);
            double [][] cal = pb.calculosDeValores(mon, nueDiv);
            pb.impDePantalla(mon, nueDiv, cal);
            pb.guardarDatos(mon);
            pb.guardarReporte(mon, nueDiv, cal);
            cicl = pb.cap.capNom(mesn2, 2).toLowerCase().charAt(0);
        }
    }
}
