/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;

/**
 *
 * @author johnson
 */
public class Map {
   private boolean grid[][];
   private Path path;
   private int desiredColumns = 40;
   private int desiredRows = 30;
   private double ySpace;
   private double xSpace;
   private Point2D lowerLeft;
           
   
/**
 * This constructor creates a map, which is a representation of the world in a 2D
 * array, or grid.  The grid is divided into however many equal cells you want it to be. 
 * This should probably have enough space in each cell for our largest graphic.  We can
 * either specify the size of the cell we want, or the amount of cells we want.
 * THIS IMPLEMENTS BY THE AMOUNT OF CELLS.
 * @param path
 * @param worldHeight
 * @param worldWidth
 * @param lowerLeft 
 */
   public Map(Path path, double worldHeight, double worldWidth, Point2D lowerLeft){
       this.path = path;
       this.lowerLeft = lowerLeft;
       //int rows = (int)worldWidth/desiredRows;
       //int columns = (int)worldHeight/desiredColumns;
       grid = new boolean[desiredRows][desiredColumns];
       xSpace = worldHeight/desiredRows;
       ySpace = worldWidth/desiredColumns;
       for(int i = 0; i < path.getPathSize()-1; i++){
               Point2D a = path.get(i);
               int aX = (int)((a.getX()-lowerLeft.getX()) / xSpace);
               int aY = (int)((a.getY()-lowerLeft.getY()) / ySpace);        
               grid[aX][aY] = true;
               Point2D b = path.get(i+1);
               //caculate vector from one point to another, see if it passes through more
               //than one coordinate
               Vector2D temp = b.minus(a);
               
               if(temp.getX()!=0){
                if(temp.getX() <0){
                   while(temp.magnitude() >= xSpace){
                       a.plusEquals(new Vector2D(-xSpace ,0));
                       temp = b.minus(a);
                       aX = (int)((a.getX()-lowerLeft.getX()) / xSpace);
                       aY = (int)((a.getY()-lowerLeft.getY()) / ySpace); 
                       grid[aX][aY] = true;
                   }
                   }
                   else{
                   
                   
                   while(temp.magnitude() >= xSpace){
                       a.plusEquals(new Vector2D(xSpace ,0));
                       temp = b.minus(a);
                       aX = (int)((a.getX()-lowerLeft.getX() )/ xSpace);
                       aY = (int)((a.getY()-lowerLeft.getY()) / ySpace);
                       grid[aX][aY] = true;
                   }
                   }
                   
               }
               if(temp.getY()!=0){
                   if(temp.getY() <0){
                   while(temp.magnitude() >= ySpace){
                       a.plusEquals(new Vector2D(0, -ySpace));
                       temp = b.minus(a);
                       aX = (int)((a.getX()-lowerLeft.getX()) / xSpace);
                       aY = (int)((a.getY()-lowerLeft.getY()) / ySpace); 
                       grid[aX][aY] = true;
                   }
                   }
                   else{
                   while(temp.magnitude() >= ySpace){
                       a.plusEquals(new Vector2D(0, ySpace));
                       temp = b.minus(a);
                       aX = (int)((a.getX()-lowerLeft.getX() )/ xSpace);
                       aY = (int)((a.getY()-lowerLeft.getY()) / ySpace);
                       grid[aX][aY] = true;
                   }
                   }
                       
                   }
               }
   }
   /**
    * Checks to see if we can place something in the world.  It first sees if the
    * grid backing the world, has an obstacle in the way. If it does, it returns true,
    * so something should not be placed there.
    * @param point
    * @return 
    */
   public boolean canPlaceHere(Point2D point){
       int pX = (int)((point.getX()-lowerLeft.getX()) / xSpace);
       int pY = (int)((point.getY()-lowerLeft.getY()) / ySpace); 
       return !grid[pX][pY];
   }
   
   /**Returns the point in the upper left hand corner of the grid cell with the 
    * point that you pass in. 
    * @param point where the person is clicking
    * @return the upper left hand corner of the cell
    */
   
   public Point2D getUpperLeft(Point2D point){
       int pX = (int)((point.getX()-lowerLeft.getX()) / xSpace);
       int pY = (int)((point.getY()-lowerLeft.getY()) / ySpace); 
       return new Point2D(xSpace * pX, ySpace * pY);  
   }
   
   public void add(Point2D point){
       int pX = (int)((point.getX()-lowerLeft.getX()) / xSpace);
       int pY = (int)((point.getY()-lowerLeft.getY()) / ySpace); 
       grid[pX][pY] = true;
   }
   
   public void remove(Point2D point){
       int pX = (int)((point.getX()-lowerLeft.getX()) / xSpace);
       int pY = (int)((point.getY()-lowerLeft.getY()) / ySpace); 
       grid[pX][pY] = false;
   }
   
   public double getXSpace(){
      return xSpace; 
   }
   
   public double getYSpace(){
       return ySpace;
   }
}
