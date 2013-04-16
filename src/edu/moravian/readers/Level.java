/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

/**
 *
 * a class to create levels for our game
 */
public class Level {

    double creeps; //number of creeps
    double creepsLives;//number of times a creep can be hit
    double time; //time in between spawns
/**
 * create a level
 * @param creeps the number of creeps in the level
 * @param creepsLives the life value that the creeps have
 * @param time  
 */
    public Level(double creeps, double creepsLives, double time) {
        this.creeps = creeps;
        this.creepsLives = creepsLives;
        this.time = time;
    }
}

