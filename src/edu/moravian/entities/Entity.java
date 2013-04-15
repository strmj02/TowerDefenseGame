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
    
    Point2D location;
    BufferedImage image;
    double radius;
    
    public abstract void update(double delta);
}
