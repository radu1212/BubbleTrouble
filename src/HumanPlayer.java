import java.awt.*;

public class HumanPlayer implements Player {

    private double x,y,xVel,yVel;
    private boolean leftAccel,rightAccel;
    private final double FRICTION = 0.8;
    int player;

    public HumanPlayer(int player) {

        leftAccel = false;
        rightAccel = false;
        y = 620;
        xVel = 0;
        if(player == 1){
            x = 560;
        }
        else{
            x = 610;
        }
    }

    public void setLeftAccel(boolean leftAccel) {
        this.leftAccel = leftAccel;
    }

    public void setRightAccel(boolean rightAccel) {
        this.rightAccel = rightAccel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        int[] xCoords = {(int) (x+15), (int) (x+15), (int) (x+5), (int) (x+5), (int) (x+12), (int) (x+12), (int) (x+17), (int) (x+17),
                (int) (x+23), (int) (x+23), (int) (x+28), (int) (x+28), (int) (x+35), (int) (x+35), (int) (x+25), (int) (x+25)};

        int[] yCoords = {(int) y, (int) (y+10), (int) (y+10), (int) (y+15), (int) (y+15), (int) (y+40), (int) (y+40), (int) (y+30),
                (int) (y+30), (int) (y+40), (int) (y+40), (int) (y+15), (int) (y+15), (int) (y+10), (int) (y+10), (int) y};

        g.fillPolygon(xCoords,yCoords,16);
        //g.fillRect((int)x,(int)y,20,40);
    }

    public void move() {

        if(leftAccel){
            xVel -= 2;
        }else if(rightAccel){
            xVel += 2;
        }else{
            xVel *= FRICTION;
        }

        if(xVel >= 4)
            xVel = 4;
        if(xVel <= -4)
            xVel = -4;

        x += xVel;

        if(x<0) x=0;
        if(x>1160) x = 1160;
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}
