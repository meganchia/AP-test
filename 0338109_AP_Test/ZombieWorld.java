//Megan Alyssa Chia
//0338109
//ITS66704
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ZombieWorld extends JFrame implements ActionListener {

    private final int SWIDTH = 900;
    private final int SHEIGHT = 700;
    private JButton btnStart, btnExit, btnPause;
    private JButton btnLeft, btnRight, btnUp, btnDown;
    private JLabel borderLabel, backgroundLabel;
    private JLayeredPane layers;
    private GameCanvas gameC = new GameCanvas();

    public ZombieWorld() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Zombie World v1.0");
        setSize(SWIDTH, SHEIGHT);
        setLayout(null);
    }

    public void init() {
        //border image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./data/bg1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image bImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(bImage);
        borderLabel = new JLabel();
        borderLabel.setIcon(imageIcon);
        setContentPane(borderLabel);

        gameC.setBounds(25, 25, 600, 630);
        gameC.setBackground(Color.LIGHT_GRAY);
        add(gameC);

        btnLeft = new JButton("LEFT");
        btnLeft.setBounds(645, 380, 100, 40);
        btnLeft.addActionListener(this);
        add(btnLeft);
        btnRight = new JButton("RIGHT");
        btnRight.setBounds(755, 380, 100, 40);
        btnRight.addActionListener(this);
        add(btnRight);
        btnUp = new JButton("UP");
        btnUp.setBounds(700, 330, 100, 40);
        btnUp.addActionListener(this);
        add(btnUp);
        btnDown = new JButton("DOWN");
        btnDown.setBounds(700, 430, 100, 40);
        btnDown.addActionListener(this);
        add(btnDown);
        btnStart = new JButton("START");
        btnStart.setBounds(650, 550, 120, 25);
        btnStart.addActionListener(this);
        add(btnStart);
        btnExit = new JButton("EXIT");
        btnExit.setBounds(650, 600, 120, 25);
        btnExit.addActionListener(this);
        add(btnExit);
        btnPause = new JButton("PAUSE");
        btnPause.setBounds(700, 200, 100, 25);
        btnPause.addActionListener(this);
        add(btnPause);

        //set button hover effect
        btnHover(btnPause);
        btnHover(btnExit);
        btnHover(btnStart);
        btnHover(btnLeft);
        btnHover(btnRight);
        btnHover(btnUp);
        btnHover(btnDown);

        //set button fonts
        Font gostone = gameC.setTextFont(20);
        btnLeft.setFont(gostone);
        btnRight.setFont(gostone);
        btnUp.setFont(gostone);
        btnDown.setFont(gostone);
        btnPause.setFont(gostone);
        btnExit.setFont(gostone);
        btnStart.setFont(gostone);
        setVisible(true);

        //opening audio
        File soundFile = new File("./data/megan.wav").getAbsoluteFile();

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip myClip = AudioSystem.getClip();
            myClip.open(ais);
            myClip.start();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnStart) {
            if (gameC.getGameStatus() == 0) {
                gameC.startTimer();
                btnStart.setText("RESTART");
            }
            if (gameC.getGameStatus() == 2) {
                gameC.setGameStatus(0);
                gameC.restart();
                btnStart.setText("START");
            }
        } else if (e.getSource() == btnLeft) {
            gameC.moveLeft();
        } else if (e.getSource() == btnUp) {
            gameC.moveUp();
        } else if (e.getSource() == btnRight) {
            gameC.moveRight();
        } else if (e.getSource() == btnDown) {
            gameC.moveDown();
        } else if (e.getSource() == btnPause) {
            if (gameC.getGameStatus() == 1) {
                gameC.pauseTimer();
                btnPause.setText("RESUME");
            }
            else {
                gameC.setGameStatus(1);
                btnPause.setText("PAUSE");
            }
        }
    }

    public void btnHover(JButton b) {
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(Color.DARK_GRAY);
                b.setForeground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                b.setBackground(null);
                b.setForeground(Color.BLACK);
            }
        });
    }

    public static void main(String args[]) {
        ZombieWorld zw = new ZombieWorld();
        zw.init();
    }
}
