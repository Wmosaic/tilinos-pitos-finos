import utilFilesJava.*;
import java.io.File;

public class Main
{
   JavaCap Cap = new JavaCap();
   JavaCapJOptionpane CapJOP = new JavaCapJOptionpane();
   Miscellaneous Mis = new Miscellaneous();

   public static void main(String[] args)
   {
      Main main = new Main();
      main.testJavaCap(0);
      //main.testJavaCapJOP(0);
      //main.testMiscellaneous(0);
   }

   public void testJavaCap(int aux){
      switch (aux) {
         case 0 -> {
            //cap Genérico
            String s = Cap.cap("mensaje");
            System.out.println(s);
         }
         case 1 -> {
            //capInt
            int x1 = Cap.capInt("Entero");
            //capInt Limite
            int x2 = Cap.capInt("Entero, Lim?", 0);
            //capInt Rango
            int x3 = Cap.capInt("Entero, LimI?, LimS?",0, 10);
            System.out.println(x1 + x2 + x3);
         }
         case 2 -> {
            //capReal
            double y1 = Cap.capReal("Real");
            //capReal Limite
            double y2 = Cap.capReal("Real, Lim?", 0);
            //capReal Rango
            double y3 = Cap.capReal("Real, LimI?, LimS?",0, 1);
            System.out.println(y1 + y2 + y3);
         }
         case 3 -> {
            //capNom
            String n1 = Cap.capNom("Cadena");
            //capNom Limite
            String n2 = Cap.capNom("Cadena, LimC?", 10);
            System.out.println(n1 + n2);
         }
         case 4 -> {
            //capDate
            String d = Cap.capDate("Fecha");
            System.out.println(d);
         }
         case 5 -> {
            //capDir
            String c = Cap.capDir("Directorio");
            System.out.println(c);
         }
         case 6 -> {
            //capFile Genérico
            File[] f1 = Cap.capFile(".csv"); for (File file : f1) {System.out.println(file);}
            //capFile sin Directorio
            File f2 = Cap.capFile("mensaje, Extension",".csv");
            System.out.println(f2);
            //capFile con Directorio
            File f3 = Cap.capFile("mensaje, Directorio, Extension","C:\\Users\\EnrickMC\\Desktop\\POO\\ArchivosPrueba",".csv");
            System.out.println(f3);
         }
         case 7 -> {
            String[] opciones = {"Opcion A", "Opcion B", "Opcion C", "Opcion D"};
            //capList
            String o1 = Cap.capList("Lista, Opciones", opciones);
            //capList
            String o2 = Cap.capList("Lista, Opciones", new String[]{"Opcion A", "Opcion B", "Opcion C", "Opcion D"});
            System.out.println(o1 + o2);
         }
      }
   }

@SuppressWarnings("unused")
   public void testJavaCapJOP(int aux){
      switch (aux) {
         case 0 -> {
            //cap Genérico
            String s = CapJOP.cap("mensaje");
         }
         case 1 -> {
            //capInt
            int x1 = CapJOP.capInt("Entero");
            //capInt Limite
            int x2 = CapJOP.capInt("Entero, Lim?", 0);
            //capInt Rango
            int x3 = CapJOP.capInt("Entero, LimI?, LimS?",0, 10);
         }
         case 2 -> {
            //capReal
            double y1 = CapJOP.capReal("Real");
            //capReal Limite
            double y2 = CapJOP.capReal("Real, Lim?", 0);
            //capReal Rango
            double y3 = CapJOP.capReal("Real, LimI?, LimS?",0, 1);
         }
         case 3 -> {
            //capNom
            String n1 = CapJOP.capNom("Cadena");
            //capNom Limite
            String n2 = CapJOP.capNom("Cadena, LimC?", 10);
         }
         case 4 -> {
            //capDate
            String d = CapJOP.capDate("Fecha");
         }
         case 5 -> {
            //capDir
            String c = CapJOP.capDir("Directorio");
         }
         case 6 -> {
            //capFile Genérico
            File[] f1 = CapJOP.capFile(".csv"); for (File file : f1) {System.out.println(file);}
            //capFile sin Directorio
            File f2 = CapJOP.capFile("mensaje, Extension",".csv");
            //capFile con Directorio
            File f3 = CapJOP.capFile("mensaje, Directorio, Extension","C:\\Users\\EnrickMC\\Desktop\\POO\\ArchivosPrueba",".csv");
            //capJFile
            File f4 = CapJOP.capJFile("mensaje, Extension",".csv");
         }
         case 7 -> {
            String[] opciones = {"Opcion A", "Opcion B", "Opcion C", "Opcion D"};
            //capList
            String o1 = CapJOP.capList("Lista, Opciones", opciones);
            //capList
            String o2 = CapJOP.capList("Lista, Opciones", new String[]{"Opcion A", "Opcion B", "Opcion C", "Opcion D"});
         }
      }
   }

@SuppressWarnings("unused")
   public void testMiscellaneous(int aux){
      switch (aux) {
         case 0 -> {
            String datos = "Dato 1, Dato 2, Dato 3";
            //writeFile
            Mis.writeFile(datos, new File(System.getProperty("user.dir") + "/src/" + "Nombre_Archivo" + ".csv"), true);
         }
         case 1 -> {
            //readFile Especifico
            String a1 = Mis.readFile(1, new File(System.getProperty("user.dir") + "/src/" + "Nombre_Archivo" + ".csv"));
            //readFile Completo
            String[] a2 = Mis.readFile(new File(System.getProperty("user.dir") + "/src/" + "Nombre_Archivo" + ".csv"));
         }
         case 2 -> {
            //convertDate
            String Date = Mis.convertDate(Cap.capDate("Fecha"));
         }
      }
   }
}