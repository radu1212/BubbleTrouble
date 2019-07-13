import java.awt.*;

public class Bullet {
    private double xVel,yVel,x,y;

    public Bullet() {
    }

    public Bullet(double x, double y) {
        this.x = x;
        this.y = y;
        xVel=0;
        yVel=-4;
    }

    public void move(){
        x+=xVel;
        y+=yVel;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval((int)x+17, (int)y-20,5,15);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}
