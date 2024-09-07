public class Main {
   public static void main(String[] args) {
      System.out.println(vocalOut("Hola Mundo"));
   }

   // Método que recibe un String y devuelve la cadena eliminando las vocales
   public static String vocalOut(String s) {
      return Cadena(s, 0);
   }

   private static String Cadena(String s, int index) {
      String resultado = "";
      // Si el índice es mayor igual al tamaño de la cadena
      // Entonces romper el ciclo con un return vacío
      // Importante para detener la recursividad
      if (index >= s.length()) {
         return "";
      }

      // Si el carácter NO es una vocal entonces:
      // añadir a la nueva cadena sin vocales
      // llamar a isVocal para la comprobación
      if (isVocal(s.charAt(index), 0)) {
         resultado += s.charAt(index);
      }
      resultado += Cadena(s, index + 1);

      // Llamada recursiva para continuar revisando
      // el siguiente carácter en la cadena
      return resultado;
   }


   private static boolean isVocal(char c, int index) {
      String vocales = "aAáÁeEéÉiIíÍoOóÓuUúÚ";

      // Si el índice es mayor igual al tamaño de las vocales
      // Entonces romper el ciclo con un return true
      // Importante para detener la recursividad
      if (index >= vocales.length()) {
         return true;
      }

      // Si el carácter es una Vocal retornar false
      if (c == vocales.charAt(index)) {
         return false;
      }

      // Llamada recursiva para continuar revisando el
      // siguiente carácter en vocales.
      return isVocal(c, index + 1);
   }



}