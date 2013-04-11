package edu.moravian;

import edu.moravian.math.CoordinateTranslator;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;

/**
 * This game has a computer try to follow you and catch you.  You move with the 
 * mouse and have 5 lives.
 * 
 * @author Rachel
 */
//We initialize all the variables we will need
class BouncingBalls implements Game{
    private int worldWidth;
    private int worldHeight;
    private CoordinateTranslator coordinatetrans;
    private CollisionDetection collision;
    private BallManager manager;
    private BallsCreater ballcreate;
    private IniReader iniReader;
    /**
     * Create the game
     * b+
     * @param worldWidth the width of the world
     * @param worldHeight the height of the world
     */
    public BouncingBalls(int worldWidth, int worldHeight)
    {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        coordinatetrans = new CoordinateTranslator(worldWidth, worldHeight, 800, 600, new Point2D(0, 0));
        collision = new CollisionDetection(0, 800, 0, 600);
        manager = new BallManager(collision);
        iniReader = new IniReader(new File("C:/Users/Rachel/Documents/NetBeansProjects/BouncingBalls/src/edu/moravian/gp.ini"));
        ballcreate = new BallsCreater((int)iniReader.getNumBalls(), iniReader.getMinSize(),
                iniReader.getMaxSize(), iniReader.getEpsilon(), iniReader.getMinSpeed(),
                iniReader.getMaxSpeed());
        for(Ball ball : ballcreate.getArray()){
            manager.add(ball);
        }
        
        //Ball one = new Ball(Color.GREEN, new Vector2D(-1, 0),new Point2D(100, 200), 20);
        //Ball two = new Ball(Color.RED, new Vector2D(1, 1),new Point2D(0, 100), 20);
        //manager.add(two);
        //manager.add(one);
        //one = new Ball(Color.BLACK, new Vector2D(-2, 2), new Point2D(37, 87),30);
        //two = new Ball(Color.blue, new Vector2D(6, 1),new Point2D(72, 122), 25);
        //manager.add(two);
        //manager.add(one);
    }

    
    /**
     * Update the game to the next frame
     */
    public synchronized void update(double delta)
    {
        manager.update();
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

    //return the point so that we can set mouse listener's location to it
   

    

}
