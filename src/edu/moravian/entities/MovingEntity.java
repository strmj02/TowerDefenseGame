/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

/**
 *
 * @author samson
 */
public abstract class MovingEntity implements Entity {
     Vector2D velocity;
     int radius;
     Point2D position;
  
     public void update(){
         position.scalePlusEquals(velocity, delta);
     }
     public Vector2D getVelocity(){
         return velocity;
     }
}
