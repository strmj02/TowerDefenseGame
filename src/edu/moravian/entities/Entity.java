/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.math.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author samson
 */
public abstract class Entity {
    
    protected Point2D location;
    protected BufferedImage image;
    protected double radius;
    
    public abstract void update(double delta);
    
    public Point2D getLocation(){
        return location;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public BufferedImage getImage(){
        return image;
    }
}
