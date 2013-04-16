/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

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
        GameStates instance = new GameStates();
        double expResult = 100.0;
        double result = instance.getMoney();
        assertEquals(expResult, result, 0.0);
     
    }

    /**
     * Test of addMoney method, of class GameStates.
     */
    @Test
    public void testAddMoney() {
        
        double add = 12.0;
        GameStates instance = new GameStates();
        instance.addMoney(add);
        assertEquals(112.0, instance.getMoney(), 0);
        
    }

    /**
     * Test of subtractMoney method, of class GameStates.
     */
    @Test
    public void testSubtractMoney() {
         
        double sub = 6.0;
        GameStates instance = new GameStates();
        instance.addMoney(12);
        instance.subtractMoney(sub);
        assertEquals(106.0, instance.getMoney(), 0);
    }

    /**
     * Test of getLevel method, of class GameStates.
     */
    @Test
    public void testGetLevel() {
        GameStates instance = new GameStates();
        Level expResult = null;
        for(int i = 0; i < instance.numLevels(); i++){
            Level result = instance.getLevel(i);
            assertEquals(10 +i*5, result.getCreeps(), 0);
        }
        
        //assertEquals(expResult, result);
        
    }
}
