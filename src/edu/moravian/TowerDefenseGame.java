/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.entities.Creep;
import edu.moravian.math.CoordinateTranslator;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import edu.moravian.readers.GameStates;
import edu.moravian.readers.Level;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author samson
 */
public class TowerDefenseGame implements Game {
    private int worldWidth;
    private int worldHeight;
    private EntityManager manager;   
    private GameStates gameStates;
    Path path;
    ArrayList<Level> levels;
    Level currentLevel;
    double deltaTrack;
    private int l;
    CoordinateTranslator coordinatetrans;
    
    public TowerDefenseGame(int worldWidth, int worldHeight, CoordinateTranslator cT){
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        manager = new EntityManager();
        path = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
        gameStates = new GameStates(path);
        l = 0;
        currentLevel = gameStates.getLevel(l);
        deltaTrack = 0;
        coordinatetrans = cT;
    }
    
    
    
        public synchronized void update(double delta)
    {
        deltaTrack+=delta;
        if(deltaTrack > currentLevel.getTime() && gameStates.getCreepCount() < currentLevel.getCreeps() ){  
            Path p = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
            manager.addCreep(new Creep(p, 5, new Vector2D(0,0), 10));
            int numCreepDeployed = gameStates.getCreepCount() + 1;
            gameStates.setCreepCount(numCreepDeployed);
            deltaTrack = 0;
        }
        manager.update(delta);
        
        manager.cleanUp();
        
        
        System.out.println("DELTA  " +  delta);
        
        if(gameStates.getCreepCount()>=currentLevel.getCreeps() && manager.getCreeps().size()==0 && l < gameStates.numLevels()-1){
            l++;
            System.out.println("IN THIS");
            currentLevel = gameStates.getLevel(l);
            gameStates.setCreepCount(0);
            deltaTrack = -7;
        }
        
      }
    

    /**
     * Draw the current game state
     * @param g2d the graphics to draw to
     */
    public synchronized void draw(Graphics2D g2d)
    { 
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, worldWidth, worldHeight);
        
       for(int i = 0; i< manager.getCreeps().size(); i++){
              Creep temp = manager.getCreeps().get(i);
              g2d.setColor(Color.BLUE);
              Point p = coordinatetrans.worldToScreen(temp.getLocation());
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
