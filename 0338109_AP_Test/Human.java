
public class Human {

    private int x;
    private int dx = 0;
    private int y;
    private int dy = 0;
    private int speed = 0;
    private int dir = 1;

    public Human(int sx, int sy, int sp) {
        x = sx;
        y = sy;
        speed = sp;
    }

    public void updatePosition() {
        x = x + dx;
        y = y + dy;
    }

    public void moveLeft() {
        dx = -speed;
        dy = 0;
    }

    public void moveRight() {
        dx = speed;
        dy = 0;
    }

    public void moveUp() {
        dx = 0;
        dy = -speed;
        dir = 1;
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
        dir = 0;
    }

    public void reverseDirection() {
        dx = -dx;
        dy = -dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() { return dir; }

}