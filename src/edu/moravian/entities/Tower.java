

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author samson
 */
public class Tower extends Entity{
    double bulletRadius;
    double firingTime;
    double timepast;
    
    public Tower(BufferedImage img, double radius, double bulletRadius, Point2D location){
        this.image = img;
        this.location = location;
        this.radius = radius;
        this.bulletRadius = bulletRadius;
    }

    @Override
    public void update(double delta) {
        if (timepast > delta){
            //if the radius < distance to a creep, fire at that creep.
        }
    }
    
    public void update(double delta, ArrayList<Creep> list){
        if (timepast > delta){
        boolean creepFound = false;
        while(creepFound){
        for(Creep k : list){
            Vector2D toCreep = location.minus(k.getLocation());
            if (toCreep.magnitude() < radius){
                fireBullet(k);
                creepFound = true;
            }
            
        }
    }
    }
    }
    
    public Bullet fireBullet(Creep k){
        Vector2D dir = k.getLocation().minus(location);
        return new Bullet(k, location, radius, null, bulletRadius, dir);
    }
}
