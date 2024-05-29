// warning: incomplete program
// This file contains all the classes for this program,
// except for class Defender. (Completing this is an exercise)
// The program needs 4 graphics files - see program text.
// These need to be in the same folder as the program.
// 4 suggested image files are available within the folder that contains this file.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Invader extends JFrame
implements ActionListener, MouseListener, MouseMotionListener {

    private JButton button;
    private JPanel panel;

    private Alien alien;
    private Defender defender;
    private Laser laser;
    private Bomb bomb; 

    private Timer timer;

    public static void main(String[] args) {
        Invader frame = new Invader();
        frame.setSize(250,280);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

        button = new JButton("start");
        window.add(button);
        button.addActionListener(this);

        timer = new Timer(100, this);

        newGame();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            newGame();
        }
        if (event.getSource() == timer) {
            timer_Tick();
        }
    }

    public void mouseClicked(MouseEvent event) {
        int initialX  = defender.getX();
        int initialY  = defender.getY();
        if (laser == null) {
            laser = new Laser(initialX, initialY);
        }
    }

    public void mouseMoved(MouseEvent event) {
        defender.move(event.getX());
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    private void timer_Tick() {
        if (bomb == null) {
            bomb = new Bomb(alien.getX(), alien.getY());
        }
        moveAll();
        drawAll();
        checkHits();
    }

    private void moveAll() {
        alien.move();
        if (bomb != null) {
            bomb.move();
        }
        if (laser != null) {
            laser.move();
        }
    }

    private void checkHits() {
        if (collides(laser, alien)) {
            endGame("defender");
        }
        else {
            if (collides(bomb, defender)) {
                endGame("alien");
            }
        }
        if (bomb != null) {
            if (bomb.getY() > panel.getHeight()) {
                bomb = null;
            }
        }
        if (laser != null) {
            if (laser.getY() < 0) {
                laser = null;
            }
        }
    }

    private boolean collides(Sprite one, Sprite two) {
        if (one == null || two == null) {
            return false;
        }
        if (    one.getX() > two.getX()
            &&  one.getY() < (two.getY() + two.getHeight())
            && (one.getX() + one.getWidth()) < (two.getX() + two.getWidth())
            && (one.getY() + one.getWidth()) > (two.getY())) {
            return true;
        }
        else {
            return false;
        }
    }

    private void endGame(String winner) {
        laser = null;
        bomb = null;
        timer.stop();
        JOptionPane.showMessageDialog(null, "game over - " + winner + " wins");
    }

    private void newGame() {
        defender = new Defender();
        alien = new Alien();
        timer.start();
    }

    private void drawAll() {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.white);
        paper.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        defender.draw(panel);
        alien.draw(panel);
        if (laser != null) {
            laser.draw(panel);
        }
        if (bomb != null) {
            bomb.draw(panel);
        }
    }
}

class Sprite {

    protected int x, y, width, height;

    public int getX() {
        return x;
    } 

    public int getY() {
        return y;
    } 

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class Alien extends Sprite { 

    private int stepSize;
    private ImageIcon alienImage;

    public Alien() {
        x = 0;
        y = 25;
        width = 20;
        height = 10;
        stepSize = 10;        
        alienImage = new ImageIcon("alien.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        alienImage.paintIcon(panel, paper, x, y);
    }

    public void move() {
        if (x > 200 || x < 0) {
            stepSize = -stepSize;
        }
        x = x + stepSize;
    }
}

class Bomb extends Sprite {

    private int stepSize;
    private ImageIcon bombImage;


    public Bomb(int initialX, int initialY) {
        x = initialX;
        y = initialY;
        width = 5;
        height = 10;
        stepSize = 10;        
        bombImage = new ImageIcon("bomb.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        bombImage.paintIcon(panel, paper, x, y);

    }

    public void move() {
        y = y + stepSize;
    }
}

class Laser extends Sprite {

    private int stepSize;
    private ImageIcon laserImage;

    public Laser(int newX, int newY) {
        x = newX;
        y = newY;
        width = 5;
        height = 5;
        stepSize = 10;        
        laserImage = new ImageIcon("laser.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        laserImage.paintIcon(panel, paper, x, y);
    }

    public void move() {
        y = y - stepSize;
    }
}
