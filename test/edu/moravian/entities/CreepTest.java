/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.entities;

import edu.moravian.Path;
import edu.moravian.math.Vector2D;
import java.io.File;
import org.junit.Test;

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
        
        
    }
}
