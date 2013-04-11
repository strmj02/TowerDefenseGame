/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.math;

import java.awt.Point;
import java.math.BigDecimal;

/**
 *
 * @author Rachel
 */
public class Point2D {
    
    public static final double TOL = 1.0 * Math.pow(10, -8);
    private double x;
    private double y;
    
    //construct a point at the origin
    public Point2D(){
        x = 0;
        y = 0;           
    }
    //construct a point with specific x and y coordinates
    public Point2D(double x, double y){
        if(Math.abs(x)< TOL){
            x = 0;
        }
        else{
            this.x = x;
        }
        if(Math.abs(y)< TOL){
            y = 0;
        }
        else{
            this.y = y;
        }
    }
    //make a point the same as the point in the parameter
    public Point2D(edu.moravian.math.Point2D point){
        x = point.getX();
        y = point.getY();
    }
    
    //check if two points are equal to each other
    @Override
    public boolean equals(Object obj){
        if(obj instanceof edu.moravian.math.Point2D){
            edu.moravian.math.Point2D temp = (edu.moravian.math.Point2D)obj;
            BigDecimal x1 = BigDecimal.valueOf(x);
            BigDecimal x2 = BigDecimal.valueOf(temp.getX());
            BigDecimal y1 = BigDecimal.valueOf(y);
            BigDecimal y2 = BigDecimal.valueOf(temp.getY());
            BigDecimal tempX = x1.subtract(x2);
            BigDecimal tempY = y1.subtract(y2);
            if(Math.abs(tempX.doubleValue()) < TOL){
                if(Math.abs(tempY.doubleValue()) < TOL){
                    return true;
                }
            }
        }
            return false;
        }
    //retrieve the x component of a point
    public double getX(){
        return x;
    }
    //retrieve the y component of a point
    public double getY(){
        return y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }
    //subtract the point by the point in the parameter, and return the resulting vector without modifying
    //either the point you pass in or the point you started with
    public Vector2D minus(edu.moravian.math.Point2D point){
        BigDecimal x1 = BigDecimal.valueOf(x);
        BigDecimal x2 = BigDecimal.valueOf(point.getX());
        BigDecimal y1 = BigDecimal.valueOf(y);
        BigDecimal y2 = BigDecimal.valueOf(point.getY());
        BigDecimal tempX = x1.subtract(x2);
        BigDecimal tempY = y1.subtract(y2);
        return (new Vector2D(tempX.doubleValue(), tempY.doubleValue()));
    }
    //mod the x and y components by xMax, yMax, and set the x, y values equal to this
    //mutate the actual point, so it never has x, y values above xMax, yMax
    public void modEquals(double xMax, double yMax){
        if(x < 0){
            x = Math.abs(x) % xMax;
            x = xMax - x;
        }
        else{
        x = Math.abs(x) % xMax;
        }
        if(y < 0){
            y = Math.abs(y) % yMax;
            y = yMax-y;
        }
        else{
        y = Math.abs(y) % yMax;
        }
        if(x < TOL){
            x = 0;
        }
        if(y < TOL){
            y = 0;
        }
    }
    //add a vector to this point and return the resulting point by adding both x components and both y
    public edu.moravian.math.Point2D plus(Vector2D rhs){
        return (new edu.moravian.math.Point2D(x + rhs.getX(), y + rhs.getY()));
    }
    //same as above method, but this mutates the actual point and does not return anything
    public void plusEquals(Vector2D rhs){
        x = x + rhs.getX();
        y = y + rhs.getY();
    }
    //creates a randomPoint with an x component between xMin-xMax and y component between yMin-yMax
    public static edu.moravian.math.Point2D randomPoint(double xMin, double xMax, double yMin, double yMax){
       double tempX = Math.random() * (xMax - xMin) + xMin;
       double tempY = Math.random() * (yMax - yMin) + yMin;  
       return new edu.moravian.math.Point2D(tempX, tempY);
    }
    //returns a new point that is the addition of the old x, y coordinates by the vector's components * scalar
    public edu.moravian.math.Point2D scalePlus(double scalar, Vector2D v){
       return (new edu.moravian.math.Point2D(x + (v.getX() * scalar), y + (v.getY() * scalar)));
    
    }
    //same as above method but actually mutates the current point
    public void scalePlusEquals(double scalar, Vector2D v){
       x = x + (v.getX() * scalar);
       y = y + (v.getY() * scalar);
    }
    //set current point to have the same coordinates as the point in the parameter 
    public void set(edu.moravian.math.Point2D p){
        x = p.getX();
        y = p.getY();
    }
    //just set the x coordinate to the double passed as the paramenter
    public void setX(double xx){
        x = xx;
    }
    //set the y coordinate to the double passed as the paramenter
    public void setY(double yy){
        y = yy;
    }
    //return the point in a formated String
    @Override
    public String toString(){
        //return ("(" + x + ", " + y + 
         return String.format("(%s, %s)", x, y);
    }
    
    public Point toPoint(){
        return(new Point((int)x, (int)y));
    }
}

