/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

import edu.moravian.Path;
import edu.moravian.entities.Creep;
import edu.moravian.math.Vector2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author samson
 */

public class GameStates {

    private double money;
    private ArrayList<Level> levels;
    private GeneralReader generalReader;
    private int lives;
    private Level currentLevel;
    private ArrayList<Creep> creeps;
    private Path path;

    public GameStates(Path path) {
        generalReader = new GeneralReader("/Network/Servers/hogwarts.cs.moravian.edu/Volumes/UserSpace/Users/johnson/NetBeansProjects/FinalProject/TowerDefenseGame/src/edu/moravian/readers/GameStatesText");
        money = generalReader.getMoney();
        levels = generalReader.getLevels();
        lives = generalReader.getPlayerLife();
        currentLevel = levels.get(0);
        this.path = path;
        
        
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double add) {
        money += add;
    }

    public void subtractMoney(double sub) {
        money -= sub;
    }

    public Level getLevel(int i) {
        return levels.get(i);
    }
    
    public int numLevels(){
        return levels.size();
    }
    
    public void initializeCreeps(){
        creeps = new ArrayList<Creep>();
        for(int i = 0; i < currentLevel.getCreeps(); i++){

            //fix this so that we can have different images
            creeps.add(new Creep(path, 5, new Vector2D(), 10));
        }
                
    }

}
