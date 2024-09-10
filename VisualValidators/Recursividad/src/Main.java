public class Main {
   public static void main(String[] args) {
      int[] nums = {6, 12, 11, 8, 22, 1, 10, 8, 14, 0, 30};
      System.out.println(alternatingSumAndSubtractR(nums));
   }

//------------------------------------------------------------------------------//
   public static String vocalOut(String s) {
      return Cadena(s, 0);
   }
//------------------------------------------------------------------------------//
   /** Método recursivo que retornar una nueva cadena de carácteres sin vocales*/
   private static String Cadena(String s, int index) {
      String resultado = "";

      if (index >= s.length()) {
         return "";
      }
      if (isVocal(s.charAt(index), 0)) {
         resultado += s.charAt(index);
      }

      return resultado + Cadena(s, index + 1);
   }
//------------------------------------------------------------------------------//
   /** Método para validar si el carácter es una vocal de forma recursiva*/
   private static boolean isVocal(char c, int index) {
      String vocales = "aAáÁeEéÉiIíÍoOóÓuUúÚ";

      if (index >= vocales.length()) {
         return true;
      }
      if (c == vocales.charAt(index)) {
         return false;
      }

      return isVocal(c, index + 1);
   }
//------------------------------------------------------------------------------//
//------------------------------------------------------------------------------//
   private static int sumaR(int[] nums) {
      return suma(nums, 0);
   }
//------------------------------------------------------------------------------//
   /** Método recursivo para obtener la suma de todos lo valóres de un arreglo */
   private static int suma(int[] nums, int index) {
      if (index < nums.length) {
         return nums[index] + suma(nums, index + 1);
      }
      return 0;
   }
//------------------------------------------------------------------------------//
//------------------------------------------------------------------------------//
   /** Método para imprimir los valores de un arreglo de izquierda a derecha y viceversa */
   private static void routsIndexPrint(int[] nums) {
      routeNormal(nums, 0);
      System.out.println();
      routeInverse(nums, 0);
   }
//------------------------------------------------------------------------------//
   /** Método para recorrer y mostrar los valores de izquierda a derecha*/
   private static void routeNormal(int[] nums, int index) {
      if (index < nums.length) {
         System.out.print(nums[index] + " ");
         routeNormal(nums, index + 1);
      }
   }
//------------------------------------------------------------------------------//
   /** Método para recorrer y mostrar los valores de derecha a izquierda*/
   private static void routeInverse(int[] nums, int index) {
      if (index < nums.length) {
         System.out.print(nums[nums.length - index - 1] + " ");
         routeInverse(nums, index + 1);
      }
   }
//------------------------------------------------------------------------------//
//------------------------------------------------------------------------------//
   private static int alternatingSumAndSubtractR(int[] nums) {
      return alternating(nums, 0);
   }
//------------------------------------------------------------------------------//
   /** Método recursivo para realizar alternadamente
    * la suma y resta de los valores de un arreglo*/
   private static int alternating(int[] nums, int index) {
      if (index >= nums.length) {
         return 0;
      }
      if (index % 2 == 0){
         return nums[index] + alternating(nums, index + 1);
      }

      return nums[index] - alternating(nums, index + 1);
   }
   //------------------------------------------------------------------------------//
   private static int alternatingSumAndSubtract(int[] nums) {
      int suma = 0;
      for (int i = 0; i < nums.length; i++) {
         if (i % 2 == 0){
            suma += nums[i];  //Suma +10 +5
         }else{
            suma -= nums[i];  //Resta -5 -5
         }
      }
      return suma;
   }
//------------------------------------------------------------------------------//

}
