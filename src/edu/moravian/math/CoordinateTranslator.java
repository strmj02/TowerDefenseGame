/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.math;

import edu.moravian.math.Point2D;
import java.awt.Point;

/**
 *
 * @author Rachel
 */
public class CoordinateTranslator {
    int screenHeight;
    int screenWidth;
    double worldWidth;
    double worldHeight;
    Point2D lowerLeft;
    double ratioWidthSTW;
    double ratioHeightSTW;
    double ratioWidthWTS;
    double ratioHeightWTS;
    
    //creates an object to translate between points on a screen and points in a world, allowing us 
    //to think in terms of the world, and not worry about pixels
    public CoordinateTranslator(int screenWidth, int screenHeight, double worldWidth, double worldHeight, Point2D lowerLeft){
        this.lowerLeft = lowerLeft;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.worldHeight = worldHeight;
        this.worldWidth = worldWidth;
        ratioWidthSTW = worldWidth/screenWidth;
        ratioHeightSTW = worldHeight/screenHeight;
        ratioHeightWTS = screenHeight/worldHeight;
        ratioWidthWTS = screenWidth/worldWidth; 
    }
 
    /**
     * 
     * @param p
     * @return 
     */
    public Point2D screenToWorld(Point p){
        double wx = lowerLeft.getX() + (ratioWidthSTW * p.x);
        double wy = worldHeight - (ratioHeightSTW * p.y)+ lowerLeft.getY();
        return(new Point2D(wx, wy));
    }
    //takes a Poitn2D p from the world and translates it into a screen Point
    public Point worldToScreen(Point2D p){
        int sx = (int)(ratioWidthWTS *(p.getX() - lowerLeft.getX()));
        int sy = (int)(screenHeight - (ratioHeightWTS * (p.getY()- lowerLeft.getY())));
        return(new Point(sx, sy));
    }
}
