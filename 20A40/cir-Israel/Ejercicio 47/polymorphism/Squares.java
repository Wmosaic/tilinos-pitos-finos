
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Squares extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea textArea;

    public static void main(String[] args) {
        Squares demo = new Squares();
        demo.setSize(400,300);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textArea = new JTextArea(20, 10);
        window.add(textArea);

        button = new JButton("go");
        window.add(button);
        button.addActionListener(this);
    }


    public void actionPerformed(ActionEvent event) {
        int number = 1;
        while (number <= 5) {
            textArea.setText(textArea.getText() + Integer.toString(number) + " " +
                Integer.toString(number * number) + "\r\n");
            number++;                                   
        }

    }
}
