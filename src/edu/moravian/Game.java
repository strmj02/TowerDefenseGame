/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import java.awt.Graphics2D;

/**
 *
 * @author samson
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
    
    void mouseClick(Point2D p);
    
    void mouseDragged(Point2D p);
    
    void keyPressed(char c);
}
