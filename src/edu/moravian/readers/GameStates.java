/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

/**
 *
 * @author samson
 */

public class GameStates {

    private double money;
    private Level level;
    private GeneralReader generalReader;

    public GameStates() {
        generalReader = new GeneralReader(level);
        money = generalReader.getMoney();
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

    public Level getLevel() {
        return level;
    }
}
}
