/* Cart
*  Anderson, Franceschi
*/
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Cart {
 Item[] items;
 int itemSize = 3;
 int currentItem;
 int currentNumberItems;
 int totalNumberItems;
 double currentTotal;
 double exactTotal;
 Color background = new Color( 205, 205, 205 );

 public Cart() {
  items = new Item[itemSize];
  //
  // Student can modify constructors' arguments below
  // Check out the 3 constructors
  // argument represents price
  //
  items[0] = new Milk( 2.00 );
  items[1] = new Cereal( 3.50 );
  items[2] = new OrangeJuice( 3.00 );
  //
  //
  currentNumberItems = 0;
  totalNumberItems = 0;
  currentTotal = 0.0;
  exactTotal = 0.0;
  currentItem = -1;
 }

 public void setCurrentItem( int ci ) {  currentItem = ci;  }
 public int getCurrentItem( )         {  return currentItem;  }
 public Item [] getItems( )           {  return items;  }
 public int getItemSize( )            {   return itemSize;  }
 public void updateTotal(double newCurrentTotal) {  currentTotal = newCurrentTotal;  }
 public void updateNumberItems( )     {  currentNumberItems++;  }
 public int getNumberItems( )         {  return currentNumberItems;  }
 
 public void updateTotalNumberItems( int newTotalNumberItems ) {
  totalNumberItems = newTotalNumberItems;
 }

 public int getTotalNumberItems( ) {  return totalNumberItems;  }
 public void setExactTotal( double newExactTotal ) { exactTotal = newExactTotal;  }
 public Color getBackground( )     {  return background;  }

 public void draw( Graphics g ) {
    g.setColor( Color.black );
    g.drawString( "EXPRESS LANE", 110, 35 );
    g.setColor( Color.black );
    g.fillRoundRect( 50, 200, 150, 10, 2, 2 );  // belt
    g.setColor( new Color( 220, 110, 55 ) );
    g.fill3DRect( 195, 200, 60, 70, true ); // bag

    DecimalFormat money = new DecimalFormat( "$0.00" );

    String displayItemNumber = "Item # " + currentNumberItems + " of " 
                                         + totalNumberItems;
    String displayStudentTotal = "Your subtotal = " + money.format( currentTotal );
    String displayExactTotal = "Correct subtotal = " + money.format( exactTotal );

    g.setColor( Color.blue );
    g.drawString( displayItemNumber, 220, 50 );
    g.drawString( displayStudentTotal, 20, 75 );
    g.drawString( displayExactTotal, 20, 100 );
    if ( currentItem != -1 )
      items[currentItem].draw( g, 50, 200, 200, background );
 }
}