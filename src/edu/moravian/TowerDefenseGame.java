/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.entities.Creep;
import edu.moravian.entities.Tower;
import edu.moravian.math.CoordinateTranslator;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import edu.moravian.readers.GameStates;
import edu.moravian.readers.Level;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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
    Map map;
    ArrayList<Level> levels;
    Level currentLevel;
    double deltaTrack;
    private int l;
    CoordinateTranslator coordinatetrans;
    boolean hasTower;
    boolean remove;
    
    public TowerDefenseGame(int worldWidth, int worldHeight, CoordinateTranslator cT){
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        manager = new EntityManager();
        path = new Path(new File("PATH.txt"));
        gameStates = new GameStates(path);
        l = 0;
        currentLevel = gameStates.getLevel(l);
        deltaTrack = 0;
        coordinatetrans = cT;
        hasTower = false;
        remove = false;
        map = new Map(path, worldHeight, worldWidth, new Point2D(0,0));
    }
    
    
    
        public synchronized void update(double delta)
    {
        deltaTrack+=delta;
        if(deltaTrack > currentLevel.getTime() && gameStates.getCreepCount() < currentLevel.getCreeps() ){  
            
            FixPathtoMap fix = new FixPathtoMap(map);
            Path p = new Path(new File("PATH.txt"));
            fix.fix(p);
            manager.addCreep(new Creep(p, 5, new Vector2D(0,0), 10, null));
            int numCreepDeployed = gameStates.getCreepCount() + 1;
            gameStates.setCreepCount(numCreepDeployed);
            deltaTrack = 0;
        }
        manager.update(delta);
        
        manager.cleanUp();
       
        
        if(gameStates.getCreepCount()>=currentLevel.getCreeps() && manager.getCreeps().size()==0 && l < gameStates.numLevels()-1){
            l++;
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
        Point one = coordinatetrans.worldToScreen(new Point2D(700, 500));
        g2d.setColor(Color.RED);
        g2d.fillOval(one.x -20, one.y- 20, 40, 40);
        
       for(int i = 0; i< manager.getCreeps().size(); i++){
              Creep temp = manager.getCreeps().get(i);
              g2d.setColor(Color.BLUE);
              Point p = coordinatetrans.worldToScreen(temp.getLocation());
            g2d.fillOval(p.x-((int)(temp.getRadius())), p.y- ((int)(temp.getRadius())), 
                    (int)(temp.getRadius()) * 2, (int)(temp.getRadius()) * 2);
        }
       for(int i = 0; i< manager.getTowers().size(); i++){
           Tower temp = manager.getTowers().get(i);
           Point p = coordinatetrans.worldToScreen(temp.getLocation());
           g2d.fillOval(p.x, p.y, 
                    40, 40);
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
    
    public void mouseClick(Point2D point){
        if(point.getX() < 750 || point.getX() > 50 && point.getY() < 550 || point.getY() > 50){
            if(remove == true){
                //int i =0;
                for(int i =0; i < manager.getTowers().size(); i++){
                    if(remove == true){
                        Vector2D vec = map.getUpperLeft(point).minus(manager.getTowers().get(i).getLocation());
                        if(vec.magnitude() <  10)
                            {
                            manager.deleteTower(manager.getTowers().get(i));    
                            remove = false;
                        }
                    }
                }
            }
            
            if(hasTower ==false){
              Vector2D temp = point.minus(new Point2D(700, 500));
              temp.magnitude();
              if(temp.magnitude() < 50){
                  hasTower =  true;
              }
        }
            if(hasTower == true){
                if(map.canPlaceHere(point)){
                    try{
                        BufferedImage im = ImageIO.read(getClass().getResource("/GameTower.jpeg"));
                    }
                    catch (IOException e) {
                       }
                    Point2D pMap= map.getUpperLeft(point);
                    Tower t = new Tower(null, 20, 40, pMap);
                    manager.addTower(t);
                    map.add(point);
                    hasTower = false;
                }
            }
        }
        
    }
    
    public void mouseDragged(Point2D point){
    
    }
    
    public void keyPressed(char c){
        if(c == 'r'){
            remove = true;
        }
    }
    
    
}
