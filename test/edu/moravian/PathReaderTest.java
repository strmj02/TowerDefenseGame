/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import edu.moravian.readers.PathReader;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author johnson
 */
public class PathReaderTest {
    
    public PathReaderTest() {
    }
    
   @Test
   public void testReader(){
       File file = new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText");
       PathReader reader = new PathReader(file);
       System.out.println(reader.getPath().size());
       Path path = new Path(file);
       
      
       assertEquals(0, path.get(0).getX(), 0);
       assertEquals(0, path.get(0).getY(), 0);
       
       assertEquals(40, path.get(1).getX(), 0);
       assertEquals(0, path.get(1).getY(), 0);
       
       assertEquals(40, path.get(2).getX(), 0);
       assertEquals(500, path.get(2).getY(), 0);
       
       assertEquals(100, path.get(3).getX(), 0);
       assertEquals(500, path.get(3).getY(), 0);
       
       assertEquals(100, path.get(4).getX(), 0);
       assertEquals(60, path.get(4).getY(), 0);
       
       assertEquals(200, path.get(5).getX(), 0);
       assertEquals(60, path.get(5).getY(), 0);
       
       assertEquals(200, path.get(6).getX(), 0);
       assertEquals(200, path.get(6).getY(), 0);
       
       Point2D p = path.getNext();
       assertEquals(0, p.getX(), 0);
       assertEquals(0, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(40, p.getX(), 0);
       assertEquals(0, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(40, p.getX(), 0);
       assertEquals(500, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(100, p.getX(), 0);
       assertEquals(500, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(100, p.getX(), 0);
       assertEquals(60, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(200, p.getX(), 0);
       assertEquals(60, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(200, p.getX(), 0);
       assertEquals(200, p.getY(), 0);
       
       p = path.getNext();
       assertEquals(200, p.getX(), 0);
       assertEquals(200, p.getY(), 0);
       
       }
   
   @Test
   public void testPath(){
       File file = new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText");
       Path path = new Path(file);

   }
   }

