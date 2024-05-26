/* Item
*  Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;

public abstract class Item {
 protected double price;

 public Item( double p ) {  price = p;  }

 public void setPrice( double newPrice ) {
   price = ( newPrice > 0 ? newPrice : 0 );
 }

 public double getPrice() {  return price;  }

 public abstract void draw( Graphics g, int startX, int endX, 
                                        int y, Color eraseColor);
}
