import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Will Harvey
 *
 * @version 2024.10.21
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int bottomPosition;// y position of bottom
    private final int leftPosition;
    private final int rightPosition;
    private final int topPosition;
    private Canvas canvas;
    private int ySpeed = 5;                // initial downward speed
    private int xSpeed = 3;
    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int bottomPos, int leftPos, int rightPos, int topPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        bottomPosition = bottomPos;
        leftPosition = leftPos;
        rightPosition = rightPos;
        topPosition = topPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the bottomPosition
        if (yPosition >= (bottomPosition - diameter)) 
        {
            yPosition = (int)(bottomPosition - diameter); 
            ySpeed = -ySpeed;
        }
        // check if it has hit the topPosition
        if (yPosition <= (topPosition))
        {
            yPosition = (int)(topPosition);
            ySpeed = -ySpeed;
        }
        // check if it has hit the rightPosition
        if (xPosition >= (rightPosition - diameter))
        {
            xPosition = (int)(rightPosition - diameter);
            xSpeed = -xSpeed;
        }
        // check if it has hit the leftPosition
        if (xPosition <= (leftPosition))
        {
            xPosition = (int)(leftPosition);
            xSpeed = -xSpeed;
        }
    
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
