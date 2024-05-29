import java.awt.Graphics;
import java.util.Random;

public class Poligono extends Shape{
    private int[] xPuntos = new int[100];
    private int[] yPuntos = new int[100];
    private int lados = new Random().nextInt(5,11);
    
    public Poligono(){}

    public Poligono(int centroX, int centroY, int radio){
        x = centroX;
        y = centroY;
        size = radio; 
        //Configuracion de las coordenas
        for (int i = 0; i < lados; i++) {
            //Size es el radio
            xPuntos[i] = x + (int)(size*Math.cos(((2*Math.PI*i)/lados)
                                                -(Math.PI/2)));
            yPuntos[i] = y + (int)(size*Math.sin(((2*Math.PI*i)/lados)
                                                -(Math.PI/2)));
        }        
    }
    
    @Override
    public void display(Graphics drawArea) {
        drawArea.drawPolygon(xPuntos,yPuntos,lados);
    }
}