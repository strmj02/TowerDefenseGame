/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.Path;
import edu.moravian.math.Vector2D;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johnson
 */
public class CreepTest {
    
    public CreepTest() {
    }
    
    @Test
    public void creepTest(){
        File file = new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText");
        Path path = new Path(file);
        
        Creep p = new Creep(path, 8, new Vector2D(1, 1), 5);
        assertEquals(0.0, p.getLocation().getX(), 0);
        assertEquals(0, p.getLocation().getY(), 0);
        assertEquals(1.0, p.getVelocity().getX(), 0);
        assertEquals(1.0, p.getVelocity().getY(), 0);
        assertEquals(5, p.getRadius(), 0);
        
        p.update(5);
        assertEquals(5.0, p.getLocation().getX(), 0);
        assertEquals(0, p.getLocation().getY(), 0);
        p.update(5);
        p.update(5);
        p.update(5);
        p.update(5);
        p.update(5);
        p.update(5);
        p.update(5);
        assertEquals(40.0, p.getLocation().getX(), 0);
        assertEquals(0.0, p.getLocation().getY(), 0);
        p.update(5);
        assertEquals(40.0, p.getLocation().getX(), 0);
        assertEquals(5.0, p.getLocation().getY(), 0);
        
                
        
    }
}
