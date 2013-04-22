/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.Path;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author samson
 */
public class Creep extends MovingEntity{
    
    private int lifespan;
    private Path path;
    private Point2D currentlyFollowing;
    
    
    public Creep(Path path, int lifespan, Vector2D vec, double radius, BufferedImage i){
        this.path = path;
        this.lifespan = lifespan;
        currentlyFollowing = path.getNext();
        velocity = vec;
        location = path.get(0);
        this.radius = radius;
        image = i;
        
        //this.image = ImageIO.read(url);
    }
    
    public void update(double delta){
        if(this.atPoint()){
            currentlyFollowing = path.getNext();
            //System.out.println("atPoint" + currentlyFollowing.getY());
        }
        velocity = currentlyFollowing.minus(location);
        velocity.normalize();
        ///normalize work???///
        location.scalePlusEquals(delta * 50, velocity);
        offScreen();
        
    }
    
    private boolean atPoint(){
        if(Math.abs(location.getX() - currentlyFollowing.getX()) < 1 && 
                Math.abs(location.getY() - currentlyFollowing.getY()) < 1){
            return true;
        }
        return false;
    }
    
    public void offScreen(){
        if(location.getX() + radius  > 800){
            isAlive = false;
            lifespan = 0;
        }
        if(location.getY() + radius > 600){
            isAlive = false;
            lifespan = 0;
        }       
    }
    
    
    public void loseLife(){
        lifespan--;
        if(lifespan <=0){
            isAlive = false;
        }
    }
    
}
