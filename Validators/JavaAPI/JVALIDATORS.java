package Validators;
import java.util.regex.*;
import java.util.Scanner;

class JVALIDATORS {
    public boolean isNum(String cadena){
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNom(String cadena){
        String patron =  "^[^\\d]+$";
        Pattern patronRegex = Pattern.compile(patron);
        Matcher buscador = patronRegex.matcher(cadena);
        return buscador.find();
    }

    public boolean isDate(String cadena){
        String patron = "^([0-2][0-9])|(3[0-1])(/|-|\\.|_)((0[0-9])|(1[0-2]))(/|-|\\.|_)((19[0-9]{2})|([2-9][0-9]{3}))$";
        Pattern patronRegex = Pattern.compile(patron);
        Matcher buscador = patronRegex.matcher(cadena);
        return buscador.find();
    }

    int capInt(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        String aux = entrada.nextLine();

        while(!isNum(aux)){
            System.out.println(mensaje);
            aux = entrada.nextLine();
        }
        entrada.close();
        return Integer.parseInt(aux);
    }

    int capInt(String mensaje, int limite){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        String aux = entrada.nextLine();
        int numAux;
        do{
            while(!isNum(aux)){
                System.out.println(mensaje);
                aux = entrada.nextLine();
        }
        numAux = Integer.parseInt(aux);
        if(numAux <= limite)
            System.out.println("El valor debe ser mayor a " + limite);
        } while(numAux <= limite);
        entrada.close();
        return numAux;
    }

    int capInt(String mensaje, int limiteI, int limiteS){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        String aux = entrada.nextLine();
        int numAux;

        do{
            while(!isNum(aux)){
                System.out.println(mensaje);
                aux = entrada.nextLine();
        }
        numAux = Integer.parseInt(aux);
        if(!(limiteI <= numAux || limiteS >= numAux))
            System.out.println("El valor debe estar entre " + limiteI + " y " + limiteS);
        } while(!(limiteI <= numAux || limiteS >= numAux));
        entrada.close();
        return numAux;
    }

}
