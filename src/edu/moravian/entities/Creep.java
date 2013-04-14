/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.Path;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;

/**
 *
 * @author samson
 */
public class Creep extends MovingEntity{
    
    private int lifespan;
    private Path path;
    private Point2D currentlyFollowing;
    
    public Creep(Path path, int lifespan, Vector2D vec){
        this.path = path;
        this.lifespan = lifespan;
        currentlyFollowing = path.get(0);
        velocity = vec;
    }
    
    public void update(double delta){
        
    }
}
