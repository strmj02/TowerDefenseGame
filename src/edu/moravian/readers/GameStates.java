/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

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

    public GameStates() {
        generalReader = new GeneralReader("GameStatesText.txt");
        money = generalReader.getMoney();
        levels = generalReader.getLevels();
        lives = generalReader.getPlayerLife();
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

}
