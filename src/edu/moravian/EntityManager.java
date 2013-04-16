/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.moravian;

import edu.moravian.entities.Bullet;
import edu.moravian.entities.Creep;
import edu.moravian.entities.Tower;
import java.util.ArrayList;

/**
 *
 * This class keeps track of all of the entities that are alive in our world
 */
public class EntityManager {

    ArrayList<Bullet> bullets;
    ArrayList<Creep> creeps;
    ArrayList<Tower> towers;

    /**
     *
     */
    public EntityManager() {
        bullets = new ArrayList<Bullet>();
        creeps = new ArrayList<Creep>();
        towers = new ArrayList<Tower>();
    }
    
    
    public void update(double delta){
        for(Creep c : creeps){
            c.update(delta);
        }
    }

    /**
     * A method to add a bullet to the fired bullets in our world
     *
     * @param bullet the bullet to be added to our list
     */
    public void addBullet(Bullet bullet) {
        //add the new bullet to the end of the list
        bullets.add(bullet);
    }

    /**
     * A method to add a tower to the list of towers in the world
     *
     * @param tower
     */
    public void addTower(Tower tower) {
        towers.add(tower);
    }

    /**
     * A method to add a creep to the list of creeps in the world
     *
     * @param creep
     */
    public void addCreep(Creep creep) {
        creeps.add(creep);
    }

    /**
     * A method to delete a bullet from the list of bullets that have not
     * collided or died
     *
     * @param bullet
     */
    public void deleteBullet(Bullet bullet) {
        //remove the bullet from the list
        bullets.remove(bullet);
    }

    /**
     * A method to delete a tower from the list of towers in the world
     *
     * @param tower
     */
    public void deleteTower(Tower tower) {
        //remove the tower from the list
        towers.remove(tower);
    }

    /**
     * A method to delete creeps from the list of alive creeps
     *
     * @param creep
     */
    public void deleteCreep(Creep creep) {
        //remove the creep from the list
        creeps.remove(creep);
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public ArrayList<Creep> getCreeps() {
        return creeps;
    }
}