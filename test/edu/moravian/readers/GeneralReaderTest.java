/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

import java.util.ArrayList;
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
public class GeneralReaderTest {
    
    public GeneralReaderTest() {
    }
    
    @Test
    public void getVariables(){
        GeneralReader gr = new GeneralReader("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/GameStatesText");
        assertEquals(100.0, gr.getMoney(), 0);
        assertEquals(10, gr.getPlayerLife());
        assertEquals(5, gr.getLevels().size());
        
    }
    
}
