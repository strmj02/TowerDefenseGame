/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.utilities;

import edu.moravian.Path;
import edu.moravian.entities.Creep;
import edu.moravian.math.Point2D;
import edu.moravian.math.Vector2D;
import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samson
 */
public class ScoreTest {

    public ScoreTest() {
    }

    /**
     * Test of getLives method, of class Score.
     */
    @Test
    public void testGetLives() {
        Score scores = new Score(1000, 10);
        assertEquals(1000, scores.getGold());
        assertEquals(10, scores.getLives());


    }

    /**
     * Test of setLives method, of class Score.
     */
    @Test
    public void testSetLives() {
        Score scores = new Score(1000, 10);
        scores.setLives(1000);
        assertEquals(1000, scores.getGold());
        assertEquals(1000, scores.getLives());
    }

    /**
     * Test of addLives method, of class Score.
     */
    @Test
    public void testAddLives() {
        Score scores = new Score(1000, 10);
        scores.addLives(15);
        assertEquals(1000, scores.getGold());
        assertEquals(25, scores.getLives());
    }

    /**
     * Test of getGold method, of class Score.
     */
    @Test
    public void testGetGold() {
        Score scores = new Score(10, 10);
        assertEquals(10, scores.getGold());
        assertEquals(10, scores.getLives());
    }

    /**
     * Test of setGold method, of class Score.
     */
    @Test
    public void testSetGold() {
        Score scores = new Score(50, 50);
        scores.setGold(100);
        assertEquals(100, scores.getGold());
        assertEquals(50, scores.getLives());
    }

    /**
     * Test of addGold method, of class Score.
     */
    @Test
    public void testAddGold() {
        Score scores = new Score(1000, 10);
        scores.addGold(1000);
        assertEquals(2000, scores.getGold());
        assertEquals(10, scores.getLives());
    }

    /**
     * Test of update method, of class Score.
     */
    @Test
    public void testUpdate() {
        Path p = new Path(new File("path.txt"));
        //All creeps still alive and on screen so nothing should change
        Score scores = new Score(1000, 10);
        ArrayList<Creep> creeps = new ArrayList<Creep>();
        Creep creep = new Creep(p, 2, new Vector2D(2, 2), 2.0, null);
        for (int i = 0; i < 9; i++) {
            creeps.add(creep);
        }
       
        scores.update(creeps);
        assertEquals(1000, scores.getGold());
        assertEquals(10, scores.getLives());

        //some creeps die
        Score score = new Score(1000, 10);
        ArrayList<Creep> creeped = new ArrayList<Creep>();
        Creep creep2 = new Creep(p, 1, new Vector2D(2, 2), 2.0, null);
        for (int i = 0; i < 10; i++) {
            creeped.add(creep2);
        }
        for (int j = 0; j < 5; j++) {
            creep2 = creeped.get(j);
            creep2.loseLife();
        }
        scores.update(creeped);
        assertEquals(1500, scores.getGold());
        assertEquals(10, scores.getLives());


        //some creeps escape
        Score score3 = new Score(1000, 10);
        creeped = new ArrayList<Creep>();
        creep2 = new Creep(p, 1, new Vector2D(2, 2), 2.0, null);
        for (int i = 0; i < 10; i++) {
            creeped.add(creep2);
        }
        for (int j = 5; j < creeped.size(); j++) {
            creeped.get(j).getLocation().set(new Point2D(8200, 6200));
            
        }
        score3.update(creeped);
        
        assertEquals(1000, score3.getGold());
       

    }
}
