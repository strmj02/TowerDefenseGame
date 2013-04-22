/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author samson
 */
public class Bullet extends MovingEntity{
   Creep creep;
   Point2D originalpos;
   double territory;
   Vector2D direction;
   
    
   public Bullet(Creep c, Point2D loc, double radius, BufferedImage img, double territory, Vector2D dir){
       this.creep = c;
       location = loc;
       velocity = c.getLocation().minus(location);
       this.radius = radius;
       image = img;
       originalpos = loc;
       direction = dir;
   }
   
   @Override
   public void update(double delta){
       Vector2D vec = location.minus(originalpos);
       if(vec.magnitude() > territory){
           isAlive = false;
       }
       else{
           location.scalePlusEquals(delta, direction);
       }
   }
   
   
    
}
