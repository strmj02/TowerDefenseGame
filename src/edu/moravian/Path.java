/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import java.util.ArrayList;

/**
 *
 * @author samson
 */
public class Path {
    //an arraylist of all the points to which a creep will seek to in succession
    ArrayList<Point2D> path;
    
    //we pass it an already created arraylist--not sure about this.  can we combine 
    //this with a reader that allows us to read in points from a file and create them?
    public Path(ArrayList<Point2D> createdPath){
        this.path = createdPath;
    }
    
    public int getPathSize(){
        return path.size();
    }
    
    public Point2D get(int i){
        return path.get(i);
    }
}
