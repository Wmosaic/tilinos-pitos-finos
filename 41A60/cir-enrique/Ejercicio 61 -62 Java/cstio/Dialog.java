/** Dialog.java  clase hibrida
  ojo colocar comentarios de documentación javadoc

  class Dialog; 

  Sirve para desplegar cuadros de dialogo en la pantalla gráfica
  utiliza @see: javax.swing.JOptionPane;

  @author: Cirino Silva Tovar
  @version: 1.0
*/

package cstio;

import javax.swing.*;

public class Dialog {
  ImageIcon icon = new ImageIcon("images/middle.gif");
  JOptionPane jop = new JOptionPane();
  String msg = "se supone que los huevos no son verdes";
  String war = "Es peligroso !!!";
  String err = "Es un error !!!";
  String pla = "Mensaje plano:";
  String inf = "Informacion para usted:";
  String tit = "opciones disponibles";
  JFrame f = null;
  int WARNING = JOptionPane.WARNING_MESSAGE;
  int ERROR = JOptionPane.ERROR_MESSAGE;
  int PLAIN = JOptionPane.PLAIN_MESSAGE;
  int INFO = JOptionPane.INFORMATION_MESSAGE;
  int YESNO = JOptionPane.YES_NO_CANCEL_OPTION;
  int QUEST = JOptionPane.QUESTION_MESSAGE;
  Object[] opt = {"Yes, please",
                  "No, thanks",
                  "No eggs, no ham!"};
  Object[] pos = {"ham", "spam", "yam"};

  /** void display(String msg) despliega un cuadro de dialogo con mensaje.
   *  @param msg : String;
   *  @return No return value
   */
  public void display(String msg) {
    JOptionPane.showMessageDialog(f,msg);
  }

  /** void display(String msg, char ch) 
   *  despliega un cuadro de dialogo con mensaje e icono de prevencion
   *  segun la letra seleccionada 'W', para warning 
   *                              'E', para error
   *                              'P', mensaje plano
   *                            e 'I', informacion. 
   *  @param msg : String;
   *  @param ch  : char;
   *  @return No return value
   */
  public void display(String msg, char ch) {
    switch (ch) {
      case 'W':
      case 'w': JOptionPane.showMessageDialog(f, msg, war, WARNING);
                break;
      case 'E':
      case 'e': JOptionPane.showMessageDialog(f, msg, err, ERROR);
                break;
      case 'P':
      case 'p': JOptionPane.showMessageDialog(f, msg, pla, PLAIN);
                break;
      case 'I': 
      case 'i': JOptionPane.showMessageDialog(f, msg, inf, INFO, icon);
                break;
    }
  }

 /** Object readObject(Object msg, String tit, int o) 
   * captura un Objeto por lo general un numero 
   * en un cuadro de dialogo con mensaje titulo y la posicion 
   * de un arreglo que despliega un elemento extra.
   *  @param msg : Object;
   *  @param tit : String;
   *  @param   o : int
   *  @return Object
   */
  public Object readObject(Object msg, String tit, int o) {
    return JOptionPane.showInputDialog(f, msg, tit, PLAIN, icon, pos, pos[o]);
  }

 /** String readString(String msg) 
   * despliega un cuadro de dialogo con mensaje.
   *  @param msg : String;
   *  @return No return value
   */
  public String readString(String msg) {
    return JOptionPane.showInputDialog(msg);
  }

 /** int readOption (Object msg, String tit, int o) 
   * captura un entero 
   * en un cuadro de dialogo con mensaje titulo y la posicion 
   * de un arreglo que despliega un elemento extra.
   *  @param msg : Object;
   *  @param tit : String;
   *  @param   o : int
   *  @return int
   */
  
  public int readOption(Object []opt, Object msg, String tit, int o) {
    return JOptionPane.showOptionDialog(f, msg, tit, YESNO, QUEST, null, opt, opt[o]);   
  }

 /**  
   * captura un entero para confirmar una opcion deseada
   * en un cuadro de dialogo con mensaje Y 
   *  @param msg : Object;
   *  @param tit : String;
   * 
   *  @return int
   */
 
  public int confirm(Object msg, String tit) {
    return JOptionPane.showConfirmDialog(f, msg, tit, YESNO);
  }

  public static void main(String args[]) {
    Dialog d = new Dialog();

    d.display("mi mensaje de prevencion", 'W');
    d.display("error tras error", 'E');
    d.display("solo un mensaje plano", 'P');
    d.display("Esto es java", 'I');
    d.readOption(d.opt, d.msg, d.tit, 0);
    d.confirm(d.msg, d.tit);
    d.readObject(d.msg, "entrada estilisada", 2);
    d.display(d.readString("que cosa?: "));
  }
}

