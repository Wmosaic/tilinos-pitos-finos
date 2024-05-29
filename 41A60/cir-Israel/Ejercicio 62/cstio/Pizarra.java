/** Pizarra.java
 * @author: Por Cirino Silva Tovar
 * @version: 1.1 
 * modificado el 10 de febrero 2015
 * Basado en un ejemplo de:
 * Author:  andbin - http://andbin.altervista.org
 * License: Public Domain
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS, IMPLIED OR OTHERWISE, INCLUDING WITHOUT LIMITATION, ANY
 * WARRANTY OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.
 */

package cstio;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Pizarra extends JFrame {  
  private JTextPane textPane;
  private JScrollPane scrollPane;
  private DefaultStyledDocument styledDoc = new DefaultStyledDocument();
  private SimpleAttributeSet attr = new SimpleAttributeSet();
  
  public Pizarra() {
    this("pantalla de salida");
  }
  
  public Pizarra(String tit) {
    super(tit);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(600, 300);     
    textPane = new JTextPane(styledDoc);
    scrollPane = new JScrollPane(textPane);
    getContentPane().add(scrollPane);
    setLocationRelativeTo(null);
    StyleConstants.setForeground(attr, Color.BLUE);
    StyleConstants.setFontSize(attr, 20);
    StyleConstants.setFontFamily(attr, "Times New Roman"); 
  }
 
 /** void out(String line) 
   * despliega una cadena con los atributos por omision.
   * Fuente, tamaño y color   
   *  @param line : String;
   */
   public void out(String line) {
    try {
      styledDoc.insertString(styledDoc.getLength(), line, attr);
    } catch (BadLocationException e) {
       // This should not happen according to how text is inserted in the
       // code above .... if happens, the exception is printed.
        System.err.println(e);
      }
  }
  
  public void cls(){
    textPane.setText("");
  }  

 /** void changeStyle(String font, int size, Color c, Color f) 
   * cambia los atributos señalados por el programador 
   * en la posterior ocurrencia de texto. 
   * Fuente, tamaño y color   
   *  @param font : String;
   *  @param size : int;
   *  @param c    : @see: java.awt.Color; Font
   *  @param f    : @see: java.awt.Color; Fondo
   */
   public void changeStyle(String font, int size, Color c, Color f) {
     attr = new SimpleAttributeSet();
     StyleConstants.setForeground(attr, c);
     textPane.setBackground(f);
     StyleConstants.setFontSize(attr, size);
     StyleConstants.setFontFamily(attr, font); 
  }

 /** void ofoto(String f) 
   * despliega una imagen alimentada del un archivo f
   *  @param f    : String;
   */
  public void ofoto(String f) {
    try {    
      StyleConstants.setIcon(attr, new ImageIcon(f));            
      styledDoc.insertString(styledDoc.getLength(), " ", attr);
      attr = new SimpleAttributeSet();
      StyleConstants.setForeground(attr, Color.BLUE);
      StyleConstants.setFontSize(attr, 20);
      StyleConstants.setFontFamily(attr, "Times New Roman");  
    } catch(BadLocationException e) {  System.err.println(e); }
  }

 /** void out(String line, String font, int size, Color c) 
   * despliega una cadena con los atributos señalados por el programador.
   * Fuente, tamaño y color   
   *  @param line : String;
   *  @param font : String;
   *  @param size : int;
   *  @param c    : @see: java.awt.Color; 
   */
  public void out(String line, String font, int size, Color c) {
    try {     
      SimpleAttributeSet attr = new SimpleAttributeSet();

      StyleConstants.setForeground(attr, c);
      StyleConstants.setFontSize(attr, size);
      StyleConstants.setFontFamily(attr, font); 
      styledDoc.insertString(styledDoc.getLength(), line, attr);
    } catch (BadLocationException e) {
        // This should not happen according to how text is inserted in the
        // code above .... if happens, the exception is printed.
        System.err.println(e);
      }
  }  
}

