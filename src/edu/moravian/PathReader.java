package edu.moravian;

import edu.moravian.math.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author samson
 */
public class PathReader {
    private ArrayList<Point2D> path;
    private BufferedReader read;
 
            
    
    public PathReader(File file){
        path = new ArrayList<Point2D>();
        String text;
        try{
        read = new BufferedReader(new FileReader(file));
        text = read.readLine();
         while(text !=null){
                if(text.startsWith("#")){
                }
                else{
                    String[] array =text.split(",");
                    Point2D point = new Point2D(Double.valueOf(array[0]), Double.valueOf(array[1]));
                    path.add(point);
                 text = read.readLine();
                }
        }
        }
                catch(IOException e){
                    System.out.println("EXCEPTION");
                }
        }
    
    public ArrayList<Point2D> getPath(){
        return path;
    }
}