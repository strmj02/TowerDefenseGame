/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;

/**
 *
 * @author samson
 */
public abstract class MovingEntity extends Entity {
     Vector2D velocity;
  
     public void update(double delta){
         location.scalePlusEquals(delta, velocity); //delta? was having error
     }
     public Vector2D getVelocity(){
         return velocity;
     }
}
