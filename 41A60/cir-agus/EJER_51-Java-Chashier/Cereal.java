/* Cereal
*  Anderson, Franceschi
*/
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Cereal extends Item {
 public Cereal( double p ) {     super( p ); }

 public void draw( Graphics g, int startX, int endX, int y, Color eraseColor ) {
  DecimalFormat money = new DecimalFormat( "$0.00" );

  String display1 = "Cereal:  Unit price = " + money.format( price );
  g.setColor( Color.blue );
  g.drawString( display1, 20, 50 );

  for ( int x = startX; x < endX; x += 5 ) {
    g.setColor( new Color( 255, 255, 51 ) );
    g.fillRect( x, y - 68, 48, 65 );
    g.setColor( Color.BLACK );
    g.drawString("Cereal", x + 5, y - 45 );
    g.setColor( Color.RED );
    g.drawOval( x + 18, y - 35, 8, 8 );
    g.drawOval( x + 13, y - 30, 8, 8 );
    g.drawOval( x + 23, y - 30, 8, 8 );
    g.fillArc( x + 10, y - 35, 24, 25, 0, -180 );
    try { Thread.sleep( ( int )( 100 ) );    }
    catch ( InterruptedException e )  {  e.printStackTrace( );   }
    // erase
    g.setColor( eraseColor ); // background
    g.fillRect( x, y - 70, 50, 70 );
   }
 }
}















