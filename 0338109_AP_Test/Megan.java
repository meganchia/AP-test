import java.awt.Graphics;
import java.awt.Color;

public class Megan extends Human {

    public Megan(int sx, int sy, int sp) {
        super(sx, sy, sp);
    }

    public void drawPlayer(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int dir = super.getDir();
        int[] xpts = new int[0];
        int[] ypts = new int[0];

        if (dir == 0) {
            int x1 = x + 6;
            int y1 = y;
            int x2 = x + 12;
            int y2 = y;
            int x3 = x + 12;
            int y3 = y + 12;
            int x4 = x + 18;
            int y4 = y + 12;
            int x5 = x + 18;
            int y5 = y;
            int x6 = x + 24;
            int y6 = y;
            int x7 = x + 24;
            int y7 = y + 12;
            int x8 = x + 30;
            int y8 = y + 12;
            int x9 = x + 30;
            int y9 = y + 30;
            int x10 = x;
            int y10 = y + 30;
            int x11 = x;
            int y11 = y + 12;
            int x12 = x + 6;
            int y12 = y + 12;
            xpts = new int[]{x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12};
            ypts = new int[]{y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12};
        }

        else {
            int x1 = x;
            int y1 = y;
            int x2 = x + 30;
            int y2 = y;
            int x3 = x + 30;
            int y3 = y + 18;
            int x4 = x + 24;
            int y4 = y + 18;
            int x5 = x + 24;
            int y5 = y + 30;
            int x6 = x + 18;
            int y6 = y + 30;
            int x7 = x + 18;
            int y7 = y + 18;
            int x8 = x + 12;
            int y8 = y + 18;
            int x9 = x + 12;
            int y9 = y + 30;
            int x10 = x + 6;
            int y10 = y + 30;
            int x11 = x + 6;
            int y11 = y + 18;
            int x12 = x;
            int y12 = y + 18;
            xpts = new int[]{x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12};
            ypts = new int[]{y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12};
        }

        g.setColor(Color.BLUE);
        g.fillPolygon(xpts, ypts, 12);
    }

    public boolean collideWithBorder() {
        int x = super.getX();
        int y = super.getY();
        boolean collide = false;
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            collide = true;
        }
        return collide;
    }

    public boolean collideWithZombie(Zombie z) {
        boolean collide = false;
        int mx = super.getX();
        int my = super.getY();
        int zx = z.getX();
        int zy = z.getY();
        int sz = 30;
        if ((zx >= (mx-sz)) & (zx <= (mx+sz)) & (zy >= (my-sz)) & (zy <= (my+sz)))
            collide = true;
        return collide;
    }
}
