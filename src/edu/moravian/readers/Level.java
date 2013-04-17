/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

/**
 *
 * @author johnson
 */
public class Level {

    private int creeps; //number of creeps
    private int creepsLives;//number of times a creep can be hit
    private double time; //time in between spawns

    public Level(int creeps, int creepsLives, double time) {
        this.creeps = creeps;
        this.creepsLives = creepsLives;
        this.time = time;
    }

    public int getCreeps() {
        return creeps;
    }

    public int getCreepsLives() {
        return creepsLives;
    }

    public double getTime() {
        return time;
    }
    
    
}

