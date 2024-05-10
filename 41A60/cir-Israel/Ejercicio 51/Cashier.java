/* Cashier class
   Anderson, Franceschi
*/
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Cashier extends JFrame {
 private Cart cart;
 private Item previousItem;
 private double currentTotal;

 public Cashier( ) {
   super( "Chapter 6 Programming Activity 2" );
   cart = new Cart( );
   previousItem = null;
   currentTotal = 0.0;
   getContentPane( ).setBackground( cart.getBackground( ) );
   setSize( 300, 300 );
   setVisible( true );
 }

 public void checkout( int numberOfItems ) { 
   /* ***** Student writes the body of this method ***** */
   //
   //  The parameter of this method, numberOfItems,
   //  represents the number of items in the cart. The
   //  user will be pormpted for this number.
   //
   //  Using a for loop, calculate the total price
   //  of the groceries for the cart.
   for (int i = 1; i <= numberOfItems; i++) {
     Item j=getNext(); 
      
     currentTotal += j.getPrice();
     animate(currentTotal);
   }
   JOptionPane.showMessageDialog(null, "total="+currentTotal);
   //
   //  The getNext method (in this Cashier class) returns the next
   //  item in the cart, which is an Item object (we do not
   //  know which item will be returned; this is randomly generated).
   //  getNext does not take any arguments. its API is
   //      Item getNext( )
   //
   //  As the last statement of the body of your for loop,
   //  you should call the animate method.
   //  The animate method takes one parameter:  a double,
   //  which is your current subtotal.
   //  For example, if the name of your variable representing
   //  the current subtotal is total, your call to the animate
    //  method should be:
   //      animate( total );
   //
   //  The getPrice method of the Item class
   //  returns the price of the Item object as a double.
   //  The getPrice method does not take any arguments. Its API is
   //     double getPrice( )
   //
   //  After you have processed all the items, display the total
   //  for the cart in a dialog box.



   //
   //  End of student code
   //
 }

 public Item getNext()  {
   String aux = "Error: getNext( ) method called when cart is empty";
   JOptionPane jop = new JOptionPane();
   
   if ( cart.getTotalNumberItems() > cart.getNumberItems() ) {
     // get next item
     cart.setCurrentItem ( (int) ( Math.random() * cart.getItemSize() ) );
     // update previousItem so that we can keep track of the current total
     previousItem = cart.getItems()[cart.getCurrentItem()];
     // update number of items in cart
     cart.updateNumberItems();
     // update currentTotal
     if ( ( previousItem != null ) && ( previousItem.getPrice() >= 0 ) )
       currentTotal += previousItem.getPrice();
     cart.setExactTotal( currentTotal );
     return ( cart.getItems() )[cart.getCurrentItem()];
   } else {
       jop.showMessageDialog( null, aux, "Logic error",  jop.ERROR_MESSAGE );
       return null;
     }
 }

 public void animate( double subtotal ) {
   cart.updateTotal( subtotal );
   repaint( );
   try {  Thread.sleep( 3000 );  // wait for the animation to finish  }
  }catch ( Exception e ) {}
 }

 public void paint( Graphics g ) {
    super.paint( g );
    cart.draw( g );
 }

 public static void main( String [] args ) {
   Cashier app = new Cashier( );
   app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   int numItems = 0;
   boolean goodInput = false;
   
   do   {
      String howMany = JOptionPane.showInputDialog( null,
                 "Enter the number of items in the cart ( 1 - 10 )" );
      if ( howMany == null ) System.exit( 0 );
      try {
        numItems = Integer.parseInt( howMany );
        goodInput = true;
      } catch( NumberFormatException nfe ) {}  // goodInput is still false  }
   } while ( !goodInput || numItems < 1 || numItems > 10 );
   ( app.cart ).updateTotalNumberItems( numItems );
   app.checkout( numItems );
 }
}