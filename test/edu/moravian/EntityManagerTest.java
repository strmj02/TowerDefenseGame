/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

import edu.moravian.entities.Bullet;
import edu.moravian.entities.Tower;
import java.awt.image.BufferedImage;

import org.junit.Test;

/**
 *
 * @author samson
 */
public class EntityManagerTest {

    public EntityManagerTest() {
    }

    /**
     * Test of addBullet method, of class EntityManager.
     */
    @Test
    public void testAddBullet() {

      //  Bullet bullet = new Bullet();
        EntityManager instance = new EntityManager();
      //  instance.addBullet(bullet);

    }

    /**
     * Test of addTower method, of class EntityManager.
     */
    @Test
    public void testAddTower() {
        BufferedImage img = null;
        Tower tower = new Tower(img);
        EntityManager instance = new EntityManager();
        instance.addTower(tower);

    }

    /**
     * Test of addCreep method, of class EntityManager.
     */
    @Test
    public void testAddCreep() {

        //  Creep creep = new Creep();
        EntityManager instance = new EntityManager();
        //  instance.addCreep(creep);

    }

    /**
     * Test of deleteBullet method, of class EntityManager.
     */
    @Test
    public void testDeleteBullet() {

      //  Bullet bullet = new Bullet();
      //  EntityManager instance = new EntityManager();
      //  instance.deleteBullet(bullet);

    }

    /**
     * Test of deleteTower method, of class EntityManager.
     */
    @Test
    public void testDeleteTower() {
        BufferedImage img = null;
        Tower tower = new Tower(img);
        EntityManager instance = new EntityManager();
        instance.addTower(tower);
        instance.deleteTower(tower);
        //assertTrue();

    }

    /**
     * Test of deleteCreep method, of class EntityManager.
     */
    @Test
    public void testDeleteCreep() {
    //  Creep creep = new Creep();
        EntityManager instance = new EntityManager();
        // instance.deleteCreep(creep);

    }
}