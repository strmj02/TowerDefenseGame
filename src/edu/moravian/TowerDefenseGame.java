/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author samson
 */
public class TowerDefenseGame implements Game {
    private int worldWidth;
    private int worldHeight;
            
    
    public TowerDefenseGame(int worldWidth, int worldHeight){
        
    }
    
    
    
        public synchronized void update(double delta)
    {
        
      }
    

    /**
     * Draw the current game state
     * @param g2d the graphics to draw to
     */
    public synchronized void draw(Graphics2D g2d)
    { 
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, worldWidth, worldHeight);
        
        for(int i = 0; i< manager.getBalls().size(); i++){
            Ball temp = manager.getBalls().get(i);
            g2d.setColor(temp.getColor());
            Point p = coordinatetrans.worldToScreen(temp.getPoint());
            g2d.fillOval(p.x-((int)(temp.getRadius())), p.y- ((int)(temp.getRadius())), 
                    (int)(temp.getRadius()) * 2, (int)(temp.getRadius()) * 2);
        }

    }

    /**
     * Determine whether the game is done.  For our game, once our lives 
     * reach 0, its game over.
     */
    public boolean done()
    {
        return false;
    }
}
