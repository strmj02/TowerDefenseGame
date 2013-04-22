/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.readers.PathReader;
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
    File file = new File("PATH.txt");
       Path path = new Path(file);
       Map map = new Map(path, 600, 800, new Point2D(0,0));
       
       assertEquals(20, map.getXSpace(), 0);
       assertEquals(20, map.getYSpace(), 0);
       assertFalse(map.canPlaceHere(new Point2D()));
       assertFalse(map.canPlaceHere(new Point2D(15, 0)));
       assertFalse(map.canPlaceHere(new Point2D(17, 13)));
       assertFalse(map.canPlaceHere(new Point2D(22, 10)));
       assertFalse(map.canPlaceHere(new Point2D(34, 19)));
       //assertFalse(map.canPlaceHere(new Point2D(105, 507)));
       //assertFalse(map.canPlaceHere(new Point2D(45, 507)));
       //assertFalse(map.canPlaceHere(new Point2D(107, 79)));
       //assertFalse(map.canPlaceHere(new Point2D(201, 79)));
       //assertFalse(map.canPlaceHere(new Point2D(206, 205)));
       //
       //assertFalse(map.canPlaceHere(new Point2D()));
       //assertFalse(map.canPlaceHere(new Point2D(0, 21)));
       //assertFalse(map.canPlaceHere(new Point2D(0, 42)));
       //assertFalse(map.canPlaceHere(new Point2D(0, 62)));
    }
}
