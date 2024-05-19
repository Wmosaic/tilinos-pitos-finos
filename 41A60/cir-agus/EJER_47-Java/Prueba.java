import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Prueba extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150,150));
        panel.setBackground(Color.WHITE);
        window.add(panel);

        button = new JButton("Draw");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        Graphics paper = panel.getGraphics();
        
        Circle circle = new Circle(20, 20);
        Square square = new Square(80,80);
        ArrayList<Shape> group = new ArrayList<Shape>();
        group.add(circle);
        group.add(square);

        paper.setColor(Color.WHITE);
        paper.fillRect(0,0,150,150);
        paper.setColor(Color.BLACK);
        
        for(Shape figuras: group)
            figuras.display(paper);
    }

    public static void main(String args[]){
        Prueba demo = new Prueba();
        demo.setSize(250,250);
        demo.createGUI();
        demo.setVisible(true);
    }
    
}
