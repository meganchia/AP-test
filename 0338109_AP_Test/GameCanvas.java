
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class GameCanvas extends Canvas implements ActionListener, KeyListener {

    private Timer aTimer;
    private int gameStatus = 0;
    private Megan megan;
    private Zombie zombie1, zombie2, zombie3;
    private int score = 0;

    public GameCanvas() {
        aTimer = new Timer(25, this);
        restart();
        addKeyListener(this);
    }

    public void restart() {
        megan = new Megan(300, 500, 5);
        zombie1 = new Zombie(200, 200, 10);
        zombie2 = new Zombie(300, 200, 10);
        zombie3 = new Zombie(400, 200, 10);
        score = 0;
    }

    public void startTimer() {
        if (gameStatus == 0) {
            gameStatus = 1;
            aTimer.start();
        }
    }

    public void pauseTimer() {
        gameStatus = 3;
    }

    @Override
    public void paint(Graphics g) {
        if (megan.collideWithBorder()) {
            gameStatus = 2;
        }
        if (megan.collideWithZombie(zombie1)) {
            gameStatus = 2;
        }
        if (megan.collideWithZombie(zombie2)) {
            gameStatus = 2;
        }
        if (megan.collideWithZombie(zombie3)) {
            gameStatus = 2;
        }
        if (gameStatus == 1) {
            score++;
            zombie1.hunting(megan);
            zombie2.hunting(megan);
            zombie3.hunting(megan);
            zombie1.updatePosition();
            zombie1.handleBorderCollision();
            zombie2.updatePosition();
            zombie2.handleBorderCollision();
            zombie3.updatePosition();
            zombie3.handleBorderCollision();
            megan.updatePosition();
            megan.collideWithZombie(zombie1);
            megan.collideWithZombie(zombie2);
            megan.collideWithZombie(zombie3);
        }

        megan.drawPlayer(g);
        zombie1.drawZombie(g);
        zombie2.drawZombie(g);
        zombie3.drawZombie(g);

        //setting text font
        Font gostone = setTextFont(30);
        g.setFont(gostone);

        if (gameStatus == 0) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 250, 600, 100);

            g.setColor(Color.WHITE);
            g.drawString("PRESS START TO BEGIN..", 190, 310);
        }
        if (gameStatus == 2) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 250, 600, 100);

            g.setColor(Color.WHITE);
            g.drawString("G A M E O V E R", 250, 310);
        }
        if (gameStatus == 3) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 250, 600, 100);

            g.setColor(Color.WHITE);
            g.drawString("PAUSE", 260, 310);
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 600, 600, 30);
        g.setColor(Color.WHITE);
        g.drawString("S C O R E : " + score, 10, 625);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aTimer) {
            repaint(0, 0, 600, 630);
            requestFocus();
        }
    }

    public void moveLeft() {
        megan.moveLeft();
    }

    public void moveRight() {
        megan.moveRight();
    }

    public void moveUp() {
        megan.moveUp();
    }

    public void moveDown() {
        megan.moveDown();
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int status) {
        gameStatus = status;
    }

    public Font setTextFont(int size) {
        Font aFont = null;
        try {
            aFont = Font.createFont(Font.TRUETYPE_FONT, new File("./data/Gostone.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(aFont);
        Font gostone = new Font("Gostone", Font.PLAIN, size);
        return gostone;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            moveLeft();
        } else if (keyCode == 38) {
            moveUp();
        } else if (keyCode == 39) {
            moveRight();
        } else if (keyCode == 40) {
            moveDown();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}