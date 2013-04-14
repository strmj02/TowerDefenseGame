/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

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
       File file = new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/PathText");
       PathReader reader = new PathReader(file);
       System.out.println(reader.getPath().size());
       Path path = new Path(reader.getPath());
       
      
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
       
       }
   }

