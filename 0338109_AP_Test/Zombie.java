import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Zombie extends Human {

    private Random rdm = new Random();

    public Zombie(int sx, int sy, int sp) {
        super(sx, sy, sp);
    }

    public void hunting(Megan m) {
        int zx = super.getX();
        int zy = super.getY();
        int mx = m.getX();
        int my = m.getY();

        int dir = rdm.nextInt(6);
        if (dir == 0) {
            moveLeft();
        } else if (dir == 1) {
            moveRight();
        } else if (dir == 2) {
            moveUp();
        } else if (dir == 3) {
            moveDown();
        }
        else if (dir == 4) {
            if (zx < mx) {
                super.moveRight();
            }
            else {
                super.moveLeft();
            }
        }
        else if (dir == 5) {
            if (zy < my) {
                super.moveDown();
            }
            else {
                super.moveUp();
            }
        }
    }

    public void handleBorderCollision() {
        int x = super.getX();
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            super.reverseDirection();
        }
        updatePosition();
    }

    public void drawZombie(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int x1 = x;
        int y1 = y;
        int x2 = x + 12;
        int y2 = y;
        int x3 = x + 18;
        int y3 = y;
        int x4 = x + 30;
        int y4 = y + 12;
        int x5 = x + 30;
        int y5 = y + 18;
        int x6 = x + 18;
        int y6 = y + 30;
        int x7 = x + 12;
        int y7 = y + 30;
        int x8 = x;
        int y8 = y + 18;
        int x9 = x;
        int y9 = y + 12;
        int xpts[] = {x2, x3, x4, x5, x6, x7, x8, x9};
        int ypts[] = {y2,y3, y4, y5, y6, y7, y8, y9};

        g.setColor(Color.ORANGE);
        g.fillPolygon(xpts, ypts, 8);
    }
}
