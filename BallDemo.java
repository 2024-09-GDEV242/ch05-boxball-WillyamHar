import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author William Harvey
 * @version 2024.10.18
 */

public class BallDemo   
{
    private Canvas myCanvas;
        private class RandomArray
        {
            
        }
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    public void boxBounce(){myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 400, 550, 400);

        // draw the top
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 100, 550, 100);
        
        // draw the left wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 100, 50, 400);
        
        // draw the right wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(550, 100, 550, 400);
        
        // draw the ball
        BoxBall b1 = new BoxBall(150, 200, 30, Color.RED, 400, 50, 550, 100, myCanvas);
        b1.draw();
        while (true){
            drawBox();
            myCanvas.wait(50);
            b1.move();
        }
    }
    private void drawBox()
    {
        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 400, 550, 400);

        // draw the top
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 100, 550, 100);
        
        // draw the left wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, 100, 50, 400);
        
        // draw the right wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(550, 100, 550, 400);
    }
}
