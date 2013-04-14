/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.awt.Color;

/**
 * This class represents a basic ball, which a center point, a movement vector, 
 * a mass, color and radius and has getter methods.  It also allows you to perform 
 * Collision response on this ball and the ball it collided with.
 * @author Rachel
 */
public class Ball {
    private double radius;
    private Point2D point;
    private Vector2D moveVec;
    private double mass;
    private Color color;
    
    /**
     * Instantiates a ball with all the parameters that you pass in.  The mass is 
     * always half the radius, so that larger balls have larger masses.
     * @param color
     * @param moveVec
     * @param p
     * @param radius
     */
    public Ball(Color color, Vector2D moveVec, Point2D p, double radius){
        point = p;
        this.radius = radius;
        this.moveVec = moveVec;
        this.mass = radius/2;
        this.color = color;
    }

    /**
     * Getter for the movement vector.
     * @return the Vector2D, or movement vector of the ball
     */
    public Vector2D getMoveVec() {
        return moveVec;
    }

    /**
     * Getter for the color of the ball so each ball can be draw differently.
     * @return
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Calculates and updates the new movement vectors after two balls collide based on their
     * previous velocities and masses, as well as epsilon.
     * This is called collision response.  Look inside the method for a more detailed
     * description.
     * @param other The ball that it has collided with.
     * @param epsilon A value from 0-1.  Values close to 0 result in objects that collide 
     * and stick together, or have less of an outgoing velocity than values closer to 1.
     */
    public void collisionResponse(Ball other, double epsilon){       
        //in the collision detection, we moved the balls so that they were just 
        //touching and did not overlap.
        
        /*
         * First we calculate the collision normal, or the normalized vector between
         * the two ball's points.  This gives us the direction of this ball to the other
         * ball.  We also calculate the relative velocity, which is the velocity of one 
         * ball plus the inverse of the other.  We then take the dot product of the two
         * for the purpose of getting the angle between the two vectors.
         */
        
        Vector2D collisionNormal = other.getPoint().minus(point);
        Vector2D relativeVelocity = moveVec.minus(other.getVec());
        collisionNormal.normalize();
        
        double vDotN = relativeVelocity.dot(collisionNormal);
        
        if(vDotN < 0){
        }
        else{
            double numerator = -(1.0 + epsilon) * vDotN;
            double denominator = collisionNormal.dot(collisionNormal) * (1.0/mass + 1.0/other.getMass());
            double j = numerator/denominator;
            
            moveVec.plusEquals(collisionNormal.times(j/mass));
            other.setVec(other.getVec().minus(collisionNormal.times(j/other.getMass())));
        }
    }
    
    /**
     * 
     * @return the center point
     */
    public Point2D getPoint(){
        return point;
    }
    
    /**
     *
     * @return the radius of the ball
     */
    public double getRadius(){
        return radius;
    }
    
    /**
     *
     * @return the movement vector
     */
    public Vector2D getVec(){
        return moveVec;
    }
    
    /**
     * sets the movement vector to the parameter vec
     * @param vec
     */
    public void setVec(Vector2D vec){
        moveVec = vec;
    }
    
    /**
     * Adds the result of multiplying the parameter by the movement vector
     * @param mul
     */
    public void times(double mul){
        point.plusEquals(moveVec.times(mul));
    }
    
    /**
     * Updates a ball, or moves it according to its movement vector
     */
    public void update(){
        point.plusEquals(moveVec);
    }
    
    /**
     *
     * @return the mass of the ball
     */
    public double getMass(){
        return mass;
    }
}
