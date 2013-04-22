/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import edu.moravian.readers.PathReader;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author samson
 */
public class Path {
    //an arraylist of all the points to which a creep will seek to in succession
    ArrayList<Point2D> path;
    int next;
    Point2D endpoint;
    
    //we pass it an already created arraylist--not sure about this.  can we combine 
    //this with a reader that allows us to read in points from a file and create them?
    public Path(File file){
        PathReader reader = new PathReader(file);
        path = reader.getPath();
        next = -1;
        endpoint = path.get(path.size()-1);
    }
    
    
    public int getPathSize(){
        return path.size();
    }
    
    public Point2D getNext(){
        if(next+1>= path.size()){
            
        }
        else{
            next++;
        }
        
        return path.get(next);
    }
    
    public Point2D get(int i){
        return path.get(i);
    }
    
    public Point2D getEndpoint(){
        return endpoint;
    }
    
    public void setPath(int i, Point2D p){
        path.set(i, p);
    }
}
