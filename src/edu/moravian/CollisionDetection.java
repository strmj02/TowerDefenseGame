/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Vector2D;

/**
 * This class encapsulates the behaviors of collision detection, and can detect
 * and handle collision of perfectly round objects.  It will move them apart so they
 * do not penetrate but do collide at a certain point.
 * @author Rachel
 */
public class CollisionDetection {
    private double worldMinX;
    private double worldMaxX;
    private double worldMinY; 
    private double worldMaxY;
    
    
    
    /**
     * You only need the world dimensions so that you can detect if the object is 
     * colliding with the wall.
     * @param worldMinX
     * @param worldMaxX
     * @param worldMinY
     * @param worldMaxY
     */
    public CollisionDetection(double worldMinX, double worldMaxX, double worldMinY, 
            double worldMaxY){
        this.worldMaxX = worldMaxX;
        this.worldMaxY = worldMaxY;
        this.worldMinX = worldMinX;
        this.worldMinY = worldMinY;
    }

    /**
     * Here is the collision logic between two balls.  It contains a series of escapes
     * that tell you a ball is not colliding with another, unless it passes all the escapes,
     * then it moves the balls so that they are just touching.
     * @param ball
     * @param other
     * @return true if colliding
     */
    public boolean isCollision(Ball ball, Ball other){
        //we get the vector between the two balls, so the vector from the center 
        //of the other to ball.  We will be needing this for our other calculations.
        //This is how we normalize the movement vector of one object, by subtracting it from
        //the other, so that we can do stationary collision response when both objects are moving.

        Vector2D vec= ball.getVec().minus(other.getVec());
        //System.out.println(vec + " vec");
        
        
        //check that the movement vector will actually be close enough for a collision
        //take the vector from the center of ball to the point of other to find out how far 
        //the vector needs to reach for a collision.  Then you calculate the sumRaddi, which is 
        //the sum of both of the ball's Radii.  To calculate the distance a ball needs to travel
        //to collide with another object, you subtract the magnitude of the vector between the two
        //by the sum of the radii.  
        Vector2D vecDist = other.getPoint().minus(ball.getPoint());
       //System.out.println(vecDist + " VecDist");
        
        double sumRadii = ball.getRadius() + other.getRadius();
        //System.out.println(sumRadii);
        //System.out.println(vecDist.magnitude());
        double distance = vecDist.magnitude() - sumRadii;
        //System.out.println(distance + " distance");
        
       
        //if the movement vector is less than the distance between to a collision,
        //a collision is not possible, so we can escape from the collision test
        //System.out.println(vec.magnitudeSq());
        if(vec.magnitude() < distance ){
            return false;
        }
        
       
        //we normalize our movement vector and take the dot product of it and the 
        //vector connecting the center of both objects.  The dot product will reveal to us 
        //a negative or positive number. If it is less than or equal to 0, then we know
        //that it is moving in the opposite direction and no collision happens
        Vector2D moveVecNorm = vec.getNormalized();
        //System.out.println(moveVecNorm + "MoveVecNorm");
        double moveVecDot = moveVecNorm.dot(vecDist);
        //System.out.println(moveVecDot + "moveDOt");
                
        //here we check if they are traveling in the same direction;
        if(moveVecDot <= 0){
            return false;
        }
        
        
        //here we check for the difference between the the vector from ball to other  and
        //the actual movement vector, both squared.  
        double length = vecDist.magnitudeSq() - (moveVecDot * moveVecDot);
        double sumRadiiSq = sumRadii * sumRadii;
        if(length >= sumRadiiSq){
            return false;
        }
        
        //there is no triangle that can have a size of less than 0
 
        double T = sumRadiiSq - length;
        if(T < 0){
            return false;
        }
        
        double separationDist = moveVecDot - Math.sqrt(T);
        
        if(vec.magnitude() < separationDist){
            return false;
        }
        
        Vector2D temp = vec.getNormalized();
        temp.timesEquals(separationDist);
        separationDist = temp.magnitude()/vec.magnitude();
                
        ball.times(separationDist);
        other.times(separationDist);
        return true;
        
    }
    
    /**
     *
     * @param ball
     */
    public void isCollidingWall(Ball ball){
        if(ball.getPoint().getX() + ball.getRadius() > worldMaxX){
            Vector2D newtemp = ball.getVec();
            newtemp.set(-newtemp.getX(), newtemp.getY());
            ball.setVec(newtemp);   
        }
        if(ball.getPoint().getX() - ball.getRadius() < worldMinX){
            Vector2D newtemp = ball.getVec();
            newtemp.set(-newtemp.getX(), newtemp.getY());
            ball.setVec(newtemp);  
        }
        if(ball.getPoint().getY() + ball.getRadius() > worldMaxY){
            Vector2D newtemp = ball.getVec();
            newtemp.set(newtemp.getX(), -newtemp.getY());
            ball.setVec(newtemp); 
        }
        if(ball.getPoint().getY() - ball.getRadius() < worldMinY){
            Vector2D newtemp = ball.getVec();
            newtemp.set(newtemp.getX(), -newtemp.getY());
            ball.setVec(newtemp);
        }
            
            
    }
}