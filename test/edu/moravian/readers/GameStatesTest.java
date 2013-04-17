/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

import edu.moravian.Path;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStatesTest {
    
    public GameStatesTest() {
    }


    /**
     * Test of getMoney method, of class GameStates.
     */
    @Test
    public void testGetMoney() {
        Path p = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
        GameStates instance = new GameStates(p);
        double expResult = 100.0;
        double result = instance.getMoney();
        assertEquals(expResult, result, 0.0);
     
    }

    /**
     * Test of addMoney method, of class GameStates.
     */
    @Test
    public void testAddMoney() {
        Path p = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
        double add = 12.0;
        GameStates instance = new GameStates(p);
        instance.addMoney(add);
        assertEquals(112.0, instance.getMoney(), 0);
        
    }

    /**
     * Test of subtractMoney method, of class GameStates.
     */
    @Test
    public void testSubtractMoney() {
        Path p = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
        double sub = 6.0;
        GameStates instance = new GameStates(p);
        instance.addMoney(12);
        instance.subtractMoney(sub);
        assertEquals(106.0, instance.getMoney(), 0);
    }

    /**
     * Test of getLevel method, of class GameStates.
     */
    @Test
    public void testGetLevel() {
        Path p = new Path(new File("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/PathText"));
        GameStates instance = new GameStates(p);
        Level expResult = null;
        for(int i = 0; i < instance.numLevels(); i++){
            Level result = instance.getLevel(i);
            assertEquals(10 +i*5, result.getCreeps(), 0);
        }
        
        //assertEquals(expResult, result);
        
    }
}
