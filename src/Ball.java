import java.awt.*;
import java.util.Random;

public class Ball {
    private double xVel,yVel,x,y;
    final double DOWN_GRAVITY = 1.03,UP_GRAVITY = 1./1.0291;
    private boolean goingDown = true;
    public Ball() {
        this.x = 560;
        this.y = 40;
        xVel= -2;
        yVel=0.3;
    }


    public void move(){
        x+=xVel;
        if(goingDown) {
            yVel *= DOWN_GRAVITY;
            y += yVel;
        }
        else {
            yVel *= UP_GRAVITY;
            y -= yVel;
        }
        if(x <= 0){
            xVel = 2;
        }
        if(x >= 1120){
            xVel = -2;
        }

        if(yVel <= 0.3 ) goingDown = true;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval((int) x, (int) y,80,80);
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

    public void setGoingDown(boolean goingDown) {
        this.goingDown = goingDown;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }
}
