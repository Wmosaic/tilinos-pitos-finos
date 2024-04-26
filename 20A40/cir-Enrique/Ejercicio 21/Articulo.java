public class Articulo {
   private String description;
   private String unidad;
   private double precio;
   private double cantidad;

   Articulo(){}
   Articulo(String d_Articulo, String u_Articulo, double c_Articulo, double p_Articulo){

      this.description = d_Articulo;
      this.unidad = u_Articulo;
      this.cantidad = c_Articulo;
      this.precio = p_Articulo;
   }

   public boolean setDescription(String d)
   {
      if (!d.isEmpty())
      {
         this.description = d;
         return false;
      } else {
         return true;
      }
   }

   public boolean setUnidad(String u)
   {
      if (!u.isEmpty())
      {
         this.unidad = u;
         return true;
      } else {
         return false;
      }

   }

   public boolean setPrecio(double p)
   {
      if (p > 0)
      {
         this.precio = p;
         return true;
      } else {
         return false;
      }
   }

   public boolean setCantidad(double c)
   {
      if (c > 0)
      {
         this.cantidad = c;
         return true;
      } else {
         return false;
      }
   }

   public String getDescription()
   {
      return description;
   }
   public String getUnidad()
   {
      return unidad;
   }
   public double getPrecio()
   {
      return precio;
   }
   public double getCantidad()
   {
      return cantidad;
   }

   public String toString()
   {
      String concat = (getCantidad() 
      + " " + getUnidad() 
      + " de " + getDescription() 
      + " a $" + getPrecio());
      return concat;
   }

}
