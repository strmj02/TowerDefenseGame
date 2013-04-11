package edu.moravian;

import edu.moravian.math.Point2D;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * This interface defines the required elements for any game that uses
 * the VideoController
 * 
 * @author Rachel
 */
public interface Game
{
    /**
     * Update the Game state by one frame
     */
    void update(double delta);

    /**
     * Draw the current state of the game
     *
     * @param g2d the graphics with which to draw
     */
    void draw(Graphics2D g2d);

    /**
     * Determine whether the game is complete (the program should
     * terminate)
     * @return true if the game is complete
     */
    boolean done();
    
}
