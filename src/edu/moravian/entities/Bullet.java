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
   
    
   public Bullet(Creep c, Point2D loc, double radius, BufferedImage img, double territory){
       this.creep = c;
       location = loc;
       velocity = c.getLocation().minus(location);
       this.radius = radius;
       image = img;
   }
   
   
    
}
