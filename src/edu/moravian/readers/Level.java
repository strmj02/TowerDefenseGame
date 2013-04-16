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

    private double creeps; //number of creeps
    private double creepsLives;//number of times a creep can be hit
    private double time; //time in between spawns

    public Level(double creeps, double creepsLives, double time) {
        this.creeps = creeps;
        this.creepsLives = creepsLives;
        this.time = time;
    }

    public double getCreeps() {
        return creeps;
    }

    public double getCreepsLives() {
        return creepsLives;
    }

    public double getTime() {
        return time;
    }
    
    
}

