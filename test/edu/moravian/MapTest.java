/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.math.Point2D;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johnson
 */
public class MapTest {
    
    public MapTest() {
    }
   
    @Test
    public void testMap(){
    File file = new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/PathText");
       PathReader reader = new PathReader(file);
       Path path = new Path(reader.getPath());
       Map map = new Map(path, 600, 800, new Point2D(0,0));
       
       assertEquals(20, map.getXSpace(), 0);
       assertEquals(20, map.getYSpace(), 0);
       assertFalse(map.canPlaceHere(new Point2D()));
       assertFalse(map.canPlaceHere(new Point2D(45, 0)));
       assertFalse(map.canPlaceHere(new Point2D(105, 507)));
       assertFalse(map.canPlaceHere(new Point2D(45, 507)));
       assertFalse(map.canPlaceHere(new Point2D(107, 79)));
       assertFalse(map.canPlaceHere(new Point2D(201, 79)));
       assertFalse(map.canPlaceHere(new Point2D(206, 205)));
    }
}
