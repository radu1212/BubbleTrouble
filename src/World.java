import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class World extends Applet implements Runnable, KeyListener {

    final int WIDTH = 1200, HEIGHT = 700;
    boolean play = true;
    boolean shotFired = false,firstBulletCreated = false;
    Graphics gfx;
    Image img;
    Thread thread;
    Bullet bullet;
    Ball ball;
    HumanPlayer humanPlayer;

    public void init() {
        this.resize(WIDTH, HEIGHT);

        this.addKeyListener(this);

        humanPlayer = new HumanPlayer(1);
        ball = new Ball();
        bullet = new Bullet();

        img = createImage(WIDTH,HEIGHT);
        gfx = img.getGraphics();

        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.GRAY);
        gfx.fillRect(0,0,WIDTH,HEIGHT);
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0,660,1200,40);
        humanPlayer.draw(gfx);
        bullet.draw(gfx);
        ball.draw(gfx);
        g.drawImage(img,0,0,this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        while(play){

            humanPlayer.move();
            ball.move();



            if(ball.getY() >= 540 && ball.getY() <= 550){

                if((ball.getX()-humanPlayer.getX() <= 5 && ball.getX()-humanPlayer.getX() >= 0) || (-ball.getX()+humanPlayer.getX() <= 5 && -ball.getX()+humanPlayer.getX() >= 0)){
                    System.out.println("Game Over");
                    play = false;
                    //stop();
                }
            }

            if(ball.getY() >= 550 && ball.getY() <= 560){

                if((ball.getX()-humanPlayer.getX() <= 10 && ball.getX()-humanPlayer.getX() >= 0) || (-ball.getX()+humanPlayer.getX() <= 10 && -ball.getX()+humanPlayer.getX() >= 0)){
                    System.out.println("Game Over");
                    play = false;
                    //stop();
                }
            }

            if(ball.getY() >= 560 && ball.getY() <= 570){

                if((ball.getX()-humanPlayer.getX() <= 15 && ball.getX()-humanPlayer.getX() >= 0) || (-ball.getX()+humanPlayer.getX() <= 15 && -ball.getX()+humanPlayer.getX() >= 0)){
                    System.out.println("Game Over");
                    play = false;
                    //stop();
                }
            }

            if(ball.getY() >= 570 && ball.getY() <= 580){

                if((ball.getX()-humanPlayer.getX() <= 25 && ball.getX()-humanPlayer.getX() >= 0) || (-ball.getX()+humanPlayer.getX() <= 25 && -ball.getX()+humanPlayer.getX() >= 0)){
                    System.out.println("Game Over");
                    play = false;
                    //stop();
                }
            }

            if(ball.getY()>=580) {
                ball.setGoingDown(false);
            }

            if(shotFired) {
                if(!firstBulletCreated) {
                    bullet = new Bullet(humanPlayer.getX(), humanPlayer.getY());
                    firstBulletCreated = true;
                }
                bullet.draw(gfx);
                bullet.move();
                if (bullet.getY() < 0) {shotFired = false; firstBulletCreated = false;}
            }

            repaint();

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            humanPlayer.setLeftAccel(true);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            humanPlayer.setRightAccel(true);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            shotFired = true;
        }else{

        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            humanPlayer.setLeftAccel(false);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            humanPlayer.setRightAccel(false);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            //bullet = new Bullet(humanPlayer.getX(),humanPlayer.getY());

        }else{

        }
    }
}