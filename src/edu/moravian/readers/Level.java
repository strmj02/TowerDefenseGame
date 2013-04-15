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

    double creeps; //number of creeps
    double creepsLives;//number of times a creep can be hit
    double time; //time in between spawns

    public Level(double creeps, double creepsLives, double time) {
        this.creeps = creeps;
        this.creepsLives = creepsLives;
        this.time = time;
    }
}

